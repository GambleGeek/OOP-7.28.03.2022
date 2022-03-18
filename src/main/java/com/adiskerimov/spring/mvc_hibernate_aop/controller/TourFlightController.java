package com.adiskerimov.spring.mvc_hibernate_aop.controller;

import com.adiskerimov.spring.mvc_hibernate_aop.entity.Program;
import com.adiskerimov.spring.mvc_hibernate_aop.entity.TourFlight;
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
public class TourFlightController {

    @Autowired
    private ServiceI serviceI;

    @RequestMapping("/tourFlightList")
    public String showAllTourFlights(Model model){

        List<TourFlight> allTourFlights = serviceI.getAllTourFlights();
        model.addAttribute("allTourFlights", allTourFlights);

        return "all-tourflights";
    }

    @RequestMapping("/addNewTourFlight")
    public String addNewTourFlight(Model model){

        TourFlight tourFlight = new TourFlight();
        model.addAttribute("newTourFlight", tourFlight);

        return "tourflight-info";
    }


    @RequestMapping("/saveTourFlight")
    public String saveTourFlight(@ModelAttribute("newTourFlight")
                              @Valid final TourFlight tourFlight,
                              final BindingResult bindingResult){
        if(bindingResult.hasFieldErrors()){
            return "tourflight-info";
        }
        serviceI.saveTourFlight(tourFlight);
        return "redirect:/tourFlightList";
    }
}
