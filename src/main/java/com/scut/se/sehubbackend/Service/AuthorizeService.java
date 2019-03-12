package com.scut.se.sehubbackend.Service;

import com.scut.se.sehubbackend.Domain.User;
import com.scut.se.sehubbackend.JWT.JWTManager;
import com.scut.se.sehubbackend.Repository.UserRepository;
import org.jose4j.lang.JoseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorizeService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    JWTManager jwtManager;

    public String login(User user){
        Optional<User> result= userRepository.findById(user.getStudentNO());
        if (result.isPresent()&&result.get().getPassword()==user.getPassword()) {//查询结果不为空且密码正确时
            try {
                return jwtManager.encode(user);//生成jwt并返回
            } catch (JoseException e) {
                e.printStackTrace();
            }
        }
        return null;//登陆失败时返回null
    }
}
