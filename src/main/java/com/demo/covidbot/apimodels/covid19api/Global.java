package com.demo.covidbot.apimodels.covid19api;

import com.fasterxml.jackson.annotation.*;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Global implements Serializable {

    @JsonProperty("NewConfirmed")
    private Long newConfirmed;
    @JsonProperty("TotalConfirmed")
    private Long totalConfirmed;
    @JsonProperty("NewDeaths")
    private Long newDeaths;
    @JsonProperty("TotalDeaths")
    private Long totalDeaths;
    @JsonProperty("NewRecovered")
    private Long newRecovered;
    @JsonProperty("TotalRecovered")
    private Long totalRecovered;
    @JsonProperty("Date")
    private String date;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    @JsonProperty("NewConfirmed")
    public Long getNewConfirmed() {
        return newConfirmed;
    }

    @JsonProperty("NewConfirmed")
    public void setNewConfirmed(Long newConfirmed) {
        this.newConfirmed = newConfirmed;
    }

    @JsonProperty("TotalConfirmed")
    public Long getTotalConfirmed() {
        return totalConfirmed;
    }

    @JsonProperty("TotalConfirmed")
    public void setTotalConfirmed(Long totalConfirmed) {
        this.totalConfirmed = totalConfirmed;
    }

    @JsonProperty("NewDeaths")
    public Long getNewDeaths() {
        return newDeaths;
    }

    @JsonProperty("NewDeaths")
    public void setNewDeaths(Long newDeaths) {
        this.newDeaths = newDeaths;
    }

    @JsonProperty("TotalDeaths")
    public Long getTotalDeaths() {
        return totalDeaths;
    }

    @JsonProperty("TotalDeaths")
    public void setTotalDeaths(Long totalDeaths) {
        this.totalDeaths = totalDeaths;
    }

    @JsonProperty("NewRecovered")
    public Long getNewRecovered() {
        return newRecovered;
    }

    @JsonProperty("NewRecovered")
    public void setNewRecovered(Long newRecovered) {
        this.newRecovered = newRecovered;
    }

    @JsonProperty("TotalRecovered")
    public Long getTotalRecovered() {
        return totalRecovered;
    }

    @JsonProperty("TotalRecovered")
    public void setTotalRecovered(Long totalRecovered) {
        this.totalRecovered = totalRecovered;
    }

    @JsonProperty("Date")
    public String getDate() {
        return date;
    }

    @JsonProperty("Date")
    public void setDate(String date) {
        this.date = date;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
