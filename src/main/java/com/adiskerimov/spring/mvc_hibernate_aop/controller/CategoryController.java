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
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private ServiceI serviceI;

    @GetMapping("/")
    public String showAll(Model model){
        List<Category> categories = serviceI.getAll();
        model.addAttribute("categories", categories);
        return "CategoriesAll";
    }

    @GetMapping("/add")
    public String add(Model model){
        Category category = new Category();
        model.addAttribute("category", category);
        return "categoryAdd";
    }

    @GetMapping("/save")
    public String save(@ModelAttribute("category") @Valid final Category category,
                       final BindingResult bindingResult){
        if(bindingResult.hasFieldErrors()){
            return "categoryAdd";
        }
        serviceI.save(category);
        return "redirect:/categories/";
    }
}
