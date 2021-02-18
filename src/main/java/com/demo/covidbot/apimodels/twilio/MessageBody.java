package com.demo.covidbot.apimodels.twilio;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Swapnil Bagadia
 */


public class MessageBody {

    @JsonProperty("SmsMessageSid")
    private String smsMessageSid;
    @JsonProperty("NumMedia")
    private String numMedia;
    @JsonProperty("ProfileName")
    private String profileName;
    @JsonProperty("SmsSid")
    private String smsSid;
    @JsonProperty("WaId")
    private String waId;
    @JsonProperty("SmsStatus")
    private String smsStatus;
    @JsonProperty("Body")
    private String body;
    @JsonProperty("To")
    private String to;
    @JsonProperty("NumSegments")
    private String numSegments;
    @JsonProperty("MessageSid")
    private String messageSid;
    @JsonProperty("AccountSid")
    private String accountSid;
    @JsonProperty("From")
    private String from;
    @JsonProperty("ApiVersion")
    private String apiVersion;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    @JsonProperty("SmsMessageSid")
    public String getSmsMessageSid() {
        return smsMessageSid;
    }

    @JsonProperty("SmsMessageSid")
    public void setSmsMessageSid(String smsMessageSid) {
        this.smsMessageSid = smsMessageSid;
    }

    @JsonProperty("NumMedia")
    public String getNumMedia() {
        return numMedia;
    }

    @JsonProperty("NumMedia")
    public void setNumMedia(String numMedia) {
        this.numMedia = numMedia;
    }

    @JsonProperty("ProfileName")
    public String getProfileName() {
        return profileName;
    }

    @JsonProperty("ProfileName")
    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    @JsonProperty("SmsSid")
    public String getSmsSid() {
        return smsSid;
    }

    @JsonProperty("SmsSid")
    public void setSmsSid(String smsSid) {
        this.smsSid = smsSid;
    }

    @JsonProperty("WaId")
    public String getWaId() {
        return waId;
    }

    @JsonProperty("WaId")
    public void setWaId(String waId) {
        this.waId = waId;
    }

    @JsonProperty("SmsStatus")
    public String getSmsStatus() {
        return smsStatus;
    }

    @JsonProperty("SmsStatus")
    public void setSmsStatus(String smsStatus) {
        this.smsStatus = smsStatus;
    }

    @JsonProperty("Body")
    public String getBody() {
        return body;
    }

    @JsonProperty("Body")
    public void setBody(String body) {
        this.body = body;
    }

    @JsonProperty("To")
    public String getTo() {
        return to;
    }

    @JsonProperty("To")
    public void setTo(String to) {
        this.to = to;
    }

    @JsonProperty("NumSegments")
    public String getNumSegments() {
        return numSegments;
    }

    @JsonProperty("NumSegments")
    public void setNumSegments(String numSegments) {
        this.numSegments = numSegments;
    }

    @JsonProperty("MessageSid")
    public String getMessageSid() {
        return messageSid;
    }

    @JsonProperty("MessageSid")
    public void setMessageSid(String messageSid) {
        this.messageSid = messageSid;
    }

    @JsonProperty("AccountSid")
    public String getAccountSid() {
        return accountSid;
    }

    @JsonProperty("AccountSid")
    public void setAccountSid(String accountSid) {
        this.accountSid = accountSid;
    }

    @JsonProperty("From")
    public String getFrom() {
        return from;
    }

    @JsonProperty("From")
    public void setFrom(String from) {
        this.from = from;
    }

    @JsonProperty("ApiVersion")
    public String getApiVersion() {
        return apiVersion;
    }

    @JsonProperty("ApiVersion")
    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
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
