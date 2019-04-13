package com.scut.se.sehubbackend.Controller;

import com.scut.se.sehubbackend.Repository.user.UserInformationRepository;
import com.scut.se.sehubbackend.Repository.user.UserAuthenticationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Research")
public class ResearchController {

    @Autowired
    UserAuthenticationRepository userRepository;
    @Autowired
    UserInformationRepository userInformationRepository;

    @RequestMapping("/user")
    public void addUser(){

    }

    @RequestMapping("/userDetail")
    public void addUserDetail(){

    }

    @RequestMapping("/bothWithout")
    public void addBothWith(){

    }

    @RequestMapping("/bothWith")
    public void addBothWithout() {

    }
}
