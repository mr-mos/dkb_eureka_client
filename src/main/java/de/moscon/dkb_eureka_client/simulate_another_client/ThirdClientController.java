package de.moscon.dkb_eureka_client.simulate_another_client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/*
   Just for testing. Students should put this one into another clien-project
 */
@RestController
public class ThirdClientController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private DiscoveryClient discoveryClient;

	@GetMapping("/callVaccinationService")
	public String callVaccinationService() {
		log.info("Found Services: " + discoveryClient.getServices());
		String serviceName = "mos-microservice";
		String url = discoveryClient.getInstances(serviceName).get(0).getUri().toString() + "/next-vaccination?lastname=ThirdClient";
		RestTemplate restTemplate = new RestTemplate();
		return "Ergebnis: " + restTemplate.getForObject(url, String.class);
	}


}
