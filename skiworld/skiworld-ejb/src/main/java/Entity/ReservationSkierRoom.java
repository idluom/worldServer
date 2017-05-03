package Entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class ReservationSkierRoom implements Serializable {

	@EmbeddedId
	private ReservationSkierRoomID reservationSkierRoomID;
	private static final long serialVersionUID = 1L;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idRoomPK",insertable=false,updatable=false)
	private Room room;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idSkierPK",insertable=false,updatable=false)
	private Skier skier;
	private Date dateDebut;
	private Date dateFin;
	
	
	
	
	public ReservationSkierRoom() {
		reservationSkierRoomID=new ReservationSkierRoomID();
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
		reservationSkierRoomID.setIdRoomPK(room.getIdRoom());
		this.room = room;
	}
	public Skier getSkier() {
		return skier;
	}
	public void setSkier(Skier skier) {
		reservationSkierRoomID.setIdSkierPK(skier.getIdSkier());
		this.skier = skier;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	
}
