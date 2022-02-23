package Assignment.Database.Controllers;

import Assignment.Database.DataAccess.RandomRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomerThymeController {
    RandomRepository randomRepo = new RandomRepository();

    @GetMapping("/home")
    public String homePage(Model model){
        model.addAttribute("artists", randomRepo.randomArtists());
        model.addAttribute("songs", randomRepo.randomSongs());
        model.addAttribute("genres", randomRepo.randomGenres());
        return "home";
    }

}
