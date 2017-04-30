package Beans;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import Entity.ReservationTransport;
import Entity.Skier;
import Entity.Transport;
import Service.ReservationTransportEJB;
import Service.SkierEJB;
import Service.TransportEJB;

@ManagedBean
@ViewScoped
public class ReservationTransportBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@EJB
	private SkierEJB skierEJB = new SkierEJB();
	@EJB
	private ReservationTransportEJB res = new ReservationTransportEJB();
	@EJB
	private TransportEJB transportEJB = new TransportEJB();

	private ReservationTransport reservation = new ReservationTransport();
	private boolean formDisplayed = false;
	private Transport transport = new Transport();
	private Skier skier = new Skier();

	public ReservationTransportBean() {

	}

	public boolean isFormDisplayed() {
		return formDisplayed;
	}

	public void setFormDisplayed(boolean formDisplayed) {
		this.formDisplayed = formDisplayed;
	}

	public Transport getTransport() {
		return transport;
	}

	public void setTransport(Transport transport) {
		this.transport = transport;
	}

	public List<Transport> getListTransport() {
		return transportEJB.upcomingTransport();
	}

	public String showForm() {
		String navTo = "";
		setFormDisplayed(true);
		return navTo;
	}

	public String checkSkier() {
		try {
			Skier s = skierEJB.findSkierByCardNumber(skier.getCardNumber());
			reservation.setSkier(s);
			reservation.setTransport(transport);
			res.addReservationTransport(reservation);
			if (s.getCredit() > transport.getPrice()) {
				s.setCredit(s.getCredit() - transport.getPrice() * reservation.getNbrePlaces());
				skierEJB.updateSkier(s);
				Transport tr = transportEJB.findTransportById(transport.getIdTransport());
				tr.setNumberPlaces(tr.getNumberPlaces() - reservation.getNbrePlaces());
				transportEJB.updateMeanTransport(tr);
				info();
			} else {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Error !", "Please Check Your Credit Before Continuing !"));
			}
		} catch (Exception e) {
			error();
			return "";
		}
		return "ListTransport";
	}

	public void info() {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Success !", "Enjoy Your Ride !"));
	}

	public void error() {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error !", "Something Went Wrong !"));
	}

	public Skier getSkier() {
		return skier;
	}

	public void setSkier(Skier skier) {
		this.skier = skier;
	}

	public ReservationTransport getReservation() {
		return reservation;
	}

	public void setReservation(ReservationTransport reservation) {
		this.reservation = reservation;
	}

}
