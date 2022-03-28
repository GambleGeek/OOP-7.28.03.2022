package com.adiskerimov.spring.mvc_hibernate_aop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tour-manager")
public class TourManagerController {

    public String menu(){
        return "view-for-tour-manager";
    }
}
