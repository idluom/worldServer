package Entity;

import java.io.Serializable;


import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class ReservationSkierRoom implements Serializable {

	@EmbeddedId
	private ReservationSkierRoomID reservationSkierRoomID;
	private static final long serialVersionUID = 1L;
	@ManyToOne
	@JoinColumn(name="idRoomPK",insertable=false,updatable=false)
	private Room room;
	@ManyToOne
	@JoinColumn(name="idSkierPK",insertable=false,updatable=false)
	private Skier skier;
	
	
	
	
	public ReservationSkierRoom() {
		super();
	}
	public ReservationSkierRoomID getReservationSkierRoomID() {
		return reservationSkierRoomID;
	}
	public void setReservationSkierRoomID(ReservationSkierRoomID reservationSkierRoomID) {
		this.reservationSkierRoomID = reservationSkierRoomID;
	}
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
	public Skier getSkier() {
		return skier;
	}
	public void setSkier(Skier skier) {
		this.skier = skier;
	}
	
}
