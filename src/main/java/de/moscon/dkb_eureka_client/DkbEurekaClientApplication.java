package de.moscon.dkb_eureka_client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
     https://github.com/spring-guides/gs-service-registration-and-discovery

     http://localhost:8080/service-instances/client-mos
 */

@SpringBootApplication
public class DkbEurekaClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(DkbEurekaClientApplication.class, args);
	}

}
