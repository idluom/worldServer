package Entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Events
 *
 */
@Entity

public class Events implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEvents;
	private String name;
	private String description;
	private String place;
	private Date date;
	private Integer nbrPlaces;
	private Float price;
	private static final long serialVersionUID = 1L;
	@ManyToMany
	private List<Skier> listSkier;
	@ManyToOne
	private Hotel hotel;

	public Events() {
		super();
	}

	public Long getIdEvents() {
		return this.idEvents;
	}

	public void setIdEvents(Long idEvents) {
		this.idEvents = idEvents;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}


	public String getPlace() {
		return this.place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public Integer getNbrPlaces() {
		return this.nbrPlaces;
	}

	public void setNbrPlaces(Integer nbrPlaces) {
		this.nbrPlaces = nbrPlaces;
	}

	public Float getPrice() {
		return this.price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public List<Skier> getListSkier() {
		return listSkier;
	}

	public void setListSkier(List<Skier> listSkier) {
		this.listSkier = listSkier;
	}

	@Override
	public String toString() {
		return "Events [idEvents=" + idEvents + ", name=" + name + ", description=" + description + ", place=" + place
				+ ", nbrPlaces=" + nbrPlaces + ", price=" + price + ", hotel=" + hotel + "]";
	}

}
