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
@RequestMapping("/contracts")
public class ContractController {
    @Autowired
    private ServiceI serviceI;

    @GetMapping("/")
    public String showAll(Model model){
        List<Contract> contracts = serviceI.getAll();
        model.addAttribute("contracts", contracts);
        return "ContractsAll";
    }

    @GetMapping("/add")
    public String add(Model model){
        Contract contract = new Contract();
        model.addAttribute("contract", contract);
        return "contractAdd";
    }

    @GetMapping("/save")
    public String save(@ModelAttribute("contract") @Valid final Contract contract,
                       final BindingResult bindingResult){
        if(bindingResult.hasFieldErrors()){
            return "contractAdd";
        }
        serviceI.save(contract);
        return "redirect:/";
    }
}
