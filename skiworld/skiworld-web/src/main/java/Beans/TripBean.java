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
		
	}

	public String doRegister() {
		setFormDisplayed(true);
		setStrip(trip);
		
		String s= trip.getVideo().substring(32,trip.getVideo().length());
		String v = "//www.youtube.com/v/"+s+"?color2=FBE9EC&amp;loop=1&amp;playlist=-KCBLA-fuVw&amp;version=3";
		System.out.println(v);
		setVideo(v);
		///Login?faces-redirect=true

		Subscribe();
		
        return "";
	}
	
	
	public String doWatch()
	{
		String s= trip.getVideo().substring(32,trip.getVideo().length());
		String v = "//www.youtube.com/v/"+s+"?color2=FBE9EC&amp;loop=1&amp;playlist=-KCBLA-fuVw&amp;version=3";
		System.out.println("vvvvv  "+v);
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
	
	public List<Trip> getFr() {
		return fr;
	}

	public void setFr(List<Trip> fr) {
		this.fr = fr;
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

	public String getVideo() {
		return Video;
	}

	public void setVideo(String video) {
		Video = video;
	} 

	
    
}
