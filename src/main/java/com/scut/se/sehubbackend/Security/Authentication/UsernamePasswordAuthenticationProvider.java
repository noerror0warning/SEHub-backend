package com.scut.se.sehubbackend.Security.Authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserCache;
import org.springframework.security.core.userdetails.UserDetails;

public class UsernamePasswordAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    UserCache userCache;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        UserDetails userDetails=userCache.getUserFromCache((String) authentication.getPrincipal());//查找用户信息
        if (userDetails==null||userDetails.getPassword()!=authentication.getCredentials())//若未找到或密码错误
            return null;
        else {//正确时授权认证
            return new UsernamePasswordAuthenticationToken(
                    authentication.getPrincipal(),
                    authentication.getCredentials(),
                    userDetails.getAuthorities()
            );
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
