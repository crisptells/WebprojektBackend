package de.wi2020sebgruppe4.KinoTicketRes.model;

import java.sql.Date;
import java.util.UUID;

public class InstrumentBookingRequestObject {
	
	public UUID userId;
	public Date bookingDate;
	public int bookingDuration;
	public UUID instrumentId;
	
	public InstrumentBookingRequestObject(UUID user_id, Date bookingDate, int bookingDuration, UUID instrumentId) {
		super();
        this.userId = user_id;
        this.bookingDate = bookingDate;
        this.bookingDuration = bookingDuration;
        this.instrumentId = instrumentId;
    }
}
