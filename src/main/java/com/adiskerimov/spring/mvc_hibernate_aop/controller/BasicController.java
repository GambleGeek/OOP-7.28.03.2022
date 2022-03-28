package com.adiskerimov.spring.mvc_hibernate_aop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class BasicController {

    public String basic(){
        return "basic";
    }
}
