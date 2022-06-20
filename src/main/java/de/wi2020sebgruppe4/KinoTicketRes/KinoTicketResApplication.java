package de.wi2020sebgruppe4.KinoTicketRes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("de.wi2020sebgruppe4.KinoTicketRes.model")
@EntityScan("de.wi2020sebgruppe4.KinoTicketRes.model")
public class KinoTicketResApplication {

	public static void main(String[] args) {
		SpringApplication.run(KinoTicketResApplication.class, args);}
}
