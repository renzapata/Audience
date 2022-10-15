package com.example.mintic.Auditorio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackages = {"com.example.mintic.audience.model"})
@SpringBootApplication
public class AudienceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AudienceApplication.class, args);
	}

}
