package com.screen.scribble.controller;

import com.screen.scribble.dto.OmdbDetails;
import com.screen.scribble.dto.OmdbSearch;
import com.screen.scribble.model.OmdbSearchSummary;
import com.screen.scribble.service.OmdbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/omdb")
public class OmdbController {

    @Autowired
    private OmdbService omdbService;

    @GetMapping("/id/{id}")
    public OmdbDetails getMoviesById(@PathVariable String id) {
        return omdbService.getMovieById(id);
    }

    @GetMapping("/searching")
    public OmdbDetails getMoviesByTitle(@RequestParam String title) {
        return omdbService.getMovieByTitle(title);
    }

    @GetMapping("/searchu")
    public List <OmdbSearchSummary> SearchByTitle(@RequestParam String title) {
        return (List<OmdbSearchSummary>) omdbService.searchsByTitle(title);
    }

    @GetMapping("/search")
    public List<OmdbSearchSummary> searchByTitle(@RequestParam String title) {
        OmdbSearch result = omdbService.searchByTitle(title);
        return result.getSearch();
    }


    @RequestMapping(value = "v1/rating", method = {RequestMethod.POST}, produces = "application/json")
    public void addRating() {

    }
}
