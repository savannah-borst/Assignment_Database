package Assignment.Database.Controllers;

import Assignment.Database.DataAccess.RandomRepository;
import Assignment.Database.DataAccess.SearchRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ThymeleafController {
    RandomRepository randomRepo = new RandomRepository();
    SearchRepository searchRepo = new SearchRepository();

    @GetMapping("/home")
    public String homePage(Model model){
        model.addAttribute("headertext", "Welcome to the Chinook Music Database");
        model.addAttribute("artist", randomRepo.randomArtists());
        model.addAttribute("song", randomRepo.randomSongs());
        model.addAttribute("genre", randomRepo.randomGenres());
        return "home";
    }

    @GetMapping("/search")
    public String searchPage(Model model) {
        model.addAttribute("headertext", "Welcome to the Chinook Music Database");
        return "search";
    }

    @PostMapping("/search")
    public String handleSearch() {
        boolean success = searchRepo.getSearch();

        return search;
    }

}
