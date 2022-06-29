package de.wi2020sebgruppe4.KinoTicketRes.model;

import java.sql.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

@Entity
@Table(name="INSTRUMENTS")
public class Instrument {
	@Id
    @Column(columnDefinition= "VARBINARY(16)")
    @GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

    @Column
    @NonNull
    private boolean available;

    @Column
    @NonNull
    private String type;
    
    @Column
    @NonNull
    private long price;
    
    @Column
    @NonNull
    private String name;
    
    @Column
    @NonNull
    private String description;
    
    @Column
    @NonNull
    private String category;
    
    @Column
    @NonNull
    private String pictureLink;
    
    @Column
    private UUID USERID;
    
    @Column
    private Date BOOKINGDATE;
    
    @Column
    private int BOOKINGDURATION;

    public Instrument() {

    }

	public Instrument(boolean available, String type, int price, String name, String description,
			String category, UUID userId, Date bookingDate, int bookingDuration, String pictureLink) {
		super();
		this.available = available;
		this.type = type;
		this.price = price;
		this.name = name;
		this.description = description;
		this.category = category;
		this.USERID = userId;
		this.BOOKINGDATE = bookingDate;
		this.BOOKINGDURATION = bookingDuration;
		this.pictureLink = pictureLink;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	public String getPictureLink() {
		return pictureLink;
	}

	public void setPictureLink(String pictureLink) {
		this.pictureLink = pictureLink;
	}

	public UUID getUserId() {
		return USERID;
	}

	public void setUserId(UUID userId) {
		this.USERID = userId;
	}

	public Date getBookingDate() {
		return BOOKINGDATE;
	}

	public void setBookingDate(Date bookingDate) {
		this.BOOKINGDATE = bookingDate;
	}

	public int getBookingDuration() {
		return BOOKINGDURATION;
	}

	public void setBookingDuration(int bookingDuration) {
		this.BOOKINGDURATION = bookingDuration;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (available ? 1231 : 1237);
		result = prime * result + ((BOOKINGDATE == null) ? 0 : BOOKINGDATE.hashCode());
		result = prime * result + BOOKINGDURATION;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((pictureLink == null) ? 0 : pictureLink.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((USERID == null) ? 0 : USERID.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Instrument other = (Instrument) obj;
		if (available != other.available)
			return false;
		if (BOOKINGDATE == null) {
			if (other.BOOKINGDATE != null)
				return false;
		} else if (!BOOKINGDATE.equals(other.BOOKINGDATE))
			return false;
		if (BOOKINGDURATION != other.BOOKINGDURATION)
			return false;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (pictureLink == null) {
			if (other.pictureLink != null)
				return false;
		} else if (!pictureLink.equals(other.pictureLink))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (USERID == null) {
			if (other.USERID != null)
				return false;
		} else if (!USERID.equals(other.USERID))
			return false;
		return true;
	}
}
