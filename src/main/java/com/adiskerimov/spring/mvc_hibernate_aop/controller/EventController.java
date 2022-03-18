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
@RequestMapping("/events")
public class EventController {
    @Autowired
    private ServiceI serviceI;

    @GetMapping("/")
    public String showAll(Model model){
        List<Event> events = serviceI.getAll();
        model.addAttribute("events", events);
        return "EventsAll";
    }

    @GetMapping("/add")
    public String add(Model model){
        Event event = new Event();
        model.addAttribute("event", event);
        return "eventAdd";
    }

    @GetMapping("/save")
    public String save(@ModelAttribute("event") @Valid final Event event,
                       final BindingResult bindingResult){
        if(bindingResult.hasFieldErrors()){
            return "eventAdd";
        }
        serviceI.save(event);
        return "redirect:/";
    }

}
