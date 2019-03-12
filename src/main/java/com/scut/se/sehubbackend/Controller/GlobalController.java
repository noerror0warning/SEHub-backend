package com.scut.se.sehubbackend.Controller;

import com.scut.se.sehubbackend.Domain.User;
import com.scut.se.sehubbackend.Service.AuthorizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GlobalController {

    @Autowired
    AuthorizeService authorizeService;

    @PostMapping("${request.uri.login}")
    public String login(@RequestBody User user){//处理用户登陆
        return authorizeService.login(user);
    }
}
