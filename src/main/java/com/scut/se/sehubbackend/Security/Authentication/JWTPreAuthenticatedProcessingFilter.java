package com.scut.se.sehubbackend.Security.Authentication;

import com.scut.se.sehubbackend.Config.WebConfig;
import com.scut.se.sehubbackend.JWT.JWTManager;
import org.jose4j.jwt.MalformedClaimException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class JWTPreAuthenticatedProcessingFilter extends AbstractPreAuthenticatedProcessingFilter {

    private String authorityKey;
    @Autowired JWTManager jwtManager;

    @Autowired
    public JWTPreAuthenticatedProcessingFilter(WebAuthenticationManager webAuthenticationManager,WebConfig webConfig){
        setAuthenticationManager(webAuthenticationManager);
        authorityKey=webConfig.getAuthorityKey();
    }

    @Override
    protected Object getPreAuthenticatedPrincipal(HttpServletRequest request) {
        try {
            return jwtManager.decode(getJWT(request));
        } catch (MalformedClaimException e) {
            return null;
        }
    }

    @Override
    protected Object getPreAuthenticatedCredentials(HttpServletRequest request) {
        return "";
    }

    private String getJWT(HttpServletRequest request){
        return request.getHeader(authorityKey);
    }

}
