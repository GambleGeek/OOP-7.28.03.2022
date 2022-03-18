package com.adiskerimov.spring.mvc_hibernate_aop.controller;

import com.adiskerimov.spring.mvc_hibernate_aop.entity.Client;
import com.adiskerimov.spring.mvc_hibernate_aop.entity.Order;
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
public class OrderController {

    @Autowired
    private ServiceI serviceI;

    @RequestMapping("/orderList")
    public String showAllOrders(Model model){

        List<Order> allOrders = serviceI.getAllOrders();
        model.addAttribute("allOrders", allOrders);

        return "all-orders";
    }

    @RequestMapping("/addNewOrder")
    public String addNewOrder(Model model){

        Order order =new Order();
        model.addAttribute("newOrder", order);

        return "order-info";
    }


    @RequestMapping("/saveOrder")
    public String saveOrder(@ModelAttribute("newOrder")
                             @Valid final Order order,
                             final BindingResult bindingResult){
        if(bindingResult.hasFieldErrors()){
            return "order-info";
        }
        serviceI.saveOrder(order);
        return "redirect:/orderList";
    }
}
