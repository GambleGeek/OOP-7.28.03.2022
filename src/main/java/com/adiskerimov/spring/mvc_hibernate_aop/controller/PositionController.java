package lab5.mvc.Controller;

import lab5.mvc.Entity.Position;
import lab5.mvc.Service.PositionService;
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
@RequestMapping("/positions")
public class PositionController {
    @Autowired
    private PositionService positionService;

    @GetMapping("/")
    public String showAll(Model model){
        List<Position> positions = positionService.getAll();
        model.addAttribute("positions", positions);
        return "PositionsAll";
    }

    @GetMapping("/add")
    public String add(Model model){
        Position position = new Position();
        model.addAttribute("position", position);
        return "positionAdd";
    }

    @GetMapping("/save")
    public String save(@ModelAttribute("position") @Valid final Position position,
                       final BindingResult bindingResult){
        if(bindingResult.hasFieldErrors()){
            return "positionAdd";
        }
        positionService.save(position);
        return "redirect:/";
    }

    @GetMapping("/update")
    public String update(@RequestParam("id") int id,
                                 Model model){
        Position position = positionService.get(id);
        model.addAttribute("position", position);
        return "positionAdd";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") int id){
        positionService.delete(id);
        return "redirect:/positions/";
    }
}
