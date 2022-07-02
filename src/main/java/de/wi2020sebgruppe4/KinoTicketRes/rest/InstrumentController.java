package de.wi2020sebgruppe4.KinoTicketRes.rest;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Mail.JavaMail;
import de.wi2020sebgruppe4.KinoTicketRes.model.Cart;
import de.wi2020sebgruppe4.KinoTicketRes.model.CartRequestObject;
import de.wi2020sebgruppe4.KinoTicketRes.model.Instrument;
import de.wi2020sebgruppe4.KinoTicketRes.model.InstrumentBookingRequestObject;
import de.wi2020sebgruppe4.KinoTicketRes.model.InstrumentRequestObject;
import de.wi2020sebgruppe4.KinoTicketRes.model.User;
import de.wi2020sebgruppe4.KinoTicketRes.repositories.CartRepository;
import de.wi2020sebgruppe4.KinoTicketRes.repositories.InstrumentRepository;
import de.wi2020sebgruppe4.KinoTicketRes.repositories.UserRepository;

@Controller
@RestController
@RequestMapping("/instruments")
public class InstrumentController {
	
	@Autowired
	InstrumentRepository repo;
	
	@Autowired
	CartRepository CartRepo;
	
	@Autowired
	UserRepository UserRepo;
	
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
		toAddInstrument.setUserId(iro.user_id);
		toAddInstrument.setPictureLink(iro.pictureLink);
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
			resultSet = repo.findAllByUSERID(user_id);
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
	
	@PutMapping("/putInCart")
	public ResponseEntity<Object> CartInstrument(@RequestBody CartRequestObject cro ){
		Optional<Instrument> o = repo.findById(cro.instrumentId);
		Optional<User> u = UserRepo.findById(cro.userId);
		try {
			Instrument toCart = o.get();
			User user = u.get();
			Cart cart = new Cart(user, toCart);
			return new ResponseEntity<Object>(CartRepo.save(cart), HttpStatus.OK);
		} catch (Exception e ){
			return new ResponseEntity<Object>("Instrument or User not found!", HttpStatus.NOT_FOUND);
		}
		
	}
	
	@GetMapping("/getCart/{userId}")
	public ResponseEntity<Iterable<Object>> getCart(@PathVariable UUID userId){
		Optional<User> u = UserRepo.findById(userId);
		try {
			User user = u.get();
			return new ResponseEntity(CartRepo.findAllByUserId(user), HttpStatus.OK);
		} catch (Exception e) {
			return null;
		}
	}
	
	@PutMapping("/book")
	public ResponseEntity<Object> bookInstrument(@RequestBody InstrumentBookingRequestObject ibro ){
		Optional<User> u = UserRepo.findById(ibro.userId);
		Optional<Instrument> i = repo.findById(ibro.instrumentId);
		Instrument toBook;
		try {
			User user = u.get();
			
			toBook = i.get();
			if(toBook.isAvailable() == false) {
				return new ResponseEntity<Object>("Instrument "+ibro.instrumentId+" is already booked!", HttpStatus.CONFLICT);
			}
			toBook.setUserId(ibro.userId);
			toBook.setBookingDate(ibro.bookingDate);
			toBook.setBookingDuration(ibro.bookingDuration);
			toBook.setAvailable(false);
			JavaMail.sendTicketConformationMail(user.getEmail(), toBook.getName(), user.getFirstName());
		}
		catch(NoSuchElementException e) {
			return new ResponseEntity<Object>("Instrument "+ibro.instrumentId+" not found!", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Object>(repo.save(toBook), HttpStatus.OK);
	}
	
	@PutMapping("/return/{id}")
	public ResponseEntity<Object> returnInstrument(@PathVariable UUID id){
		Optional<Instrument> i = repo.findById(id);
		
		try {
			Instrument toBook = i.get();
			try {
				Optional<Cart> c = CartRepo.findByInstrumentId(toBook);
				Cart cart = c.get();
				CartRepo.delete(cart);
			} catch (Exception e) {
				return new ResponseEntity<Object>("Cart "+id+" not found!", HttpStatus.NOT_FOUND);
			}
			toBook = i.get();
			toBook.setAvailable(true);
			toBook.setUserId(null);
			toBook.setBookingDate(null);
			toBook.setBookingDuration(0);
			return new ResponseEntity<Object>(repo.save(toBook), HttpStatus.OK);
		}
		catch(NoSuchElementException e) {
			return new ResponseEntity<Object>("Instrument "+id+" not found!", HttpStatus.NOT_FOUND);
		}
		
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
