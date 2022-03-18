package com.adiskerimov.spring.mvc_hibernate_aop.controller;

import com.adiskerimov.spring.mvc_hibernate_aop.entity.Program;
import com.adiskerimov.spring.mvc_hibernate_aop.entity.TourTask;
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
public class TourTaskController {

    @Autowired
    private ServiceI serviceI;

    @RequestMapping("/tourTaskList")
    public String showAllTourTasks(Model model){

        List<TourTask> allTourTasks = serviceI.getAllTourTasks();
        model.addAttribute("allTourTasks", allTourTasks);

        return "all-tourtasks";
    }

    @RequestMapping("/addNewTourTask")
    public String addNewTourTask(Model model){

        TourTask tourTask = new TourTask();
        model.addAttribute("newTourTask", tourTask);

        return "tourtask-info";
    }


    @RequestMapping("/saveTourTask")
    public String saveProgram(@ModelAttribute("newTourTask")
                              @Valid final TourTask tourTask,
                              final BindingResult bindingResult){
        if(bindingResult.hasFieldErrors()){
            return "tourtask-info";
        }
        serviceI.saveTourTask(tourTask);
        return "redirect:/tourTaskList";
    }
}
