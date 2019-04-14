package com.scut.se.sehubbackend.Controller;

import com.scut.se.sehubbackend.Domain.user.UserAuthentication;
import com.scut.se.sehubbackend.Domain.user.UserHistory;
import com.scut.se.sehubbackend.Domain.user.UserInformation;
import com.scut.se.sehubbackend.Enumeration.Department;
import com.scut.se.sehubbackend.Enumeration.Position;
import com.scut.se.sehubbackend.Repository.user.UserHistoryRepository;
import com.scut.se.sehubbackend.Repository.user.UserInformationRepository;
import com.scut.se.sehubbackend.Repository.user.UserAuthenticationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Research")
public class ResearchController {

    @Autowired UserAuthenticationRepository userRepository;
    @Autowired UserInformationRepository userInformationRepository;
    @Autowired UserHistoryRepository userHistoryRepository;

    @RequestMapping("/user")
    public void addUser(){
        UserHistory userHistory=UserHistory.builder()
                .year(new Long(2017)).position(Position.Minister).department(Department.Research)
                .build();
        UserInformation userInformation=UserInformation.builder()
                .name("ptx")
                .build();
        UserAuthentication userAuthentication=UserAuthentication.builder()
                .userInformation(userInformation).userHistory(userHistory).studentNO("201730683314").password("123456")
                .build();
        userHistory.setUserAuthentication(userAuthentication);
        userInformation.setUserAuthentication(userAuthentication);

        userRepository.save(userAuthentication);
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
