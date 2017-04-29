package Entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ReservationTransport implements Serializable {

	@EmbeddedId
	private ReservationTransportID reservationTransportId;
	private static final long serialVersionUID = 1L;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idTransport",insertable=false,updatable=false)
	private Transport transport;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idSkier",insertable=false,updatable=false)
	private Skier skier;
	private int nbrePlaces;
	
	public ReservationTransport() {
		reservationTransportId = new ReservationTransportID();
	}

	public ReservationTransportID getReservationTransport() {
		return reservationTransportId;
	}

	public void setReservationTransport(ReservationTransportID reservationTransport) {
		this.reservationTransportId = reservationTransport;
	}

	public Transport getTransport() {
		return transport;
	}

	public void setTransport(Transport transport) {
		reservationTransportId.setIdTransport(transport.getIdTransport());
		this.transport = transport;
	}

	public Skier getSkier() {
		return skier;
	}

	public void setSkier(Skier skier) {
		reservationTransportId.setIdSkier(skier.getIdSkier());
		this.skier = skier;
	}

	public int getNbrePlaces() {
		return nbrePlaces;
	}

	public void setNbrePlaces(int nbrePlaces) {
		this.nbrePlaces = nbrePlaces;
	}
	
}
