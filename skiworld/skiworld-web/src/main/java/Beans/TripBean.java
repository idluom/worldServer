package Beans;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.primefaces.event.SelectEvent;
import org.primefaces.event.TransferEvent;
import org.primefaces.event.UnselectEvent;
import org.primefaces.model.DualListModel;

import Entity.ReservationTrip;
import Entity.Skier;
import Entity.Track;
import Entity.Trip;
import Service.ReservationTripRemote;
import Service.SkierEJBRemote;
import Service.TripEJBRemote;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.util.Duration;

@ManagedBean
@ApplicationScoped
public class TripBean implements Serializable {

	private static final long serialVersionUID = 1L;
	@EJB
	ReservationTripRemote reservation;
	@EJB
	SkierEJBRemote skierRemote;
	
	ReservationTrip reservationTrip = new ReservationTrip();
	Trip trip = new Trip();
	static Trip strip = new Trip();
	private DualListModel<String> cities;
	private boolean formDisplayed = false;
	public TripBean() {
		super();
	}
	List<String> citiesSource = new ArrayList<String>();
	private List<Trip> fr;

	@EJB
	private TripEJBRemote tripEJB;
	Skier skier = new Skier();
	@PostConstruct
	public void init() {

		fr = tripEJB.DisplayAll();
		StringBuilder builder = new StringBuilder();
		FacesMessage msg = new FacesMessage();
		msg.setSeverity(FacesMessage.SEVERITY_INFO);
		msg.setSummary("Items Transferred");
		msg.setDetail(builder.toString());
		

		FacesContext.getCurrentInstance().addMessage(null, msg);
		List<String> citiesSource = new ArrayList<String>();
		List<String> citiesTarget = new ArrayList<String>();

		citiesSource.add("San Francisco");
		citiesSource.add("London");
		citiesSource.add("Paris");
		citiesSource.add("Istanbul");
		citiesSource.add("Berlin");
		citiesSource.add("Barcelona");
		citiesSource.add("Rome");

		setCities(new DualListModel<String>(citiesSource, citiesTarget));
	}

	public String doRegister() {
		setFormDisplayed(true);
		setStrip(trip);
		
		System.out.println(" aaaaaaaaaaaaaa dddddddddddd ");
		
		///Login?faces-redirect=true
		System.out.println("ffffffffffffff   "+trip.getDescription());
		Subscribe();
		
        return "";
	}
	

	public void Subscribe() {
		FacesMessage message;
		 FacesContext context = FacesContext.getCurrentInstance();
		 message = new FacesMessage(
				    FacesMessage.SEVERITY_INFO,
				    "test message summary 1",
				    "test message detail 1");
	        context.addMessage(null, message);

	}
	
	public List<Trip> getFr() {
		return fr;
	}

	public void setFr(List<Trip> fr) {
		this.fr = fr;
	}

	public DualListModel<String> getCities() {
		return cities;
	}

	public void setCities(DualListModel<String> cities) {
		this.cities = cities;
	}

	public List<String> getCitiesSource() {
		return citiesSource;
	}

	public void setCitiesSource(List<String> citiesSource) {
		this.citiesSource = citiesSource;
	}

	public boolean isFormDisplayed() {
		return formDisplayed;
	}

	public void setFormDisplayed(boolean formDisplayed) {
		this.formDisplayed = formDisplayed;
	}

	public Trip getTrip() {
		return trip;
	}

	public void setTrip(Trip trip) {
		this.trip = trip;
	}

	public Skier getSkier() {
		return skier;
	}

	public void setSkier(Skier skier) {
		this.skier = skier;
	}

	public static Trip getStrip() {
		return strip;
	}

	public static void setStrip(Trip strip) {
		TripBean.strip = strip;
	} 

	
    
}
