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
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class ThymeleafController {
    RandomRepository randomRepo = new RandomRepository();
    SearchRepository searchRepo = new SearchRepository();
    ArrayList<Search> returnSearch = new ArrayList<>();

    @GetMapping("/home")
    public String homePage(Model model){
        model.addAttribute("headertext", "Welcome to the Chinook Music Database");
        model.addAttribute("randartist", randomRepo.randomArtists());
        model.addAttribute("randsong", randomRepo.randomSongs());
        model.addAttribute("randgenre", randomRepo.randomGenres());
        return "home";
    }
    @PostMapping("/search")
    public String handleSearch(@ModelAttribute String searchQuery, BindingResult errors, Model model) {
        returnSearch = searchRepo.getSearch(searchQuery);
        model.addAttribute("returnSearch", returnSearch);
        return "search";
    }

    @GetMapping("/search")
    public String searchPage(@RequestParam(name = "searchQuery", required = false) String searchQuery, Model model) {
        model.addAttribute("headertext", "Welcome to the Chinook Music Database");
        if (searchQuery != null && !searchQuery.equals("")) {
            model.addAttribute("track", returnSearch);
            model.addAttribute("artist", searchRepo.getSearch(searchQuery));
            model.addAttribute("album", searchRepo.getSearch(searchQuery));
            model.addAttribute("genre", searchRepo.getSearch(searchQuery));
        } else {
            model.addAttribute("fail", "Could not find track");
        }
        return "search";
    }

}
