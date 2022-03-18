package com.adiskerimov.spring.mvc_hibernate_aop.controller;

import com.adiskerimov.spring.mvc_hibernate_aop.entity.Program;
import com.adiskerimov.spring.mvc_hibernate_aop.entity.TourPackage;
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
public class TourPackageController {

    @Autowired
    private ServiceI serviceI;

    @RequestMapping("/tourPackageList")
    public String showAllTourPackages(Model model){

        List<TourPackage> allTourPackages = serviceI.getAllTourPackages();
        model.addAttribute("allTourPackages", allTourPackages);

        return "all-tourpackages";
    }

    @RequestMapping("/addNewTourPackage")
    public String addNewTourPackage(Model model){

        TourPackage tourPackage = new TourPackage();
        model.addAttribute("newTourPackage", tourPackage);

        return "tourpackage-info";
    }


    @RequestMapping("/saveTourPackage")
    public String saveTourPackage(@ModelAttribute("newTourPackage")
                              @Valid final TourPackage tourPackage,
                              final BindingResult bindingResult){
        if(bindingResult.hasFieldErrors()){
            return "tourpackage-info";
        }
        serviceI.saveTourPackage(tourPackage);
        return "redirect:/tourPackageList";
    }
}
