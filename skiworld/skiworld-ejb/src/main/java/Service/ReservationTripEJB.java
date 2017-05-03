package Service;

import java.util.List;


import javax.ejb.LocalBean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Entity.ReservationTrip;
import Entity.Trip;


/**
 * Session Bean implementation class ReservationTrip
 */
@Stateless
@LocalBean
public class ReservationTripEJB implements ReservationTripRemote {

	@PersistenceContext
	EntityManager em;
    /**
     * Default constructor. 
     */
    public ReservationTripEJB() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void addReservationTrip(ReservationTrip rt) {
		em.persist(rt);	
	}

	@Override
	public List<ReservationTrip> DisplayAll() {
		return em.createQuery("select t from ReservationTrip t", ReservationTrip.class).getResultList();
	}

	@Override
	public void Delete(ReservationTrip rt) {
		em.remove(em.merge(rt));
	}


	
	
}
