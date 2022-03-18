package lab5.mvc.Controller;

import lab5.mvc.Entity.ClassAvia;
import lab5.mvc.Entity.Employee;
import lab5.mvc.Service.ClassAviaService;
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
@RequestMapping("/classAvias")
public class ClassAviaController {
    @Autowired
    private ServiceI serviceI;

    @GetMapping("/")
    public String showAll(Model model){
        List<ClassAvia> classAvias = serviceI.getAll();
        model.addAttribute("classAvias", classAvias);
        return "ClassAviaAll";
    }

    @GetMapping("/add")
    public String add(Model model){
        ClassAvia classAvia = new ClassAvia();
        model.addAttribute("classAvia", classAvia);
        return "classAviaAdd";
    }

    @GetMapping("/save")
    public String save(@ModelAttribute("classAvia") @Valid final ClassAvia classAvia,
                       final BindingResult bindingResult){
        if(bindingResult.hasFieldErrors()){
            return "classAviaAdd";
        }
        serviceI.save(classAvia);
        return "redirect:/classAvias/";
    }
}
