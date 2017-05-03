package Service;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Entity.ReservationTransport;

/**
 * Session Bean implementation class ReservationTransportEJB
 */
@Stateless
@LocalBean
public class ReservationTransportEJB implements ReservationTransportEJBRemote {

	@PersistenceContext(unitName = "skiworld-ejb")
	EntityManager em;
    /**
     * Default constructor. 
     */
    public ReservationTransportEJB() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void addReservationTransport(ReservationTransport reservation) {
		System.out.println(reservation.getTransport().getArrivalPlace()+" ADDEEEEEED !!");
		em.persist(reservation);
	}

}
