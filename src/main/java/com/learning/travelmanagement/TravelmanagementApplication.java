package com.learning.travelmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TravelmanagementApplication {

	public static void main(String[] args) {
		System.setProperty("spring.config.location","application.properties");
		SpringApplication.run(TravelmanagementApplication.class, args);
	}

}
