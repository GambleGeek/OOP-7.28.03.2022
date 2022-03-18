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
@RequestMapping("/countries")
public class CountryController {
    @Autowired
    private ServiceI serviceI;

    @GetMapping("/")
    public String showAll(Model model){
        List<Country> countries = serviceI.getAll();
        model.addAttribute("countries", countries);
        return "CountriesAll";
    }

    @GetMapping("/add")
    public String add(Model model){
        Country country = new Country();
        model.addAttribute("country", country);
        return "countryAdd";
    }

    @GetMapping("/save")
    public String save(@ModelAttribute("country") @Valid final Country country,
                       final BindingResult bindingResult){
        if(bindingResult.hasFieldErrors()){
            return "countryAdd";
        }
        serviceI.save(country);
        return "redirect:/countries/";
    }

}
