package com.adiskerimov.spring.mvc_hibernate_aop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sales-manager")
public class SalesManagerController {

    public String menu(){
        return "view-for-sales-manager";
    }
}
