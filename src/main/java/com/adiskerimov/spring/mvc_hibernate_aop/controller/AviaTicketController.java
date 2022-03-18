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
@RequestMapping("/aviatickets")
public class AviaTicketController {
    @Autowired
    private ServiceI serviceI;

    @GetMapping("/")
    public String showAll(Model model){
        List<AviaTicket> aviaTickets = serviceI.getAll();
        model.addAttribute("aviaTickets", aviaTickets);
        return "AviaTicketsAll";
    }

    @GetMapping("/add")
    public String add(Model model){
        AviaTicket aviaTicket = new AviaTicket();
        model.addAttribute("aviaTicket", aviaTicket);
        return "aviaTicketAdd";
    }

    @GetMapping("/save")
    public String save(@ModelAttribute("aviaTicket") @Valid final AviaTicket aviaTicket,
                       final BindingResult bindingResult){
        if(bindingResult.hasFieldErrors()){
            return "aviaTicketAdd";
        }
        serviceI.save(aviaTicket);
        return "redirect:/aviatickets/";
    }
}
