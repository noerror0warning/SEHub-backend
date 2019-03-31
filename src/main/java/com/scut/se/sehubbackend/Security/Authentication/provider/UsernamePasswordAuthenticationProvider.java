package com.scut.se.sehubbackend.Security.Authentication.provider;

import com.scut.se.sehubbackend.Domain.User;
import com.scut.se.sehubbackend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UsernamePasswordAuthenticationProvider implements AuthenticationProvider {

    @Autowired UserRepository userRepository;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        Optional<User> userOptional=userRepository.findById((String) authentication.getPrincipal());//查找用户信息
        if (!userOptional.isPresent()||userOptional.get().getPassword()!=authentication.getCredentials())//若未找到或密码错误
            throw new AuthenticationServiceException("Fail to find the user");
        else {//正确时授权认证
            return new UsernamePasswordAuthenticationToken(
                    authentication.getPrincipal(),
                    null,
                    userOptional.get().getAuthorities()
            );
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
