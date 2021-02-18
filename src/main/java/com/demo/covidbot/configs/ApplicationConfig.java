package com.demo.covidbot.configs;

import com.twilio.Twilio;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author Swapnil Bagadia
 */

@Configuration
public class ApplicationConfig {

    @Value("${app.twilio.sid}")
    private String sid;

    @Value("${app.twilio.auth-token}")
    private String authToken;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public void twilio() {
        Twilio.init(sid, authToken);
    }


}
