package lab5.mvc.Controller;

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
@RequestMapping("/eventTickets")
public class EventTicketController {
    @Autowired
    private ServiceI serviceI;

    @GetMapping("/")
    public String showAll(Model model){
        List<EventTicket> eventTickets = serviceI.getAll();
        model.addAttribute("eventTickets", eventTickets);
        return "EventTicketAll";
    }

    @GetMapping("/add")
    public String add(Model model){
        EventTicket eventTicket = new EventTicket();
        model.addAttribute("eventTicket", eventTicket);
        return "eventTicketAdd";
    }

    @GetMapping("/save")
    public String save(@ModelAttribute("eventTicket") @Valid final EventTicket eventTicket,
                       final BindingResult bindingResult){
        if(bindingResult.hasFieldErrors()){
            return "eventTicketAdd";
        }
        serviceI.save(eventTicket);
        return "redirect:/";
    }
}
