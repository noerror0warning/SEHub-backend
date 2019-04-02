package com.scut.se.sehubbackend.Controller;

import com.scut.se.sehubbackend.Domain.User;
import com.scut.se.sehubbackend.Domain.UserDetailRepository;
import com.scut.se.sehubbackend.Domain.UserRepository;
import com.scut.se.sehubbackend.Enumeration.Department;
import com.scut.se.sehubbackend.Enumeration.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Research")
public class ResearchController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserDetailRepository userDetailRepository;

    @RequestMapping("/user")
    public void addUser(){
        User user=User.builder()
                .studentNO("2010")
                .department(Department.Research)
                .position(Position.Minister)
                .password("123")
                .grantedAuthority(new SimpleGrantedAuthority("aaa"))
                .grantedAuthority(new SimpleGrantedAuthority("bbb"))
                .grantedAuthority(new SimpleGrantedAuthority("ccc"))
                .build();
        userRepository.saveAndFlush(user);
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
