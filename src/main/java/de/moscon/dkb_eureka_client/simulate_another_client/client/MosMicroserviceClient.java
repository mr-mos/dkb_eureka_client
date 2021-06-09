package de.moscon.dkb_eureka_client.simulate_another_client.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "mos-microservice")
public interface MosMicroserviceClient {
	@GetMapping("/next-vaccination")
	String getNextVaccination(@RequestParam(required = false) String lastname);
}
