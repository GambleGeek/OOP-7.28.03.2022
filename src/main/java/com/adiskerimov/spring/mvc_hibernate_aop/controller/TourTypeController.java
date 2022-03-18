package com.adiskerimov.spring.mvc_hibernate_aop.controller;

import com.adiskerimov.spring.mvc_hibernate_aop.entity.TourType;
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
public class TourTypeController {

    @Autowired
    private ServiceI serviceI;

    @RequestMapping("/tourTypeList")
    public String showAllTourTypes(Model model){

        List<TourType> allTourTypes = serviceI.getAllTourTypes();
        model.addAttribute("allTourTypes", allTourTypes);

        return "all-tourtypes";
    }

    @RequestMapping("/addNewTourType")
    public String addNewTourType(Model model){

        TourType tourType = new TourType();
        model.addAttribute("newTourType", tourType);

        return "tourtype-info";
    }


    @RequestMapping("/saveTourType")
    public String saveTourType(@ModelAttribute("newTourType")
                              @Valid final TourType tourType,
                              final BindingResult bindingResult){
        if(bindingResult.hasFieldErrors()){
            return "tourtype-info";
        }
        serviceI.saveTourType(tourType);
        return "redirect:/tourTypeList";
    }
}
