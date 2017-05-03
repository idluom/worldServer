package Beans;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.TransferEvent;
import org.primefaces.event.UnselectEvent;
import org.primefaces.model.DualListModel;

import Entity.ReservationTrip;
import Entity.ReservationTripID;
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
@ViewScoped
public class TripBean implements Serializable {

	private static final long serialVersionUID = 1L;
	@EJB
	ReservationTripRemote reservation;
	@EJB
	SkierEJBRemote skierRemote;
	String Video;
	ReservationTrip reservationTrip = new ReservationTrip();
	Trip trip = new Trip();
	static Trip strip = new Trip();
	private boolean formDisplayed = false;
	public TripBean() {
		super();
	}
	List<String> citiesSource = new ArrayList<String>();
	private List<Trip> fr;
	private List<Trip> tr;
	@EJB
	private TripEJBRemote tripEJB;
	Skier skier = new Skier();
	Skier Sskier = new Skier();
	@PostConstruct
	public void init() {

		fr = tripEJB.DisplayAll();
		tr= SkierBean.getSRL();
		Sskier= SkierBean.getSskier();
		StringBuilder builder = new StringBuilder();
		FacesMessage msg = new FacesMessage();
		msg.setSeverity(FacesMessage.SEVERITY_INFO);
		msg.setSummary("Items Transferred");
		msg.setDetail(builder.toString());

		FacesContext.getCurrentInstance().addMessage(null, msg);
		
	}

	public String doRegister() {
		setFormDisplayed(true);
		setStrip(trip);
		
		String s= trip.getVideo().substring(32,trip.getVideo().length());
		String v = "//www.youtube.com/v/"+s+"?color2=FBE9EC&amp;loop=1&amp;playlist=-KCBLA-fuVw&amp;version=3";
		System.out.println(v);
		setVideo(v);
		///Login?faces-redirect=true

        return "";
	}
	
	
	public String doWatch()
	{
		String s= trip.getVideo().substring(32,trip.getVideo().length());
		String v = "//www.youtube.com/v/"+s+"?color2=FBE9EC&amp;loop=1&amp;playlist=-KCBLA-fuVw&amp;version=3";
		setVideo(v);
		return "Video?faces-redirect=true";
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
	
	public String CancelSubscribtion(){
		ReservationTrip reservationTrip = new ReservationTrip();
		reservationTrip.setTrip(trip);
		reservationTrip.setSkier(Sskier);
		ReservationTripID rid = new ReservationTripID();
		int p =(int) Sskier.getIdSkier();
		rid.setSkierId(p);
		rid.setTripId(trip.getId());
		reservationTrip.setReservationTripId(rid);
		reservation.Delete(reservationTrip);
		Skier sk;
		sk =Sskier;
		sk.setCredit(Sskier.getCredit()+trip.getPrice());

		skierRemote.updateSkier(sk);
		tr.remove(trip);
		for (Trip st : tr) {
			System.out.println(st.getDescription());
		}
		return "Subscribe?faces-redirect=true";
	}
	
	
	
	
	public List<Trip> getFr() {
		return fr;
	}

	public void setFr(List<Trip> fr) {
		this.fr = fr;
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

	public String getVideo() {
		return Video;
	}

	public void setVideo(String video) {
		Video = video;
	}

	public boolean isFormDisplayed() {
		return formDisplayed;
	}

	public void setFormDisplayed(boolean formDisplayed) {
		this.formDisplayed = formDisplayed;
	}

	public List<Trip> getTr() {
		return tr;
	}

	public void setTr(List<Trip> tr) {
		this.tr = tr;
	}



	
    
}
