package com.scut.se.sehubbackend.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Research")
public class ResearchController {

    @RequestMapping("/test")
    String hello(){
        return "Hello!";
    }
}
