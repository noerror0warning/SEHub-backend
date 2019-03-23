package com.scut.se.sehubbackend.Config;

import com.scut.se.sehubbackend.Domain.User;
import com.scut.se.sehubbackend.Security.Authentication.InMemoryUserCahe;
import com.scut.se.sehubbackend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.authority.mapping.GrantedAuthoritiesMapper;
import org.springframework.security.core.authority.mapping.NullAuthoritiesMapper;
import org.springframework.security.core.userdetails.UserCache;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Configuration
public class AuthorizationConfig {

    @Autowired
    UserRepository userRepository;

    @Bean
    UserCache userCache(){
        UserCache cache=new InMemoryUserCahe();
        List<User> userList= userRepository.findAll();
        for (User user:userList) {

        }
        return cache;
    }

    @Bean
    GrantedAuthoritiesMapper grantedAuthoritiesMapper(){
        return new NullAuthoritiesMapper();
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
