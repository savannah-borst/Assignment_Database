package Assignment.Database.Controllers;

import Assignment.Database.DataAccess.RandomRepository;
import Assignment.Database.DataAccess.SearchRepository;
import Assignment.Database.Models.Search;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

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
        model.addAttribute("search", )
        return "search";
    }

    @PostMapping("/search")
    public String handleSearch(@ModelAttribute String searchQuery, BindingResult errors, Model model) {
        ArrayList<Search> returnSearch = searchRepo.getSearch(searchQuery);
        model.addAttribute("returnSearch", returnSearch);
        return "search";
    }

}
