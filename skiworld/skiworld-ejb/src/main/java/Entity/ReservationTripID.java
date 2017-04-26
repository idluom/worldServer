package Entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
@Embeddable
public class ReservationTripID implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int skierId;
	private int tripId;
	
	
	
	public ReservationTripID() {
		super();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + skierId;
		result = prime * result + tripId;
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
		ReservationTripID other = (ReservationTripID) obj;
		if (skierId != other.skierId)
			return false;
		if (tripId != other.tripId)
			return false;
		return true;
	}



	public int getSkierId() {
		return skierId;
	}
	public void setSkierId(int skierId) {
		this.skierId = skierId;
	}
	public int getTripId() {
		return tripId;
	}
	public void setTripId(int tripId) {
		this.tripId = tripId;
	}
	

}
