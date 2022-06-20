package de.wi2020sebgruppe4.KinoTicketRes.rest;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.wi2020sebgruppe4.KinoTicketRes.model.Instrument;
import de.wi2020sebgruppe4.KinoTicketRes.model.InstrumentRequestObject;
import de.wi2020sebgruppe4.KinoTicketRes.repositories.InstrumentRepository;

@Controller
@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping("/instruments")
public class InstrumentController {
	
	@Autowired
	InstrumentRepository repo;
	
	@GetMapping("")
	public ResponseEntity<Iterable<Object>> getUsers(){
		return new ResponseEntity(repo.findAll(), HttpStatus.OK);
	}	
	
	@PutMapping("/add")
	public ResponseEntity<Object> addInstrument(@RequestBody InstrumentRequestObject iro){
		Instrument toAddInstrument = new Instrument();
		toAddInstrument.setAvailable(true);
		toAddInstrument.setCategory(iro.category);
		toAddInstrument.setDescription(iro.description);
		toAddInstrument.setName(iro.name);
		toAddInstrument.setPrice(iro.price);
		toAddInstrument.setType(iro.type);
		return new ResponseEntity<Object>(repo.save(toAddInstrument), HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getSpecific(@PathVariable UUID id){
		
		Optional<Instrument> instrument = repo.findById(id);
		
		try {
			Instrument toReturn = instrument.get();
			return new ResponseEntity<Object>(toReturn, HttpStatus.OK);
		}
		catch(NoSuchElementException e) {
			return new ResponseEntity<Object>("Instrument "+id+" not found!", HttpStatus.NOT_FOUND);
		}
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteUser(@PathVariable UUID id){
		Optional<Instrument> o = repo.findById(id);
		try {
			repo.deleteById(o.get().getId());
			return new ResponseEntity<>(id, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>("Instrument "+id+" not found!", HttpStatus.NOT_FOUND);
		}
	}
	
	
	
}
