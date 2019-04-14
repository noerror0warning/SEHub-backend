package com.scut.se.sehubbackend.Security.Authentication.provider;

import com.scut.se.sehubbackend.Domain.user.UserAuthentication;
import com.scut.se.sehubbackend.Domain.user.UserAuthorityRecord;
import com.scut.se.sehubbackend.Repository.user.UserAuthenticationRepository;
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

    @Autowired
    UserAuthenticationRepository userRepository;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        Optional<UserAuthentication> userOptional=userRepository.findById((String) authentication.getPrincipal());//查找用户信息
        if (!userOptional.isPresent()||!((String)userOptional.get().getPassword()).equals(((String)authentication.getCredentials())))//若未找到或密码错误
            throw new AuthenticationServiceException("Fail to find the user");
        else {//正确时授权认证
            return new UsernamePasswordAuthenticationToken(
                    userOptional.get(),
                    null,
                    UserAuthorityRecord.toGrantedAuthorities(userOptional.get().getAuthorityRecords())
            );
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
