package Entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Room
 *
 */
@Entity

public class Room implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idRoom;
	private String description;
	private int nbrSimpleBed;
	private int nbrDoubleBed;
	private float price;
	private int nbr;
	private static final long serialVersionUID = 1L;
	@OneToMany(mappedBy="room")
	private List<ReservationSkierRoom> listReservation;
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
	
	public int getNbrSimpleBed() {
		return nbrSimpleBed;
	}
	public void setNbrSimpleBed(int nbrSimpleBed) {
		this.nbrSimpleBed = nbrSimpleBed;
	}
	public int getNbrDoubleBed() {
		return nbrDoubleBed;
	}
	public void setNbrDoubleBed(int nbrDoubleBed) {
		this.nbrDoubleBed = nbrDoubleBed;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public Hotel getHotel() {
		return hotel;
	}
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	@Override
	public String toString() {
		return "Room [idRoom=" + idRoom + ", description=" + description + ", nbrSimpleBed=" + nbrSimpleBed
				+ ", nbrDoubleBed=" + nbrDoubleBed + ", price=" + price + ", hotel=" + hotel + "]";
	}
	public int getNbr() {
		return nbr;
	}
	public void setNbr(int nbr) {
		this.nbr = nbr;
	}
   
}
