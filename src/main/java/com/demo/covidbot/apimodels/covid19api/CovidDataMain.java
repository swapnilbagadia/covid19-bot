package com.demo.covidbot.apimodels.covid19api;

import com.fasterxml.jackson.annotation.*;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class CovidDataMain implements Serializable {

    @JsonProperty("ID")
    private String iD;

    @Override
    public String toString() {
        return "CovidDataMain{" +
                "iD='" + iD + '\'' +
                ", message='" + message + '\'' +
                ", global=" + global +
                ", countries=" + countries +
                ", date='" + date + '\'' +
                ", additionalProperties=" + additionalProperties +
                '}';
    }

    @JsonProperty("Message")
    private String message;
    @JsonProperty("Global")
    private Global global;
    @JsonProperty("Countries")
    private List<Country> countries = null;
    @JsonProperty("Date")
    private String date;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    @JsonProperty("ID")
    public String getID() {
        return iD;
    }

    @JsonProperty("ID")
    public void setID(String iD) {
        this.iD = iD;
    }

    @JsonProperty("Message")
    public String getMessage() {
        return message;
    }

    @JsonProperty("Message")
    public void setMessage(String message) {
        this.message = message;
    }

    @JsonProperty("Global")
    public Global getGlobal() {
        return global;
    }

    @JsonProperty("Global")
    public void setGlobal(Global global) {
        this.global = global;
    }

    @JsonProperty("Countries")
    public List<Country> getCountries() {
        return countries;
    }

    @JsonProperty("Countries")
    public void setCountries(List<Country> countries) {
        this.countries = countries;
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
