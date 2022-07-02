package de.wi2020sebgruppe4.KinoTicketRes;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
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
		
		List<Instrument> Instruments = new ArrayList<Instrument>();
		
		//Schlagzeuge
		Instruments.add(new Instrument(true, "Schlaginstrument", 800, "Mapex Venus Fusion", "- Komplettes 5-teiliges Schlagzeug Set", "Schlagzeug", new UUID(0,0), null, 0, "https://www.kirstein.de/out/pictures/generated/product/1/1150_760_75/1a11060987c7ff49c024fd9ffacc9329_1.jpg"));
		Instruments.add(new Instrument(true, "Schlaginstrument", 579, "Mapex Tornado 20\" Dark Black", "- Komplettes 5-teiliges Schlagzeug Set", "Schlagzeug", null, null, 0, "https://sc1.musik-produktiv.com/pic-010096541m/mapex-tornado-20-dark-black-drum-set.jpg"));
		Instruments.add(new Instrument(true, "Schlaginstrument", 859, "Pearl Export 22\" Jet Black", "- Komplettes 5-teiliges Schlagzeug Set", "Schlagzeug", null, null, 0, "https://sc1.musik-produktiv.com/pic-010068564m/pearl-export-22-jet-black-complete-drumset.jpg"));
		Instruments.add(new Instrument(true, "Schlaginstrument", 1198, "Sonor AQ2 22\" White Pearl", "- Komplettes 5-teiliges Schlagzeug Set", "Schlagzeug", null, null, 0, "https://sc1.musik-produktiv.com/pic-010100005m/sonor-aq2-22-white-pearl-stage-drumset.jpg"));
		Instruments.add(new Instrument(true, "Schlaginstrument", 679, "Mapex Tornado 20\" Dark Black/Zidijian", "- Komplettes 5-teiliges Schlagzeug Set inkl. Zubehör", "Schlagzeug", null, null, 0, "https://sc1.musik-produktiv.com/pic-010096543m/mapex-tornado-20-dark-black-zildjian-bundle.jpg"));
		Instruments.add(new Instrument(true, "Schlaginstrument", 1869, "Gretsch Drums Renown Maple 22\" Silver Oyster Pearl", "- Komplettes 5-teiliges Schlagzeug Set", "Schlagzeug", null, null, 0, "https://sc1.musik-produktiv.com/pic-010099942m/gretsch-drums-renown-maple-22-silver-oyster-pearl.jpg"));
		
		//Gitarren
		Instruments.add(new Instrument(true, "Gitarre", 99, "Harley Benton ST-20HSS SBK Standard Series", "- Korpus: Linde \n - geschraubter Hals: Ahorn \n - Griffbrett: Amaranth", "E-Gitarre", null, null, 0, "https://thumbs.static-thomann.de/thumb/padthumb600x600/pics/prod/223985.jpg")); 
		Instruments.add(new Instrument(true, "Gitarre", 159, "Harley Benton TE-52 NA Vintage Series", "- Korpus: amerikanische Esche \n - geschraubter Hals: karamelisierter kanadischer Ahorn mit Roseacer Skunk Stripe \n - Griffbrett: Ahorn karamellisiert", "E-Gitarre", null, null, 0, "https://thumbs.static-thomann.de/thumb/padthumb600x600/pics/bdb/449491/14644831_800.jpg"));
		Instruments.add(new Instrument(true, "Gitarre", 249, "Harley Benton HB-35Plus Cherry", "- Korpus: Ahorn \n - eingeleimter Hals: Ahorn \n - Griffbrett: Lorbeer", "E-Gitarre", null, null, 0, "https://thumbs.static-thomann.de/thumb/padthumb600x600/pics/bdb/374853/14436119_800.jpg"));
		Instruments.add(new Instrument(true, "RENT", 299, "Harley Benton SC-550 II PAF", "- Korpus: Mahagoni \n - eingeleimter Hals: Mahagoni \n - Griffbrett: Pearloid Trapez", "E-Gitarre", null, null, 0, "https://thumbs.static-thomann.de/thumb/padthumb600x600/pics/bdb/521048/16415201_800.jpg"));
		Instruments.add(new Instrument(true, "Gitarre", 169, "Thomann Classic Guitar S 4/4", "- Decke: massiv Fichte (getönt) \n - Boden und Zargen: massiv Ahorn (nussbaumfarbig gebeizt) \n - Hals: Ahorn (nussbaumfarbig gebeizt) \n - Griffbrett: Akazie", "Konzertgitarre", null, null, 0, "https://thumbs.static-thomann.de/thumb/padthumb600x600/pics/prod/130180.jpg"));
		Instruments.add(new Instrument(true, "Gitarre", 169, "Ortega RST5M-3/4OC", "- Decke: Fichte \n - Boden und Zargen: Catalpa \n - Hals: Mahagoni \n - Griffbrett: Walnuss", "Konzertgitarre", null, null, 0, "https://thumbs.static-thomann.de/thumb/padthumb600x600/pics/bdb/533614/17219908_800.jpg"));
		
		//Klaviere
		Instruments.add(new Instrument(true, "Klavier", 7499, "Kawai K-200 ATX 4 E/P Piano", "- Mahagoni Hammerkern \n - Millennium III Mechanik mit ABS Carbonteilen \n - 100 cm breites Notenpult \n - langsam schließende Tastenklappe", "Flügel", null, null, 0, "https://thumbs.static-thomann.de/thumb/padthumb600x600/pics/bdb/523277/16822463_800.jpg"));
		Instruments.add(new Instrument(true, "Klavier", 5890, "Kawai K-300 E/P Piano", "- Mahagoni Hammerkern \n - Millennium III Mechanik mit ABS Carbonteilen \n - 100 cm breites Notenpult \n - langsam schließende Tastenklappe", "Flügel", null, null, 0, "https://thumbs.static-thomann.de/thumb/thumb220x220/pics/prod/332574.webp"));
		Instruments.add(new Instrument(true, "Klavier", 3990, "Kawai K 15 E MEP Klavier", "- Premium Wolle Hammerkern \n - 88 Tasten \n - 3 Pedale \n - Silent-Funktion: Nein", "Flügel", null, null, 0, "https://thumbs.static-thomann.de/thumb/thumb220x220/pics/prod/115126.webp"));
		Instruments.add(new Instrument(true, "Klavier", 4390, "Kawai K 15 E MH/P Piano", "- Premium Wolle Hammerkern \n - 88 Tasten \n - 3 Pedale \n - Silent-Funktion: Nein", "Flügel", null, null, 0, "https://thumbs.static-thomann.de/thumb/thumb220x220/pics/prod/115131.webp"));
		Instruments.add(new Instrument(true, "Klavier", 5290, "Yamaha b2 PM", "- Massiver Resonanzboden aus Fichtenholz § 88 Tasten \n - 3 Pedale \n - Silent-Funktion: Nein", "Flügel", null, null, 0, "https://thumbs.static-thomann.de/thumb/thumb220x220/pics/prod/192799.webp"));
		Instruments.add(new Instrument(true, "Klavier", 12590, "Yamaha U 3 SQ PE Piano", "- Gewicht: 235kg \n - 88 Tasten \n - 3 Pedale \n - Silent-Funktion: Nein", "Flügel", null, null, 0, "https://thumbs.static-thomann.de/thumb/thumb220x220/pics/prod/149297.webp"));
		
		repo.saveAll(Instruments);

		User Admin = new User("Admin", "AdminName", "AdminVorname", "email@email.com", "passwort", "Admin");
		Urepo.save(Admin);
	}

}
