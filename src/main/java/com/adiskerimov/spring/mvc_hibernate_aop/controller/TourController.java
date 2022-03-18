package com.adiskerimov.spring.mvc_hibernate_aop.controller;

import com.adiskerimov.spring.mvc_hibernate_aop.entity.Program;
import com.adiskerimov.spring.mvc_hibernate_aop.entity.Tour;
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
public class TourController {

    @Autowired
    private ServiceI serviceI;

    @RequestMapping("/tourList")
    public String showAllTours(Model model){

        List<Tour> allTours = serviceI.getAllTours();
        model.addAttribute("allTours", allTours);

        return "all-tours";
    }

    @RequestMapping("/addNewTour")
    public String addNewTour(Model model){

        Tour tour = new Tour();
        model.addAttribute("newTour", tour);

        return "tour-info";
    }


    @RequestMapping("/saveTour")
    public String saveTour(@ModelAttribute("newTour")
                              @Valid final Tour tour,
                              final BindingResult bindingResult){
        if(bindingResult.hasFieldErrors()){
            return "tour-info";
        }
        serviceI.saveTour(tour);
        return "redirect:/tourList";
    }
}
