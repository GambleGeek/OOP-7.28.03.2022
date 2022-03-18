package com.adiskerimov.spring.mvc_hibernate_aop.controller;

import com.adiskerimov.spring.mvc_hibernate_aop.entity.Order;
import com.adiskerimov.spring.mvc_hibernate_aop.entity.Program;
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
public class ProgramController {

    @Autowired
    private ServiceI serviceI;

    @RequestMapping("/programList")
    public String showAllPrograms(Model model){

        List<Program> allPrograms = serviceI.getAllPrograms();
        model.addAttribute("allPrograms", allPrograms);

        return "all-programs";
    }

    @RequestMapping("/addNewProgram")
    public String addNewProgram(Model model){

        Program program =new Program();
        model.addAttribute("newProgram", program);

        return "program-info";
    }


    @RequestMapping("/saveProgram")
    public String saveProgram(@ModelAttribute("newProgram")
                            @Valid final Program program,
                            final BindingResult bindingResult){
        if(bindingResult.hasFieldErrors()){
            return "program-info";
        }
        serviceI.saveProgram(program);
        return "redirect:/programList";
    }
}
