package de.wi2020sebgruppe4.KinoTicketRes.model;

public class InstrumentRequestObject {

	private String type;
	private double price;
	private String name;
	private String description;
	private String category;

    public InstrumentRequestObject(String type, double price, String name, String description, String category) {
        super();
        this.type = type;
        this.price = price;
        this.name = name;
        this.description = description;
        this.category = category;
    }

}