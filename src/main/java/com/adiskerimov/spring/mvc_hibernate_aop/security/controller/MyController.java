package com.adiskerimov.spring.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {

    @GetMapping("/")
    public String getInfoForAllEmps(){
        return "basic";
    }

    @GetMapping("/hr_info")
    public String getInfoOnlyForHR(){
        return "view-for-tour-creator";
    }

    @GetMapping("/manager_info")
    public String getInfoOnlyForManager(){
        return "view-for-tour-manager";
    }
}
