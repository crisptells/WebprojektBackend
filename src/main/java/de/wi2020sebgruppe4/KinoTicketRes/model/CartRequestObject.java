package de.wi2020sebgruppe4.KinoTicketRes.model;

import java.util.UUID;

public class CartRequestObject {
	
	public UUID userId;
	public UUID instrumentId;
	
	public CartRequestObject(UUID userId, UUID instrumentId) {
		super();
		this.userId = userId;
		this.instrumentId = instrumentId;
	}
}
