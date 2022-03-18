package com.adiskerimov.spring.mvc_hibernate_aop.controller;

import com.adiskerimov.spring.mvc_hibernate_aop.entity.Program;
import com.adiskerimov.spring.mvc_hibernate_aop.entity.Tourist;
import com.adiskerimov.spring.mvc_hibernate_aop.service.ServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;
@Controller
public class TouristController {

    @Autowired
    private ServiceI serviceI;

    @RequestMapping("/touristList")
    public String showAllTourists(Model model){

        List<Tourist> allTourists = serviceI.getAllTourists();
        model.addAttribute("allTourists", allTourists);

        return "all-tourists";
    }

    @RequestMapping("/addNewTourist")
    public String addNewTourist(Model model){

        Tourist tourist = new Tourist();
        model.addAttribute("newTourist", tourist);

        return "tourist-info";
    }


    @RequestMapping("/saveTourist")
    public String saveTourist(@ModelAttribute("newTourist")
                              @Valid final Tourist tourist,
                              final BindingResult bindingResult){
        if(bindingResult.hasFieldErrors()){
            return "tourist-info";
        }
        serviceI.saveTourist(tourist);
        return "redirect:/touristList";
    }
}
