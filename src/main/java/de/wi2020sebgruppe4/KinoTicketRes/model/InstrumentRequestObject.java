package de.wi2020sebgruppe4.KinoTicketRes.model;

import java.sql.Date;
import java.util.UUID;

public class InstrumentRequestObject {

	public String type;
	public long price;
	public String name;
	public String description;
	public String category;
	public UUID user_id;
	public String pictureLink;
	public Date bookingDate;
	public int bookingDuration;

    public InstrumentRequestObject(String type, long price, String name, String description, String category, UUID user_id, Date bookingDate, int bookingDuration, String pictureLink) {
        super();
        this.type = type;
        this.price = price;
        this.name = name;
        this.description = description;
        this.category = category;
        this.user_id = user_id;
        this.pictureLink = pictureLink;
        this.bookingDate = bookingDate;
        this.bookingDuration = bookingDuration;
    }
}