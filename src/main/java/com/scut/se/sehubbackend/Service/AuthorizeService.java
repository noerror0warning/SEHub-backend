package com.scut.se.sehubbackend.Service;

import com.scut.se.sehubbackend.Domain.User;
import com.scut.se.sehubbackend.Enumeration.AuthorityOperation;
import com.scut.se.sehubbackend.JWT.JWTManager;
import com.scut.se.sehubbackend.Repository.UserRepository;
import com.scut.se.sehubbackend.Security.Authorization.interfaces.AuthorityManager;
import com.scut.se.sehubbackend.Security.Authorization.interfaces.AuthorizationDecisionManager;
import org.jose4j.lang.JoseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Map;
import java.util.Optional;

/**
 * 提供登陆、权限变动相关的服务<br/>
 * <span>
 *     <li>登陆服务负责返回认证后的{@code jwt}</li>
 *     <li>
 *         权限变动流程分为三步:<br/>
 *         变更权限请求到来->{@link AuthorizeService#decisionManager}决策是否有权变更->{@link AuthorizeService#authorityManager}执行
 *     </li>
 * </span>
 */
@Service
@CrossOrigin
public class AuthorizeService {

    @Autowired UserRepository userRepository;
    @Autowired JWTManager jwtManager;
    @Autowired AuthorizationDecisionManager decisionManager;
    @Autowired AuthorityManager authorityManager;

    /**
     * 提供登陆后的凭证
     * @param user 具体的登陆用户
     * @return 编码后得到的jwt
     */
    public String login(User user) throws JoseException {
        return jwtManager.encode(user);
    }

    /**
     * 授权操作，实际由由{@link #dynamicAuthorityOperation(User, String, AuthorityOperation)}代理
     * @param userToAuthorize 被变更者
     * @param dynamicAuthority 目标权限
     * @return
     */
    public ResponseEntity<Map<String,Object>> authorize(User userToAuthorize, String dynamicAuthority){
        return dynamicAuthorityOperation(userToAuthorize,dynamicAuthority,AuthorityOperation.AUTHORIZATION);
    }

    /**
     * 解权操作，实际由{@link #dynamicAuthorityOperation(User, String, AuthorityOperation)}代理
     * @param userToAuthorize 被变更者
     * @param dynamicAuthority 目标权限
     * @return
     */
    public ResponseEntity<Map<String,Object>> deauthorize(User userToAuthorize, String dynamicAuthority){
        return dynamicAuthorityOperation(userToAuthorize,dynamicAuthority,AuthorityOperation.DEAUTHORIZATION);
    }

    /**
     * 代理权限的具体操作
     * @param userToAuthorize 被变更者
     * @param dynamicAuthority 目标权限
     * @param operation 具体的操作，见{@link AuthorityOperation}
     * @return 请求实体
     */
    private ResponseEntity<Map<String,Object>> dynamicAuthorityOperation(User userToAuthorize, String dynamicAuthority, AuthorityOperation operation){
        GrantedAuthority authority=authorityManager.generateAuthority(dynamicAuthority);//根据请求生成权限
        Optional<User> user=userRepository.findById(userToAuthorize.getStudentNO());//查找被授权人
        Authentication authentication=SecurityContextHolder.getContext().getAuthentication();//当前线程的认证情况
        Optional<User> operatorOptional=userRepository.findById((String)authentication.getPrincipal());//获得操作者
        if(!operatorOptional.isPresent()||!user.isPresent()||authority==null)//未找到被授权人或没有对应的权限
            return new ResponseEntity<Map<String, Object>>(HttpStatus.BAD_REQUEST);

        //找到被授权人时
        if (decisionManager.decide(operatorOptional.get(),user.get(),authority)){//是否允许权限变更
            Boolean result;
            switch (operation){
                case AUTHORIZATION:result=authorityManager.addAuthority(user.get(),authority);
                case DEAUTHORIZATION:result=authorityManager.removeAuthority(user.get(),authority);
                default: result=false;
            }
            if(result) return new ResponseEntity<Map<String, Object>>(HttpStatus.ACCEPTED);//成功变更
            else return new ResponseEntity<Map<String, Object>>(HttpStatus.INTERNAL_SERVER_ERROR);//内部错误导致失败
        } else
            return new ResponseEntity<Map<String, Object>>(HttpStatus.UNAUTHORIZED);//无权变更
    }

}
