package com.adiskerimov.spring.mvc_hibernate_aop.controller;

import com.adiskerimov.spring.mvc_hibernate_aop.entity.Tour;
import com.adiskerimov.spring.mvc_hibernate_aop.entity.TourTask;
import com.adiskerimov.spring.mvc_hibernate_aop.service.ServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tour-manager")
public class TourManagerController {

    @Autowired
    private ServiceI serviceI;

    public String menu(){
        return "view-for-tour-manager";
    }

    @GetMapping("/tourtask/add")
    public String addTourTask(Model model){
        TourTask tourTask = new TourTask();
        model.addAttribute("tourTask", tourTask);
        return "tour-task-add";
    }

    @PostMapping("/tourtask")
    public String saveTourTask(@RequestBody TourTask tourTask){
        serviceI.saveTourTask(tourTask);
        return "redirect:/";
    }

    @GetMapping("/tour/add")
    public String addTour(Model model){
        Tour tour = new Tour();
        model.addAttribute("tour", tour);
        return "tour-add";
    }

    @PostMapping("/tour")
    public String saveTour(@RequestBody Tour tour){
        serviceI.saveTour(tour);
        return "redirect:/";
    }
}
