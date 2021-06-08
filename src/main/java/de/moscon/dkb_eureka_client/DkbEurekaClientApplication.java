package de.moscon.dkb_eureka_client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/*
     https://github.com/spring-guides/gs-service-registration-and-discovery

     http://localhost:8080/service-instances/mos-microservice

     http://localhost:8080/next-vaccination

     http://localhost:8080/callVaccinationService               // simlulates another client / microservice

 */

@EnableEurekaClient
@SpringBootApplication
public class DkbEurekaClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(DkbEurekaClientApplication.class, args);
	}

}
