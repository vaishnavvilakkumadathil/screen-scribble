package com.screen.scribble.controller;

import com.screen.scribble.dto.OmdbDetails;
import com.screen.scribble.model.LogModel;
import com.screen.scribble.service.OmdbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/omdb")
public class OmdbController {

    @Autowired
    private OmdbService omdbService;

    @GetMapping("/id/{id}")
    public OmdbDetails getMoviesById(@PathVariable String id) {
        return omdbService.getMovieById(id);
    }

    @GetMapping("/search}")
    public OmdbDetails getMoviesByTitle(@RequestParam String title) {
        return omdbService.getMovieByTitle(title);
    }

    @RequestMapping(value = "v1/rating", method = {RequestMethod.POST}, produces = "application/json")
    public void addRating() {

    }
}
