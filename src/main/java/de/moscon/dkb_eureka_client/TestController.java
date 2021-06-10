package de.moscon.dkb_eureka_client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@Value("${my.test.config.entry}")
	private String myTestConfigEntry;


	@GetMapping("/config")
	public String testConfig() {
		return myTestConfigEntry;
	}
}
