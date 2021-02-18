package com.demo.covidbot.jobs;

import com.demo.covidbot.apimodels.covid19api.Country;
import com.demo.covidbot.apimodels.covid19api.CovidDataMain;
import com.demo.covidbot.constants.Covid19ApiConstants;
import io.lettuce.core.api.async.RedisAsyncCommands;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.SerializationUtils;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

/**
 * @author Swapnil Bagadia
 */

@Slf4j
@Component
public class CovidDataPullService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${app.job.covid-real-time-data.enabled}")
    private boolean enabled;

    @Value("${app.job.covid-real-time-data.config.url}")
    private String url;

    @Autowired
    private RedisAsyncCommands<String, byte[]> redisAsyncCommands;

    private HttpHeaders getCommonHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }

    @Scheduled(cron = "${app.job.covid-real-time-data.cron-expression}", zone = "IST")
    public void run() {
        if (enabled) {
            runJobInternal();
        }
    }

    private void runJobInternal() {
        try {
            ResponseEntity<CovidDataMain> responseEntity = restTemplate.getForEntity(url, CovidDataMain.class);
            populateDataStore(Objects.requireNonNull(responseEntity.getBody()));
        } catch (HttpClientErrorException e) {
            log.error("HttpClientErrorException",e);
        } catch (HttpServerErrorException e) {
            log.error("HttpServerErrorException",e);
        } catch (RestClientException e) {
            log.error("RestClientException",e);
        }
    }

    private void populateDataStore(CovidDataMain covidDataMain) {
        Long activeCases = covidDataMain.getGlobal().getTotalConfirmed() - covidDataMain.getGlobal().getTotalRecovered();
        redisAsyncCommands.set(Covid19ApiConstants.TOTAL_ACTIVE_CASES_KEY, SerializationUtils.serialize(activeCases));
        redisAsyncCommands.set(Covid19ApiConstants.TOTAL_DEATHS_KEY, SerializationUtils.serialize(covidDataMain.getGlobal().getTotalDeaths()));
        for (Country country : covidDataMain.getCountries()) {
            redisAsyncCommands.set(country.getCountryCode(), SerializationUtils.serialize(country));
        }
    }
}
