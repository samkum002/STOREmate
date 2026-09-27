package com.store.mate.STOREmate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

// @EntityScan("com.store")
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class StorEmateApplication {

	public static void main(String[] args) {
		SpringApplication.run(StorEmateApplication.class, args);
	}

}