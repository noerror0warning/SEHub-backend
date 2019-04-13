package com.scut.se.sehubbackend.Config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig {

    @Value("${request.uri.login}")
    @Getter
    String loginPage;

    @Getter
    String usernameParameter;

    @Getter
    String passwordParameter;


    @Value("${request.header.authority}")
    @Getter
    String authorityKey;


}
