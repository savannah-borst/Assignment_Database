package Assignment.Database.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomerThymeController {

    @GetMapping()
    public String homePage(Model model){
        model.addAttribute("greeting", "Hallo Richie & Savannah");
        return "home";
    }

}
