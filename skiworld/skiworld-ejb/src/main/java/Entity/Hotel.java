package Entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Hotel
 *
 */
@Entity

public class Hotel implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idHotel;
	private String name;
	private Integer stars;
	private String description;
	private static final long serialVersionUID = 1L;
	@OneToMany(mappedBy = "hotel")
	private List<Events> listEvents;
	@OneToMany(mappedBy = "hotel")
	private List<Room> listRooms;

	
	public Hotel() {
		super();
	}

	public Long getIdHotel() {
		return this.idHotel;
	}

	public void setIdHotel(Long idHotel) {
		this.idHotel = idHotel;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getStars() {
		return this.stars;
	}

	public void setStars(Integer stars) {
		this.stars = stars;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Events> getListEvents() {
		return listEvents;
	}

	public void setListEvents(List<Events> listEvents) {
		this.listEvents = listEvents;
	}

	public List<Room> getListRooms() {
		return listRooms;
	}

	public void setListRooms(List<Room> listRooms) {
		this.listRooms = listRooms;
	}

	

}
