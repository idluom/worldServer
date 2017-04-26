package Entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import Service.TripBusiness;

@Entity
public class ReservationTrip implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private ReservationTripID reservationTripId;
	
	@ManyToOne
	@JoinColumn(name="skierId",insertable=false,updatable=false)
	private Skier skier;
	
	@ManyToOne
	@JoinColumn(name="tripId",insertable=false,updatable=false)
	private Trip trip;
	

	public ReservationTrip() {
		super();
	}
	
	
	public ReservationTripID getReservationTripId() {
		return reservationTripId;
	}

	public void setReservationTripId(ReservationTripID reservationTripId) {
		this.reservationTripId = reservationTripId;
	}

	public Skier getSkier() {
		return skier;
	}

	public void setSkier(Skier skier) {
		this.skier = skier;
	}

	public Trip getTrip() {
		return trip;
	}

	public void setTrip(Trip trip) {
		this.trip = trip;
	}
	
	
	

}
