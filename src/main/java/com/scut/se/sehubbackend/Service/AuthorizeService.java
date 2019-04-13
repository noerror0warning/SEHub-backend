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
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class AuthorizeService {

    @Autowired UserRepository userRepository;
    @Autowired JWTManager jwtManager;
    @Autowired AuthorizationDecisionManager decisionManager;
    @Autowired AuthorityManager authorityManager;

    public String login(User user) throws JoseException {
        return jwtManager.encode(user);
    }

    //授予权限
    public ResponseEntity<Map<String,Object>> authorize(User userToAuthorize, String dynamicAuthority){
        return dynamicAuthorityOperation(userToAuthorize,dynamicAuthority,AuthorityOperation.AUTHORIZATION);
    }

    //移除权限
    public ResponseEntity<Map<String,Object>> deauthorize(User userToAuthorize, String dynamicAuthority){
        return dynamicAuthorityOperation(userToAuthorize,dynamicAuthority,AuthorityOperation.DEAUTHORIZATION);
    }

    //执行具体的权限操作
    private ResponseEntity<Map<String,Object>> dynamicAuthorityOperation(User userToAuthorize, String dynamicAuthority, AuthorityOperation operation){
        GrantedAuthority authority=authorityManager.generateAuthority(dynamicAuthority);//根据请求生成权限
        Optional<User> user=userRepository.findById(userToAuthorize.getStudentNO());//查找被授权人
        User operator=(User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();//获取授权操作者
        if(operator==null||!user.isPresent()||authority==null)//未找到被授权人或没有对应的权限
            return new ResponseEntity<Map<String, Object>>(HttpStatus.BAD_REQUEST);

        //找到被授权人时
        if (decisionManager.decide(operator,user.get(),authority)){//是否允许权限变更
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
