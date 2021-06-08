package de.moscon.dkb_eureka_client;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Locale;
import java.util.Random;

@RestController
public class VaccinationController {

	@GetMapping("/next-vaccination")
	public String getNextVaccinationDate(@RequestParam(required = false) String lastname) {
		if (lastname == null) {
			return "Bitte gebe deinen Namen als 'lastname'-Parameter an";
		}
		LocalDateTime nextDate = LocalDateTime.now().plusDays(new Random().nextInt(200));
		return String.format("%s, dein Impftermin ist am  %tD", lastname, nextDate);
	}
}
