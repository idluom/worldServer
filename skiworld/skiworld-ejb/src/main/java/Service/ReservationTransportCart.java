package Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.ejb.LocalBean;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import Entity.ReservationTransport;

/**
 * Session Bean implementation class ReservationTransportCart
 */
@Stateful
@LocalBean
public class ReservationTransportCart implements ReservationTransportCartRemote {

	List<ReservationTransport> listReservation;
	UUID sessionUUID;

	public ReservationTransportCart() {
		listReservation = new ArrayList<>();
		sessionUUID = UUID.randomUUID();
	}

	@Override
	public void addToCart(ReservationTransport reservation) {
		if (listReservation != null) {
			listReservation.add(reservation);
		}
	}

	@Override
	public List<ReservationTransport> getCart() {

		return listReservation;
	}

	@Override
	public boolean removeFromCart(ReservationTransport reservation) {
		return listReservation.remove(reservation);
	}

	@Override
	@Remove
	public void clearCart() {
		listReservation = null;
	}

	public void setSessionUUID(UUID sessionUUID) {
		this.sessionUUID = sessionUUID;
	}

	public UUID getSessionUUID() {
		return sessionUUID;
	}

}
