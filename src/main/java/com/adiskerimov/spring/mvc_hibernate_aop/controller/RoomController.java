package com.adiskerimov.spring.mvc_hibernate_aop.controller;

import com.adiskerimov.spring.mvc_hibernate_aop.entity.Program;
import com.adiskerimov.spring.mvc_hibernate_aop.entity.Room;
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
public class RoomController {

    @Autowired
    private ServiceI serviceI;

    @RequestMapping("/roomList")
    public String showAllRooms(Model model){

        List<Room> allRooms = serviceI.getAllRooms();
        model.addAttribute("allRooms", allRooms);

        return "all-rooms";
    }

    @RequestMapping("/addNewRoom")
    public String addNewRoom(Model model){

        Room room = new Room();
        model.addAttribute("newRoom", room);

        return "room-info";
    }


    @RequestMapping("/saveRoom")
    public String saveRoom(@ModelAttribute("newRoom")
                              @Valid final Room room,
                              final BindingResult bindingResult){
        if(bindingResult.hasFieldErrors()){
            return "room-info";
        }
        serviceI.saveRoom(room);
        return "redirect:/roomList";
    }
}
