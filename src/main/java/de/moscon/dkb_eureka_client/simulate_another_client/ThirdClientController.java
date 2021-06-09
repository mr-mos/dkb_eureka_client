package de.moscon.dkb_eureka_client.simulate_another_client;

import de.moscon.dkb_eureka_client.simulate_another_client.client.MosMicroserviceClient;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/*
   Just for testing. Students should put this one into another clien-project
 */
@RestController
public class ThirdClientController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private MosMicroserviceClient mosMicroserviceClient;

	@CircuitBreaker(name="callVaccinationService", fallbackMethod = "getFallbackMessage")
	@GetMapping("/callVaccinationService")
	public String callVaccinationService() {
		return "Ergebnis: " + mosMicroserviceClient.getNextVaccination("ThirdClientWithFeign");
	}


	public String getFallbackMessage(Exception ex) {
		log.error("Error, during calling another service",ex);
		return "Sorry, deine Anfrage zum Impftermin konnte nicht beanwortet werden. ("+ex.getMessage()+")";
	}


}
