package de.moscon.dkb_eureka_client;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@CircuitBreaker(name = "testBreaker", fallbackMethod = "errorFound")
	@GetMapping("/helloworld")
	public String helloWorld() {
		if (System.currentTimeMillis() % 2 == 0) {
			throw new IllegalArgumentException("EIN FEHLER :(");
		}
		return "Hello World";
	}



	public String errorFound(Exception ex) {
		return "Abgefangen: "+ex.getMessage();
	}

}
