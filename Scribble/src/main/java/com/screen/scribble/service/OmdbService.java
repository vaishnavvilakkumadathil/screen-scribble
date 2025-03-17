package com.screen.scribble.service;

import com.screen.scribble.config.OmdbConfig;
import com.screen.scribble.model.LogModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OmdbService {
    @Autowired(required = true)
    private RestTemplate restTemplate;

    private final OmdbConfig omdbConfig;
    private final String key;
    private final String baseUrl;

    public OmdbService(OmdbConfig omdbConfig) {
        this.omdbConfig = omdbConfig;
        this.key = omdbConfig.getKey();
        this.baseUrl = omdbConfig.getUrl();
    }

    public LogModel getMovieById(String id) {
        String url = String.format("%s?apikey=%s&i=%s", baseUrl, key, id);
        return restTemplate.getForObject(url, LogModel.class);
    }
}
