package com.scut.se.sehubbackend.Config;

import com.scut.se.sehubbackend.Security.Authentication.JWTPreAuthenticatedProcessingFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    JWTPreAuthenticatedProcessingFilter jwtPreAuthenticatedProcessingFilter;

    @Autowired
    WebConfig webConfig;

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity
        httpSecurity
                .addFilterAt(jwtPreAuthenticatedProcessingFilter, AbstractPreAuthenticatedProcessingFilter.class)
                .formLogin()
                    .usernameParameter(webConfig.getUsernameParameter()).passwordParameter(webConfig.getPasswordParameter())
                    .loginPage(webConfig.getLoginPage());

    }

}
