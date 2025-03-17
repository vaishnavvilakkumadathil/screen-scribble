package com.screen.scribble.service;

import com.screen.scribble.Repository.MongoRepo;
import com.screen.scribble.config.OmdbConfig;
import com.screen.scribble.model.LogModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.List;
import java.util.Optional;

@Service
public class OmdbService {

    private OmdbConfig omdbConfig;
    private RestTemplate restTemplate;
    private final String key = omdbConfig.getKey();
    private final String baseUrl = omdbConfig.getUrl();

    public OmdbService(MongoRepo mongoRepo) {
    }

    public LogModel getMovieById(String id) {
        String url = baseUrl + "?apikey=" + key + "&i=" + id;
        return restTemplate.getForObject(url, LogModel.class);
    }

}
