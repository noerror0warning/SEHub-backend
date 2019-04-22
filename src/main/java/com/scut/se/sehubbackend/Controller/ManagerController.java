package com.scut.se.sehubbackend.Controller;

import com.scut.se.sehubbackend.Others.Response;
import com.scut.se.sehubbackend.Service.ManagerService;
import com.scut.se.sehubbackend.UserDAORequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/manager")
public class ManagerController {

    @Autowired ManagerService managerService;

    @PostMapping("/user")
    Response createUser(@RequestBody UserDAORequest userDAORequest){
        return managerService.createUser(userDAORequest);
    }

}
