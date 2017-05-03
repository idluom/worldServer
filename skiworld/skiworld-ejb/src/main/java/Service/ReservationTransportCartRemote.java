package Service;

import java.util.List;

import javax.ejb.Remote;

import Entity.ReservationTransport;

@Remote
public interface ReservationTransportCartRemote {

	public void addToCart(ReservationTransport reservation);
	public List<ReservationTransport> getCart();
	public boolean removeFromCart(ReservationTransport reservation);
	public void clearCart();
}
