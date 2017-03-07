package Entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Room
 *
 */
@Entity

public class Room implements Serializable {

	   
	@Id
	private Long idRoom;
	private String description;
	private Integer nbrSimpleBed;
	private Integer nbrDoubleBed;
	private Float price;
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	private Hotel hotel;

	public Room() {
		super();
	}   
	public Long getIdRoom() {
		return this.idRoom;
	}

	public void setIdRoom(Long idRoom) {
		this.idRoom = idRoom;
	}   
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}   
	public Integer getNbrSimpleBed() {
		return this.nbrSimpleBed;
	}

	public void setNbrSimpleBed(Integer nbrSimpleBed) {
		this.nbrSimpleBed = nbrSimpleBed;
	}   
	public Integer getNbrDoubleBed() {
		return this.nbrDoubleBed;
	}

	public void setNbrDoubleBed(Integer nbrDoubleBed) {
		this.nbrDoubleBed = nbrDoubleBed;
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
   
}
