package com.screen.scribble.controller;

import com.screen.scribble.model.LogModel;
import com.screen.scribble.service.OmdbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/omdb")
public class OmdbController {

    @Autowired
    private OmdbService omdbService;

    @GetMapping("/id/{id}")
    LogModel getMoviesById(@PathVariable String id) {
        return omdbService.getMovieById(id);
    }
}
