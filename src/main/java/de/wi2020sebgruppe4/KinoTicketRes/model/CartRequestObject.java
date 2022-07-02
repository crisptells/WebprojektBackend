package de.wi2020sebgruppe4.KinoTicketRes.model;

public class CartRequestObject {
	
	public String userId;
	public String instrumentId;
	
	public CartRequestObject(String userId, String instrumentId) {
		super();
		this.userId = userId;
		this.instrumentId = instrumentId;
	}
}
