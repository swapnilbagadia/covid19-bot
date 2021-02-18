package com.demo.covidbot.apimodels.twilio;

/**
 * @author Swapnil Bagadia
 */

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class IncomingMessage {

    @JsonProperty("body")
    private MessageBody body;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    @JsonProperty("body")
    public MessageBody getBody() {
        return body;
    }

    @JsonProperty("body")
    public void setBody(MessageBody body) {
        this.body = body;
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
