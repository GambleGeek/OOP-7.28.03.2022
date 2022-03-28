package com.adiskerimov.spring.mvc_hibernate_aop.controller;

import com.adiskerimov.spring.mvc_hibernate_aop.entity.Client;
import com.adiskerimov.spring.mvc_hibernate_aop.entity.Employee;
import com.adiskerimov.spring.mvc_hibernate_aop.entity.Tour;
import com.adiskerimov.spring.mvc_hibernate_aop.entity.TourTask;
import com.adiskerimov.spring.mvc_hibernate_aop.service.ServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
            return "redirect:/director/clientList";
        }
    }

    @RequestMapping("/updateClient")
    public String updateClient(@RequestParam("clientId") int id, Model model){

        Client client = (Client) serviceI.get(id);
        model.addAttribute("newClient", client);

        return "client-info";
    }

    @RequestMapping("/deleteClient")
    public String deleteClient(@RequestParam("clientId") int id){
        serviceI.delete(id);

        return "redirect:/director/clientList";
    }

    @GetMapping("/employeeList")
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
        if (bindingResult.hasFieldErrors()){
            return "employee-info";

        }else{
            serviceI.saveEmployee(employee);
            return "redirect:/director/employeeList";
        }
    }

    @RequestMapping("/updateEmployee")
    public String updateEmployee(@RequestParam("employeeId") int id, Model model){

        Employee employee = (Employee) serviceI.get(id);
        model.addAttribute("newEmployee", employee);

        return "employee-info";
    }

    @RequestMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam("employeeId") int id){
        serviceI.delete(id);

        return "redirect:/director/employeeList";
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
