package de.wi2020sebgruppe4.KinoTicketRes;

import java.sql.Date;
import java.util.UUID;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

import de.wi2020sebgruppe4.KinoTicketRes.model.Instrument;
import de.wi2020sebgruppe4.KinoTicketRes.repositories.InstrumentRepository;
import de.wi2020sebgruppe4.KinoTicketRes.rest.InstrumentController;

@SpringBootApplication
@ComponentScan("de.wi2020sebgruppe4.KinoTicketRes.model")
@EntityScan("de.wi2020sebgruppe4.KinoTicketRes.model")
@ComponentScan(basePackageClasses = InstrumentController.class)
public class KinoTicketResApplication {
	
	static InstrumentRepository repo;
	@Autowired
	InstrumentRepository r;
	
	@PostConstruct
	public void init() {
		KinoTicketResApplication.repo = r;
	}

	public static void main(String[] args) {
		SpringApplication.run(KinoTicketResApplication.class, args);
		int l = 200;
		Instrument i = new Instrument(true, "Schlaginstrument", l, "Pauke", "Ich bin eine Pauke, mich kann man schlagen.", "Pauke", new UUID(2,2), new Date(2), 0, "https://thumbs.static-thomann.de/thumb/padthumb600x600/pics/prod/223985.jpg");
		repo.save(i);
		Instrument i2 = new Instrument(true, "Gitarre", 500, "E-Gitarre", "Ich bin eine Gitarre, mich kann man streichen.", "E-Gitarre", new UUID(2,2), new Date(2), 0, "https://thumbs.static-thomann.de/thumb/padthumb600x600/pics/prod/153580.jpg");
		repo.save(i2);
	}

}
