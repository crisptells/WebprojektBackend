package de.wi2020sebgruppe4.KinoTicketRes.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import de.wi2020sebgruppe4.KinoTicketRes.model.Instrument;

@Repository
public interface InstrumentRepository extends CrudRepository<Instrument, UUID>{
	Optional<List<Instrument>> findAllByType(String type);
	Optional<List<Instrument>> findAllByAvailable(boolean available);
	Optional<List<Instrument>> findAllByUSERID(UUID user_id);
}
