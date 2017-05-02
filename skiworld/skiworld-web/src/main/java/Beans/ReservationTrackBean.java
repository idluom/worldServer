package Beans;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;

import Entity.Skier;
import Entity.Track;
import Entity.TrackSkier;
import Service.ReservationTrackEJB;
import Service.SkierEJB;
import Service.TrackEJB;

@ManagedBean(name = "reservationTrack")
@ViewScoped
public class ReservationTrackBean {
	List<TrackSkier> a = new ArrayList<TrackSkier>();
	private Skier skier = new Skier();

	@EJB
	private SkierEJB skierEJB = new SkierEJB();
	@EJB
	private ReservationTrackEJB res = new ReservationTrackEJB();
	@EJB
	private TrackEJB trackEJB = new TrackEJB();

	private boolean formDisplayed = false;
	private TrackSkier reservation = new TrackSkier();
	private Track track = new Track();

	// @ManagedProperty("#{reservationTrack.reservation.dateReservation}")
	// private Date date;
	//
	public ReservationTrackBean() {

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
	// notification d'erreur
	public void error() {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error !", "You have been book for this Track !"));
	}

	 //Calendar fonction
	   public void onDateSelect(SelectEvent event) {
	        FacesContext facesContext = FacesContext.getCurrentInstance();
	        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
	        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));
	    }
	
	public String checkSkier() {
		try {
			Track t = trackEJB.findTrackById(track.getIdTrack());
			Skier s = skierEJB.findSkierByCardNumber(skier.getCardNumber());
			reservation.setSkier(s);

			reservation.setTrack(track);
			a = res.checkReservation(track.getIdTrack(), reservation.getDateReservation());
			if (s.getCredit() > (track.getPrice() * (reservation.getNbrePlaces()))) {

				// Date date = new Date();
				
				if (a.size() < track.getPlaces()) {
					System.out.println("mo3ez:" + a.size());
					res.addReservationTrack(reservation);
					s.setCredit(s.getCredit() - track.getPrice() * reservation.getNbrePlaces());
					skierEJB.updateSkier(s);
					//t.setPlaces(t.getPlaces()-1);
					//trackEJB.updateTrack(t);
					// Track tr = trackEJB.findTrackById(track.getIdTrack());
					// tr.setNumberPlaces(tr.get() -
					// reservation.getNbrePlaces());
					// trackEJB.updateTrack(tr);
					info();
					setFormDisplayed(false);
				}
				else 
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error !", "Sorry,All Places are reserved !"));
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
