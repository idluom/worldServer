package Service;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Entity.ReservationSkierRoom;
import Entity.Room;

/**
 * Session Bean implementation class ReservationRoomEJB
 */
@Stateless
@LocalBean
public class ReservationRoomEJB implements ReservationRoomEJBRemote {
	@PersistenceContext
	EntityManager em;

	/**
	 * Default constructor.
	 */
	public ReservationRoomEJB() {

	}

	public void addReservationRoom(ReservationSkierRoom reservationSkierRoom) {
		em.persist(reservationSkierRoom);
	}

	public void deleteReservationRoom(ReservationSkierRoom reservationSkierRoom) {
		em.remove(em.merge(reservationSkierRoom));
	}

	public Boolean checkReservation(Date datedebut, Date datefin, Room room) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String datedebut1 = sdf.format(datedebut);
		String datefin1 = sdf.format(datefin);
		datedebut1 = datedebut1 + " 13:00";
		datefin1 = datefin1 + " 12:00";

		Long i;
		

		i = (Long) em
				.createQuery("Select count(*) from ReservationSkierRoom e where( ((e.dateDebut BETWEEN '" + datedebut1
						+ "' AND '" + datefin1 + "') OR ('" + datedebut1
						+ "' BETWEEN e.dateDebut AND e.dateFin)) AND (e.room=" + room.getIdRoom() + "))")
				.getSingleResult();

		System.out.println("Le nombre de reservation est :" + i);
		if (i < room.getNbr()) {
			return true;
		} else {
			return false;
		}

	}

}
