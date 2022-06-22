package de.wi2020sebgruppe4.KinoTicketRes.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@RequestMapping(value="/welcome")
	public static String welcome() {
		return "Welcome to Spring Boot";
	}

}
