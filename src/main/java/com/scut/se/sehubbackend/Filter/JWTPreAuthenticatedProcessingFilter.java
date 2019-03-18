package com.scut.se.sehubbackend.Filter;

import com.scut.se.sehubbackend.Config.WebConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class JWTPreAuthenticatedProcessingFilter extends AbstractPreAuthenticatedProcessingFilter {

    @Autowired
    WebConfig webConfig;

    @Autowired
    public JWTPreAuthenticatedProcessingFilter(WebAuthenticationManager webAuthenticationManager){
        setAuthenticationManager(webAuthenticationManager);
    }

    @Override
    protected Object getPreAuthenticatedPrincipal(HttpServletRequest request) {
        return getJWT(request);
    }

    @Override
    protected Object getPreAuthenticatedCredentials(HttpServletRequest request) {
        return null;
    }

    private String getJWT(HttpServletRequest request){
        return request.getHeader(webConfig.getAuthorityKey());
    }

}
