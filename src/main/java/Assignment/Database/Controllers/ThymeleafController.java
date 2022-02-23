package Assignment.Database.Controllers;

import Assignment.Database.DataAccess.RandomRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThymeleafController {
    RandomRepository randomRepo = new RandomRepository();

    @GetMapping("/home")
    public String homePage(Model model){
        model.addAttribute("headertext", "Welcome to the Chinook Music Database");
        model.addAttribute("artist", randomRepo.randomArtists());
        model.addAttribute("song", randomRepo.randomSongs());
        model.addAttribute("genre", randomRepo.randomGenres());
        return "home";
    }

}
