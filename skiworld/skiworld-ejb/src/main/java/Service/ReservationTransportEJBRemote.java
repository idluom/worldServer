package Service;

import javax.ejb.Remote;

import Entity.ReservationTransport;

@Remote
public interface ReservationTransportEJBRemote {

	public void addReservationTransport(ReservationTransport reservation);
}
