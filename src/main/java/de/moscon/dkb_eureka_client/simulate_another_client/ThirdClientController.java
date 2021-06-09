package de.moscon.dkb_eureka_client.simulate_another_client;

import de.moscon.dkb_eureka_client.simulate_another_client.client.MosMicroserviceClient;
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

	@GetMapping("/callVaccinationService")
	public String callVaccinationService() {
		return "Ergebnis: " + mosMicroserviceClient.getNextVaccination("ThirdClientWithFeign");
	}


}
