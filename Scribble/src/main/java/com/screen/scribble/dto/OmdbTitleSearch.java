package com.screen.scribble.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.screen.scribble.model.OmdbSearchSummary;

import java.util.List;

public class OmdbTitleSearch {

    private List<OmdbSearchSummary> search;
    private int totalResults;
    private boolean response;

    public OmdbTitleSearch() {
    }

    public OmdbTitleSearch(List<OmdbSearchSummary> search, int totalResults, boolean response) {
        this.search = search;
        this.totalResults = totalResults;
        this.response = response;
    }

    @JsonProperty("Search")
    public List<OmdbSearchSummary> getSearch() {
        return search;
    }

    public void setSearch(List<OmdbSearchSummary> search) {
        this.search = search;
    }

    @JsonProperty("totalResults")
    int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    @JsonProperty("Response")
    public boolean isResponse() {
        return response;
    }

    public void setResponse(boolean response) {
        this.response = response;
    }
}
