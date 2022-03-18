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
@RequestMapping("/classHotels")
public class ClassHotelController {
    @Autowired
    private ServiceI serviceI;

    @GetMapping("/")
    public String showAll(Model model){
        List<ClassHotel> classHotels = serviceI.getAll();
        model.addAttribute("classHotels", classHotels);
        return "ClassHotelsAll";
    }

    @GetMapping("/add")
    public String add(Model model){
        ClassHotel classHotel = new ClassHotel();
        model.addAttribute("classHotel", classHotel);
        return "classHotelAdd";
    }

    @GetMapping("/save")
    public String save(@ModelAttribute("classHotel") @Valid final ClassHotel classHotel,
                       final BindingResult bindingResult){
        if(bindingResult.hasFieldErrors()){
            return "classHotelAdd";
        }
        serviceI.save(classHotel);
        return "redirect:/classHotels/";
    }
}
