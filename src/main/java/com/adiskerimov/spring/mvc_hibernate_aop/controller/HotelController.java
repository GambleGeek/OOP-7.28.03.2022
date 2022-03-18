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
@RequestMapping("/hotels")
public class HotelController {
    @Autowired
    private ServiceI serviceI;

    @GetMapping("/")
    public String showAll(Model model){
        List<Hotel> hotels = serviceI.getAll();
        model.addAttribute("hotels", hotels);
        return "HotelsAll";
    }

    @GetMapping("/add")
    public String add(Model model){
        Hotel hotel = new Hotel();
        model.addAttribute("hotel", hotel);
        return "hotelAdd";
    }

    @GetMapping("/save")
    public String save(@ModelAttribute("hotel") @Valid final Hotel hotel,
                       final BindingResult bindingResult){
        if(bindingResult.hasFieldErrors()){
            return "hotelAdd";
        }
        serviceI.save(hotel);
        return "redirect:/";
    }
}
