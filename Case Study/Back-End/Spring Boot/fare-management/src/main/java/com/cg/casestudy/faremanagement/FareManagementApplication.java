package com.cg.casestudy.faremanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class FareManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(FareManagementApplication.class, args);
	}

}
