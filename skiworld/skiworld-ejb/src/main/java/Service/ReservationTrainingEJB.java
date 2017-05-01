package Service;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Entity.TraningSkier;

/**
 * Session Bean implementation class ReservationTrainingEJB
 */
@Stateless
@LocalBean
public class ReservationTrainingEJB implements ReservationTrainingEJBRemote {

	@PersistenceContext(unitName = "skiworld-ejb")
	EntityManager em;
    /**
     * Default constructor. 
     */
    public ReservationTrainingEJB() {
        // TODO Auto-generated constructor stub
    }
	@Override
	public void addReservationTraining(TraningSkier reservation) {
		em.persist(reservation);
		
	}

}
