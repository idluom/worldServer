package Service;


import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Entity.Transport;
import Entity.Trip;

/**
 * Session Bean implementation class TripEJB
 */
@Stateless
public class TripEJB implements TripEJBRemote {
	@PersistenceContext
	EntityManager em;
	
  
    public TripEJB() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void addTrip(Trip t) {
		em.persist(t);
	}

	@Override
	public void deleteTrip(Trip t) {
		em.remove(em.merge(t));		
	}

	@Override
	public void updateTrip(Trip t) {
		em.merge(t);
		
	}

	@Override
	public Trip findById(int id) {
		return em.find(Trip.class, id);
	}

	@Override
	public List<Trip> DisplayAll() { 
		return em.createQuery("select t from Trip t", Trip.class).getResultList();
	}
	


}
