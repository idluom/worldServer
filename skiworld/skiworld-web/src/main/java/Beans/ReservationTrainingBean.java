package Beans;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import Entity.Skier;
import Entity.Training;
import Entity.TraningSkier;
import Service.ReservationTrainingEJB;
import Service.SkierEJB;
import Service.TrainingEJB;

@ManagedBean(name="reservationTraining")
@SessionScoped
public class ReservationTrainingBean {
	private Skier skier = new Skier();

	@EJB
	private SkierEJB skierEJB = new SkierEJB();
	@EJB
	private ReservationTrainingEJB res = new ReservationTrainingEJB();
	@EJB
	private TrainingEJB trainingEJB = new TrainingEJB();
	
	private boolean formDisplayed=false;
	private TraningSkier reservation = new TraningSkier();
	private Training training = new Training();
	
	// message de Notification : ajout avec succes
	public void info() {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Success !", "Enjoy Your Ride !"));
	}
	
	//message de notification : Error lors de l'ajout
	public void error() {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error !", "Something Went Wrong !"));
	}
	
	// Fonction de Reservation
	public String checkSkier() {
		try {
			Skier s = skierEJB.findSkierByCardNumber(skier.getCardNumber());
			reservation.setSkier(s);
		
			reservation.setTraining(training);
			
			
			if (s.getCredit() > training.getPrice()) {
				
				res.addReservationTraining(reservation);
				s.setCredit(s.getCredit() - training.getPrice() * reservation.getNbrePlaces());
				skierEJB.updateSkier(s);
//				Track tr = trackEJB.findTrackById(track.getIdTrack());
//				tr.setNumberPlaces(tr.getNumberPlaces() - reservation.getNbrePlaces());
//				trackEJB.updateTrack(tr);
				info();
				
			} else {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Error !", "Please Check Your Credit Before Continuing !"));
			}
		} catch (Exception e) {
			error();
			return "";
		}
		return "ListTrack";
	}
	public String showForm() {
		String navTo = "";
		setFormDisplayed(true);
		return navTo;
	}
	
	
	//getters et setters
	public Skier getSkier() {
		return skier;
	}
	public void setSkier(Skier skier) {
		this.skier = skier;
	}
	public SkierEJB getSkierEJB() {
		return skierEJB;
	}
	public void setSkierEJB(SkierEJB skierEJB) {
		this.skierEJB = skierEJB;
	}
	public ReservationTrainingEJB getRes() {
		return res;
	}
	public void setRes(ReservationTrainingEJB res) {
		this.res = res;
	}
	public TrainingEJB getTrackEJB() {
		return trainingEJB;
	}
	public void setTrainingEJB(TrainingEJB trackEJB) {
		this.trainingEJB = trackEJB;
	}
	public boolean isFormDisplayed() {
		return formDisplayed;
	}
	public void setFormDisplayed(boolean formDisplayed) {
		this.formDisplayed = formDisplayed;
	}
	public TraningSkier getReservation() {
		return reservation;
	}
	public void setReservation(TraningSkier reservation) {
		this.reservation = reservation;
	}
	public Training getTraining() {
		return training;
	}
	public void setTraining(Training training) {
		this.training = training;
	}
	
	

}
