package de.wi2020sebgruppe4.KinoTicketRes.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import de.wi2020sebgruppe4.KinoTicketRes.model.Cart;

@Repository
public interface CartRepository extends CrudRepository<Cart, UUID>{
	Optional<List<Cart>> findAllByuserId(UUID userId);
}