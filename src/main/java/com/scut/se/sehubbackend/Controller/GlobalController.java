package com.scut.se.sehubbackend.Controller;

import com.scut.se.sehubbackend.Service.AuthorizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GlobalController {

    @Autowired
    AuthorizeService authorizeService;

}
