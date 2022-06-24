package de.wi2020sebgruppe4.KinoTicketRes.rest;

import java.util.List;
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
@RequestMapping("/instruments")
public class InstrumentController {
	
	@Autowired
	InstrumentRepository repo;
	
	@GetMapping("")
	public ResponseEntity<Iterable<Object>> getInstruments(){
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
		toAddInstrument.setuserId(iro.user_id);
		return new ResponseEntity<Object>(repo.save(toAddInstrument), HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getInstrument(@PathVariable UUID id){
		
		Optional<Instrument> instrument = repo.findById(id);
		
		try {
			Instrument toReturn = instrument.get();
			return new ResponseEntity<Object>(toReturn, HttpStatus.OK);
		}
		catch(NoSuchElementException e) {
			return new ResponseEntity<Object>("Instrument "+id+" not found!", HttpStatus.NOT_FOUND);
		}
		
	}
	
	@GetMapping("/getForUser/{user_id}")
	public ResponseEntity<Object> getForUser(@PathVariable UUID user_id){
		Optional<List<Instrument>> resultSet;
		try {
			resultSet = repo.findAllByUserId(user_id);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Object>("User "+user_id+" not found!", HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Object>(resultSet, HttpStatus.OK);
	}
	
	@GetMapping("/getAllType/{type}")
	public ResponseEntity<Object> getAllByType(@PathVariable String type){
		Optional<List<Instrument>> toReturn;
		try {
			toReturn = repo.findAllByType(type);
		}
		catch(NoSuchElementException e) {
			return new ResponseEntity<Object>("Instrument type "+type+" not found!", HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Object>(toReturn, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteInstrument(@PathVariable UUID id){
		Optional<Instrument> o = repo.findById(id);
		try {
			repo.deleteById(o.get().getId());
			return new ResponseEntity<>(id, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>("Instrument "+id+" not found!", HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/book/{id}")
	public ResponseEntity<Object> bookInstrument(@PathVariable UUID id){
		Optional<Instrument> i = repo.findById(id);
		Instrument toBook;
		try {
			toBook = i.get();
		}
		catch(NoSuchElementException e) {
			return new ResponseEntity<Object>("Instrument "+id+" not found!", HttpStatus.NOT_FOUND);
		}
		
		toBook.setAvailable(false);
		return new ResponseEntity<Object>(toBook, HttpStatus.OK);
	}
	
	@PutMapping("/return/{id}")
	public ResponseEntity<Object> returnInstrument(@PathVariable UUID id){
		Optional<Instrument> i = repo.findById(id);
		Instrument toBook;
		try {
			toBook = i.get();
		}
		catch(NoSuchElementException e) {
			return new ResponseEntity<Object>("Instrument "+id+" not found!", HttpStatus.NOT_FOUND);
		}
		
		toBook.setAvailable(true);
		return new ResponseEntity<Object>(toBook, HttpStatus.OK);
	}
	
	@GetMapping("/AllBooked") 
	public ResponseEntity<Object> getAllBooked() {
		Optional<List<Instrument>> toReturn;
		try {
			toReturn = repo.findAllByAvailable(false);
		}
		catch(NoSuchElementException e) {
			return new ResponseEntity<Object>("Booked instruments not found!", HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Object>(toReturn, HttpStatus.OK);
	}
}
