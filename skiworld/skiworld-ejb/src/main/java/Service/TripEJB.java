package Service;

import java.text.SimpleDateFormat;
import java.util.Date;
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
		// em.createQuery("SELECT r FROM r where r.id = ?")
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

	@Override
	public Long nbrSkier(int id) {
		Long i = (Long) em.createQuery("select count(*)  from Skier s join s.Trips t where t.id=" + id)
				.getSingleResult();
		return i;
	}

	@Override
	public Boolean tripList(Date d) {
		
		Long i= (Long)em.createQuery("select count(*) from Transport p where p.departureDate=:date").setParameter("date", d).getSingleResult();
		System.out.println("NUMBER OF IS///************************************************************************ "+i);
		if (i==0)
		{
			System.out.println("************************************************************");
			return false;
		}
		else return true;
	
	}

}
