package Service;

import java.util.List;

import javax.ejb.Remote;

import Entity.ReservationTrip;
import Entity.Trip;



@Remote
public interface ReservationTripRemote {

	public void addReservationTrip(ReservationTrip rt);
	public List<ReservationTrip> DisplayAll() ;
	public void Delete(ReservationTrip rt);
}
