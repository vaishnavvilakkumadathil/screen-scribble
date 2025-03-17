package com.screen.scribble.controller;

import com.screen.scribble.dto.OmdbDetails;
import com.screen.scribble.dto.OmdbTitleSearch;
import com.screen.scribble.service.OmdbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/omdb")
public class OmdbController {

    @Autowired
    private OmdbService omdbService;

    @GetMapping("/search")
    List <OmdbTitleSearch> searchByTitle(String title) {
        return omdbService.searchByTitle(title);
    }

    @GetMapping("/id")
    List <OmdbDetails> searchById(String id) {
        return omdbService.searchById(id);
    }
}
