package Beans;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import Entity.Events;
import Entity.ReservationSkierRoom;
import Entity.Room;
import Entity.Skier;
import Service.EventEJB;
import Service.ReservationRoomEJB;
import Service.RoomEJB;
import Service.SkierEJB;

@ManagedBean
@ViewScoped
public class RoomBean implements Serializable {

	private static final long serialVersionUID = 1L;
	@EJB
	private RoomEJB roomEJB;
	@EJB
	private SkierEJB skierEJB;
	@EJB
	private ReservationRoomEJB reservationRoomEJB;
	@EJB
	private EventEJB eventEJB;
	private Room room;
	private Skier skier;
	private ReservationSkierRoom reservation;

	private List<Room> rooms;
	private boolean formDisplayed = false;
	private boolean formDisplayed2 = false;

	public RoomBean() {
	}

	@PostConstruct
	public void init() {
		setRoom(new Room());
		setRooms(roomEJB.findAllRoom());
		reservation = new ReservationSkierRoom();
		skier = new Skier();

	}

	public boolean isFormDisplayed() {
		return formDisplayed;
	}

	public void setFormDisplayed(boolean formDisplayed) {
		this.formDisplayed = formDisplayed;
	}

	public String test() {
		System.out.println("**************************************************************************"
				+ "********************************************************************************************"
				+ "**************************************************************************************");
		System.out.println(room.getNbrDoubleBed() + "////" + room.getNbrSimpleBed());
		return "Hotel?faces-redirect=true";
	}

	public String showForm() {
		String navTo = "";
		setFormDisplayed(true);
		setFormDisplayed2(false);
		return navTo;
	}

	public String showFormPayement() {
		System.out.println("HEloooooooooooooooooooooo");
		String navTo = "";
		setFormDisplayed(false);
		setFormDisplayed2(true);
		return navTo;
	}

	public String checkReservation() throws ParseException {
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		 SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		 Date datedebut = reservation.getDateDebut();
		 Date datefin = reservation.getDateFin();
		 String datedebut1 = sdf.format(datedebut);
		 String datefin1 = sdf.format(datefin);
		 datedebut1 = datedebut1 + " 13:00";
		 datefin1 = datefin1 + " 12:00";
		 Date datedebut2 = sdf2.parse(datedebut1);
		 Date datefin2 = sdf2.parse(datefin1);
		 reservation.setDateDebut(datedebut2);
		 reservation.setDateFin(datefin2);
		
		if (!reservation.getDateDebut().before(reservation.getDateFin())) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error !", "End date must be after start date"));

		} else {
			System.out.println("ROOM ID :" + room.getIdRoom());

			if (reservationRoomEJB.checkReservation(reservation.getDateDebut(), reservation.getDateFin(), room)) {
				setFormDisplayed(false);
				setFormDisplayed2(true);
			} else {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error !", "Can't book !! choose another date"));
			}

		}

		return "";
	}

	public String checkSkier() {
		try {
			Skier s = skierEJB.findSkierByCardNumber(skier.getCardNumber());
			System.out.println("SKIERRRRRR" + s);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			Date datedebut = reservation.getDateDebut();
			Date datefin = reservation.getDateFin();
			String datedebut1 = sdf.format(datedebut);
			String datefin1 = sdf.format(datefin);
			datedebut1 = datedebut1 + " 13:00";
			datefin1 = datefin1 + " 12:00";
			Date datedebut2 = sdf2.parse(datedebut1);
			Date datefin2 = sdf2.parse(datefin1);
			reservation.setDateDebut(datedebut2);
			reservation.setDateFin(datefin2);
			reservation.setSkier(s);
			System.out.println(s + "////////**********");
			reservation.setRoom(room);

			if (s.getCredit() > room.getPrice()) {
				System.out.println("debut reservation");
				reservationRoomEJB.addReservationRoom(reservation);
				s.setCredit(s.getCredit() - room.getPrice());
				List<Events> list = eventEJB.findEventsByDates(reservation.getDateDebut(), reservation.getDateFin());
				for (Events events : list) {
					System.out.println(events);
					System.out.println("foreeach events");

					System.out.println("AAAAAA");
					events.getListSkier().add(s);
					System.out.println("BBBBBBB");
					events.setNbrPlaces(events.getNbrPlaces() - 1);
					System.out.println("before update events");
					eventEJB.updateEvent(events);
					System.out.println("After update events");

				}
				s.setListEvents(list);
				System.out.println("before update skier");
				skierEJB.updateSkier(s);
				System.out.println("After update events");

				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Success !", "Enjoy Your Lodgging !"));
			} else {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Error !", "Please Check Your Credit Before Continuing !"));
			}

		} catch (Exception e) {

			System.out.println("erreur");
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error !", "Something Went Wrong !"));
			return "";
		}
		return "ListRoom";
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {

		this.room = room;
	}

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

	public Skier getSkier() {
		return skier;
	}

	public void setSkier(Skier skier) {
		this.skier = skier;
	}

	public boolean isFormDisplayed2() {
		return formDisplayed2;
	}

	public void setFormDisplayed2(boolean formDisplayed2) {
		this.formDisplayed2 = formDisplayed2;
	}

	public ReservationSkierRoom getReservation() {
		return reservation;
	}

	public void setReservation(ReservationSkierRoom reservation) throws ParseException {

		this.reservation = reservation;
	}

}
