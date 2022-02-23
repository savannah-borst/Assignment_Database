package Assignment.Database.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomerThymeController {

    @GetMapping("/home")
    public String homePage(Model model){
        model.addAttribute("greeting", "Welcome to the iTunes homepage");
        return "home";
    }

}
