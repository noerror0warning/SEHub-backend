package com.scut.se.sehubbackend.Service;

import com.scut.se.sehubbackend.Domain.User;
import com.scut.se.sehubbackend.JWT.JWTManager;
import com.scut.se.sehubbackend.Repository.UserRepository;
import org.jose4j.lang.JoseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class AuthorizeService {

    @Autowired UserRepository userRepository;
    @Autowired JWTManager jwtManager;
    @Autowired AuthorizationDecisonManager decisonManager;
    @Autowired AuthorityManager authorityManager;

    public String login(User user) throws JoseException {
        return jwtManager.encode(user);
    }

    public ResponseEntity<Map<String,Object>> dynamicAuthorize(User userToAuthorize,String dynamicAuthority){
        GrantedAuthority authority=new SimpleGrantedAuthority("");//根据请求生成权限
        Optional<User> user=userRepository.findById(userToAuthorize.getStudentNO());//查找被授权人
        if(!user.isPresent()||authority==null)//未找到被授权人或没有对应的权限
            return new ResponseEntity<Map<String, Object>>(HttpStatus.BAD_REQUEST);

        //找到被授权人时
        if (decisonManager.decide(user.get(),authority)){//是否允许权限变更
            if (authorityManager.addAuthority(user.get(),authority))//是否成功变更权限
                return new ResponseEntity<Map<String, Object>>(HttpStatus.ACCEPTED);
            else
                return new ResponseEntity<Map<String, Object>>(HttpStatus.INTERNAL_SERVER_ERROR);
        } else
            return new ResponseEntity<Map<String, Object>>(HttpStatus.UNAUTHORIZED);
    }

}
