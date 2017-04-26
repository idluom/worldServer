package Service;

import javax.ejb.Remote;

import Entity.ReservationTrip;

@Remote
public interface ReservationTripRemote {

	public void addReservationTrip(ReservationTrip rt);
	
}
