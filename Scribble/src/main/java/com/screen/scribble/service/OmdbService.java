package com.screen.scribble.service;

import com.screen.scribble.config.OmdbConfig;
import com.screen.scribble.dto.OmdbDetails;
import com.screen.scribble.dto.OmdbTitleSearch;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

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

    public List<OmdbTitleSearch> searchByTitle(String title) {
        String url = String.format("%s?apikey=%s&s=%s", baseUrl, apiKey, title);
        return Collections.singletonList(restTemplate.getForObject(url, OmdbTitleSearch.class));
    }

    public List<OmdbDetails> searchById(String id) {
        String url = String.format("%s?apikey=%s&i=%s", baseUrl, apiKey, id);
        return Collections.singletonList(restTemplate.getForObject(url, OmdbDetails.class));
    }
}
