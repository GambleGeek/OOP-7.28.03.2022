package com.adiskerimov.spring.mvc_hibernate_aop.controller;

import com.adiskerimov.spring.mvc_hibernate_aop.entity.Client;
import com.adiskerimov.spring.mvc_hibernate_aop.service.ServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/director")
public class DirectorController {

    @Autowired
    private ServiceI serviceI;

    public String menu(){
        return "view-for-director";
    }

    @GetMapping("/clientList")
    public String showAllClients(Model model){

        List<Client> allClients = serviceI.getAllClients();
        model.addAttribute("allClients", allClients);

        return "all-clients";
    }

    @RequestMapping("/addNewClient")
    public String addNewClient(Model model){

        Client client = new Client();
        model.addAttribute("newClient", client);

        return "client-info";
    }


    @RequestMapping("/saveClient")
    public String saveClient(@ModelAttribute("newClient")
                             @Valid final Client client,
                             final BindingResult bindingResult){
        if (bindingResult.hasFieldErrors()){
            return "client-info";

        }else{
            serviceI.saveClient(client);
            return "redirect:/clientList";
        }
    }

    @RequestMapping("/updateClient")
    public String updateClient(@RequestParam("clientId") int id, Model model){

        Client client = serviceI.getClient(id);
        model.addAttribute("newClient", client);

        return "client-info";
    }

    @RequestMapping("/deleteClient")
    public String deleteClient(@RequestParam("clientId") int id){
        serviceI.delete(id);

        return "redirect:/director/clientList";
    }
}
