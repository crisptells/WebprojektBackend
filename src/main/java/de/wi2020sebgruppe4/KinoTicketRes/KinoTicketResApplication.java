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
import de.wi2020sebgruppe4.KinoTicketRes.model.User;
import de.wi2020sebgruppe4.KinoTicketRes.repositories.InstrumentRepository;
import de.wi2020sebgruppe4.KinoTicketRes.repositories.UserRepository;
import de.wi2020sebgruppe4.KinoTicketRes.rest.InstrumentController;

@SpringBootApplication
@ComponentScan("de.wi2020sebgruppe4.KinoTicketRes.model")
@EntityScan("de.wi2020sebgruppe4.KinoTicketRes.model")
@ComponentScan(basePackageClasses = InstrumentController.class)
public class KinoTicketResApplication {
	
	static InstrumentRepository repo;
	@Autowired
	InstrumentRepository r;
	
	static UserRepository Urepo;
	@Autowired
	UserRepository ur;
	
	@PostConstruct
	public void init() {
		KinoTicketResApplication.repo = r;
		KinoTicketResApplication.Urepo = ur;
	}

	public static void main(String[] args) {
		SpringApplication.run(KinoTicketResApplication.class, args);
		Instrument i = new Instrument(true, "Schlaginstrument", 800, "Mapex Venus Fusion", "Komplettes 5-teiliges Schlagzeug Set", "Schlagzeug", new UUID(2,2), new Date(2), 0, "https://www.kirstein.de/out/pictures/generated/product/1/1150_760_75/1a11060987c7ff49c024fd9ffacc9329_1.jpg");
		repo.save(i);
		Instrument i2 = new Instrument(true, "Gitarre", 500, "E-Gitarre", "Ich bin eine Gitarre, mich kann man streichen.", "E-Gitarre", new UUID(2,2), new Date(2), 0, "https://thumbs.static-thomann.de/thumb/padthumb600x600/pics/prod/153580.jpg");
		repo.save(i2);
		Instrument i3 = new Instrument(true, "Klavier", 500, "KAWAI Flügel GX-2", "Ich bin ein Klavier, auf mich kann man drücken.", "Flügel", new UUID(2,2), new Date(2), 0, "https://pianohaus-atzert.de/fileadmin/_processed_/9/5/csm_Kawai_Gx_2_ec6f7c3289.jpg");
		repo.save(i3);
		
		User u = new User("Admin", "AdminName", "AdminVorname", "email@email.com", "passwort", "Admin");
		Urepo.save(u);
	}

}
