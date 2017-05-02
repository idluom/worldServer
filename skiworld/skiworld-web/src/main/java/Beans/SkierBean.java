package Beans;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

import Entity.ReservationTrip;
import Entity.ReservationTripID;
import Entity.Skier;
import Entity.Trip;
import Service.ReservationTripRemote;
import Service.SkierEJB;
import Service.TripEJBRemote;
import javafx.scene.control.Alert;

@ManagedBean
@RequestScoped
public class SkierBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Skier skier = new Skier();
	private LineChartModel lineModel;
	@EJB
	private SkierEJB skierEJB = new SkierEJB();

	ReservationTrip reservationTrip = new ReservationTrip();
	@EJB
	ReservationTripRemote reservation;
	Date date;
	@EJB
	TripEJBRemote tripEJB;

	public LineChartModel getLineModel() {
		return lineModel;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Skier getSkier() {
		return skier;
	}

	public void setSkier(Skier skier) {
		this.skier = skier;
	}
//**********
	@PostConstruct
    public void init() {
        createLineModels();
    }

	private void createLineModels() {
       
         
        lineModel = initCategoryModel();
        lineModel.setTitle("Available Places");
        lineModel.setLegendPosition("e");
        lineModel.setShowPointLabels(true);
        lineModel.getAxes().put(AxisType.X, new CategoryAxis("Trips"));
        Axis yAxis = lineModel.getAxis(AxisType.Y);
        yAxis.setLabel("Number");
        yAxis.setMin(0);
        yAxis.setMax(50);
        Axis xAxis = lineModel.getAxis(AxisType.X);
        xAxis.setLabel("Trip Name");
        xAxis.setMin(500);
        xAxis.setMax(800);
       
    }
	
	
	 private LineChartModel initCategoryModel() {
		 List<Trip> trips = new ArrayList<Trip>();
		trips = tripEJB.DisplayAll();
		
	        LineChartModel model = new LineChartModel();
	 
	        ChartSeries tripSerie = new ChartSeries();
	        //boys.setLabel("");
	        for (Trip trip : trips) {
	        	tripSerie.set(""+trip.getDescription(), trip.getNumber());
				
	        }
	      
	        model.addSeries(tripSerie);

	        return model;
	    }
	 
	
	
	
	//******************
	
	public String checkSkier() {
		Skier s = null;
		Trip t = new Trip();

		try {
			s = skierEJB.findSkierByCardNumber(skier.getCardNumber());
			ReservationTripID rid = new ReservationTripID();
			rid.setSkierId((int) s.getIdSkier());

			t = TripBean.getStrip();
			System.out.println(t.getId());
			rid.setTripId(t.getId());
			reservationTrip.setReservationTripId(rid);
			reservationTrip.setTrip(t);
			reservationTrip.setSkier(s);
			reservation.addReservationTrip(reservationTrip);

			int p = t.getNumber();
			t.setNumber(p - 1);
			tripEJB.updateTrip(t);

			Float f = s.getCredit() - t.getPrice();
			if (f >= 0) {
				s.setCredit(f);
				skierEJB.updateSkier(s);
				envoyer(t, s.getEmail());
			} else {
			}

		} catch (Exception e) {

		}
		return "";
	}

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void envoyer(Trip trip, String mail) {
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("dhiaeddine.foudhaili@esprit.tn", "00193424619");
			}
		});
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("dhiaeddine.foudhaili@esprit.tn"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mail));
			message.setSubject("Participate in trip");
			message.setText("you are now subscribed at : " + trip.getDescription());
			Transport.send(message);

		} catch (MessagingException e) {

			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Failure to send");
			alert.setHeaderText("Please check your informations !!");

			alert.showAndWait();

		}

	}

}
