package com.scut.se.sehubbackend.Security.Authentication;

import com.scut.se.sehubbackend.Config.WebConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class UsernamePasswordAuthenticationProcessingFilter extends UsernamePasswordAuthenticationFilter {

    @Autowired
    UsernamePasswordAuthenticationProcessingFilter(ProviderManager providerManager, WebConfig webConfig){
        setAuthenticationManager(providerManager);
        setUsernameParameter(webConfig.getUsernameParameter());
        setPasswordParameter(webConfig.getPasswordParameter());
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response){
        String username = obtainUsername(request);
        String password = obtainPassword(request);
        if (username==null||password==null)
            return null;
        return new UsernamePasswordAuthenticationToken(username,password);
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        Authentication attempt=attemptAuthentication(request,response);
        Authentication result=getAuthenticationManager().authenticate(attempt);
        if (result!=null)
            SecurityContextHolder.getContext().setAuthentication(result);
        chain.doFilter(req,res);
    }

}
