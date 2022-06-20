package de.wi2020sebgruppe4.KinoTicketRes.model;

public class InstrumentRequestObject {

	public String type;
	public double price;
	public String name;
	public String description;
	public String category;

    public InstrumentRequestObject(String type, double price, String name, String description, String category) {
        super();
        this.type = type;
        this.price = price;
        this.name = name;
        this.description = description;
        this.category = category;
    }

}