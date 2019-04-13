package com.scut.se.sehubbackend.Security.Authentication;

import com.scut.se.sehubbackend.Security.JWT.JWTManager;
import org.jose4j.jwt.MalformedClaimException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.mapping.GrantedAuthoritiesMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class JWTAuthenticationProvider implements AuthenticationProvider {

    @Resource(name = "inMemoryUserDetailService")
    UserDetailsService userDetailsService;

    @Autowired
    JWTManager jwtManager;

    @Autowired
    GrantedAuthoritiesMapper grantedAuthoritiesMapper;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        UserDetails userDetails=null;//将要认证的用户信息
        String jwt=(String) authentication.getPrincipal();//获取jwt

        if(jwt==null)//不携带jwt时直接跳过认证
            return null;
        try {
            String studentNO=jwtManager.decode(jwt).getStudentNO();//对jwt解码并获得学号
            userDetails=userDetailsService.loadUserByUsername(studentNO);//加载用户信息
        } catch (MalformedClaimException e) {
            e.printStackTrace();
        }
        if(userDetails==null)//未找到用户
            return null;
        UsernamePasswordAuthenticationToken token=new UsernamePasswordAuthenticationToken(//成功验证并生成授权
                userDetails.getUsername(),
                userDetails.getPassword(),
                grantedAuthoritiesMapper.mapAuthorities(userDetails.getAuthorities())
        );
        return token;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
