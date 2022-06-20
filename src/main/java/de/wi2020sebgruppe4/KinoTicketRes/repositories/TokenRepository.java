package de.wi2020sebgruppe4.KinoTicketRes.repositories;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import de.wi2020sebgruppe4.KinoTicketRes.model.Token;

@Repository
public interface TokenRepository extends CrudRepository<Token, UUID>{

}
