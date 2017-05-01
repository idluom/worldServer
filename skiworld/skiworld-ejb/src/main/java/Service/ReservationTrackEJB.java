package Service;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Entity.TrackSkier;
/**
 * Session Bean implementation class ReservationTrackEJB
 */
@Stateless
@LocalBean
public class ReservationTrackEJB implements ReservationTrackEJBRemote{
	@PersistenceContext(unitName = "skiworld-ejb")
	EntityManager em;
	
	
	 /**
     * Default constructor. 
     */
    public ReservationTrackEJB() {
        // TODO Auto-generated constructor stub
    }
	@Override
	public void addReservationTrack(TrackSkier reservation) {
		
		em.persist(reservation);
	}
	
}
