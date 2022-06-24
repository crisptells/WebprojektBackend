package de.wi2020sebgruppe4.KinoTicketRes.model;

import java.sql.Date;
import java.util.UUID;

public class InstrumentRequestObject {

	public String type;
	public double price;
	public String name;
	public String description;
	public String category;
	public UUID user_id;
	public Date bookingDate;
	public int bookingDuration;

    public InstrumentRequestObject(String type, double price, String name, String description, String category, UUID user_id, Date bookingDate, int bookingDuration) {
        super();
        this.type = type;
        this.price = price;
        this.name = name;
        this.description = description;
        this.category = category;
        this.user_id = user_id;
        this.bookingDate = bookingDate;
        this.bookingDuration = bookingDuration;
    }
}