package com.scut.se.sehubbackend.Filter;

import com.scut.se.sehubbackend.Config.WebConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = "/")
@Component
public class JWTFilter extends OncePerRequestFilter {

    @Autowired
    WebConfig webConfig;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if(hasJWT(request)||isLogin(request))//如果带着jwt或者正在登陆，就允许访问
            filterChain.doFilter(request,response);
        else
            response.setStatus(401);
    }

    private boolean isLogin(HttpServletRequest request){
        return request.getRequestURI().equals(webConfig.getLoginURI());
    }

    private boolean hasJWT(HttpServletRequest request){
        return request.getHeader(webConfig.getAuthorityKey())!=null;
    }

}
