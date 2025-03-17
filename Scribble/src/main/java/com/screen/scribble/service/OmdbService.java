package com.screen.scribble.service;

import com.screen.scribble.config.OmdbConfig;
import com.screen.scribble.dto.OmdbDetails;
import com.screen.scribble.model.LogModel;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OmdbService {
    private final String apiKey;
    private final String baseUrl;
    private final RestTemplate restTemplate;

    public OmdbService(OmdbConfig omdbConfig, RestTemplate restTemplate) {
        this.apiKey = omdbConfig.getKey();
        this.baseUrl = omdbConfig.getUrl();
        this.restTemplate = restTemplate;
    }

    public OmdbDetails getMovieById(String id) {
        String url = String.format("%s?apikey=%s&i=%s", baseUrl, apiKey, id);
        String jsonResponse = restTemplate.getForObject(url, String.class);
        return restTemplate.getForObject(url, OmdbDetails.class);
    }

    public OmdbDetails getMovieByTitle(String title) {
        String url = String.format("%s?apikey=%s&s=%s", baseUrl, apiKey, title);
        return restTemplate.getForObject(url, OmdbDetails.class);
    }
}
