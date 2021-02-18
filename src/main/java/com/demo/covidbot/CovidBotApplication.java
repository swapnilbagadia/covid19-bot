package com.demo.covidbot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class CovidBotApplication {

	public static void main(String[] args) {
		SpringApplication.run(CovidBotApplication.class, args);
	}

}
