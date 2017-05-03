package Beans;

import java.io.IOException;
import java.io.Serializable;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ConcurrentModificationException;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.websocket.ClientEndpoint;
import javax.websocket.ContainerProvider;
import javax.websocket.DeploymentException;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;

import Entity.ReservationTransport;
import Entity.Skier;
import Entity.Transport;
import Service.ReservationTransportCart;
import Service.ReservationTransportEJB;
import Service.SkierEJB;
import Service.TransportEJB;

@ClientEndpoint
@ManagedBean
@SessionScoped
public class TransportCartClient implements Serializable {

	private static final long serialVersionUID = 1L;
	private static Session session;

	@EJB
	public ReservationTransportCart cartEJB;
	@EJB
	public ReservationTransportEJB resEJB;
	@EJB
	private SkierEJB skierEJB;
	@EJB
	private TransportEJB transportEJB;

	private boolean form = false;
	public ReservationTransport reservation;
	public Transport transport = new Transport();
	private ReservationTransport selected = new ReservationTransport();
	private Skier skier = new Skier();
	private int nb = 0;

	public TransportCartClient() {

	}

	public String addToCart() {
		connect();
		nb++;
		reservation = new ReservationTransport();
		reservation.setTransport(transport);
		reservation.setNbrePlaces(1);
		System.out.println(reservation.getTransport().getArrivalPlace() + " " + reservation.getNbrePlaces());

		cartEJB.addToCart(reservation);
		return "";
	}

	public List<ReservationTransport> getCart() {
		List<ReservationTransport> ls = cartEJB.getCart();
		for (ReservationTransport reservationTransport : ls) {
			System.out.println(
					reservationTransport.getNbrePlaces() + " " + reservationTransport.getTransport().getArrivalPlace());
		}
		return cartEJB.getCart();
	}

	public void setReservation(ReservationTransport reservation) {
		this.reservation = reservation;
	}

	public ReservationTransport getReservation() {
		return reservation;
	}

	public void setTransport(Transport transport) {
		this.transport = transport;
	}

	public Transport getTransport() {
		return transport;
	}

	public static void connect() {
		WebSocketContainer container = ContainerProvider.getWebSocketContainer();
		try {
			session = container.connectToServer(TransportCartClient.class,
					new URI("ws://localhost:18080/skiworld-web/TransportServlet"));
		} catch (DeploymentException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (URISyntaxException e1) {
			e1.printStackTrace();
		}
	}

	public static void disconnect() {
		if (session != null)
			try {
				session.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

	public void setSelected(ReservationTransport selected) {
		this.selected = selected;
	}

	public ReservationTransport getSelected() {
		return selected;
	}

	public String deleteItem() {
		cartEJB.removeFromCart(selected);
		return "";
	}

	public void setForm(boolean form) {
		this.form = form;
	}

	public boolean getForm() {
		return form;
	}

	public String confirm() {
		Skier s = new Skier();
		try {
			s = skierEJB.findSkierByCardNumber(skier.getCardNumber());
		} catch (Exception ex) {
			
		}
		List<ReservationTransport> ls = cartEJB.getCart();
		try {
			for (ReservationTransport reservationTransport : ls) {
				reservationTransport.setSkier(s);
				if (reservationTransport.getTransport().getPrice() < s.getCredit()) {

					Transport tr = transportEJB.findTransportById(reservationTransport.getTransport().getIdTransport());
					tr.setNumberPlaces(tr.getNumberPlaces() - reservationTransport.getNbrePlaces());
					transportEJB.updateMeanTransport(tr);

					s.setCredit(s.getCredit()
							- reservationTransport.getTransport().getPrice() * reservationTransport.getNbrePlaces());
					skierEJB.updateSkier(s);

					resEJB.addReservationTransport(reservationTransport);
					cartEJB.removeFromCart(reservationTransport);
				}
			}
		} catch (ConcurrentModificationException ex) {
			System.out.println("oops !");
		}
		return "";
	}

	public void setSkier(Skier skier) {
		this.skier = skier;
	}

	public Skier getSkier() {
		return skier;
	}

	public String showForm() {
		String navTo = "";
		setForm(true);
		return navTo;
	}
	
	public void setNb(int nb) {
		this.nb = nb;
	}
	
	public int getNb() {
		return nb;
	}
}
