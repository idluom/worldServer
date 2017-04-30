package Beans;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import Entity.Skier;
import Entity.Track;
import Entity.TrackSkier;
import Service.ReservationTrackEJB;
import Service.SkierEJB;
import Service.TrackEJB;

@ManagedBean(name="reservationTrack")
@SessionScoped
public class ReservationTrackBean {

	private Skier skier = new Skier();

	@EJB
	private SkierEJB skierEJB = new SkierEJB();
	@EJB
	private ReservationTrackEJB res = new ReservationTrackEJB();
	@EJB
	private TrackEJB trackEJB = new TrackEJB();
	
	private boolean formDisplayed=false;
	private TrackSkier reservation = new TrackSkier();
	private Track track = new Track();
	
	public ReservationTrackBean(){
		
	}
	
	public boolean isFormDisplayed() {
		return formDisplayed;
	}

	public void setFormDisplayed(boolean formDisplayed) {
		this.formDisplayed = formDisplayed;
	}

	public Track getTrack() {
		return track;
	}

	public void setTrack(Track track) {
		this.track = track;
	}

	
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

	public ReservationTrackEJB getRes() {
		return res;
	}

	public void setRes(ReservationTrackEJB res) {
		this.res = res;
	}

	public TrackEJB getTrackEJB() {
		return trackEJB;
	}

	public void setTrackEJB(TrackEJB trackEJB) {
		this.trackEJB = trackEJB;
	}

	public TrackSkier getReservation() {
		return reservation;
	}

	public void setReservation(TrackSkier reservation) {
		this.reservation = reservation;
	}
	
	public void info() {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Success !", "Enjoy Your Ride !"));
	}

	public void error() {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error !", "Something Went Wrong !"));
	}
	
	public String checkSkier() {
		try {
			Skier s = skierEJB.findSkierByCardNumber(skier.getCardNumber());
			reservation.setSkier(s);
		
			reservation.setTrack(track);
			
			
			if (s.getCredit() > track.getPrice()) {
				
				res.addReservationTrack(reservation);
				s.setCredit(s.getCredit() - track.getPrice() * reservation.getNbrePlaces());
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
}
