package com.adiskerimov.spring.mvc_hibernate_aop.controller;

import com.adiskerimov.spring.mvc_hibernate_aop.entity.Client;
import com.adiskerimov.spring.mvc_hibernate_aop.entity.Employee;
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
public class MyController {

    @Autowired
    private ServiceI serviceI;

    @RequestMapping("/clientList")
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

        Client client = serviceI.get(id);
        model.addAttribute("newClient", client);

        return "client-info";
    }

    @RequestMapping("/deleteClient")
    public String deleteClient(@RequestParam("clientId") int id){
        serviceI.delete(id);

        return "redirect:/clientList";
    }

    @RequestMapping("/employeeList")
    public String showAllEmployees(Model model){

        List<Employee> allEmployees = serviceI.getAllEmployees();
        model.addAttribute("allEmployees", allEmployees);

        return "all-employees";
    }

    @RequestMapping("/addNewEmployee")
    public String addNewEmployee(Model model){

        Employee employee = new Employee();
        model.addAttribute("newEmployee", employee);

        return "employee-info";
    }

    @RequestMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("newEmployee")
                             @Valid final Employee employee,
                             final BindingResult bindingResult){
        if(bindingResult.hasFieldErrors()){
            return "employee-info";
        }
        serviceI.saveEmployee(employee);
        return "redirect:/employeeList";
    }

    @GetMapping("/")
    public String getInfoForAllEmps(){
        return "all-employees";
    }

    @GetMapping("/hr_info")
    public String getInfoOnlyForHR(){
        return "view-for-hr";
    }

    @GetMapping("/manager_info")
    public String getInfoOnlyForManager(){
        return "view-for-manager";
    }

}
