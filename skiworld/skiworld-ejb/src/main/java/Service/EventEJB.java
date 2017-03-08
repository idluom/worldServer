package Service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Entity.Events;

/**
 * Session Bean implementation class EventEJB
 */
@Stateless
@LocalBean
public class EventEJB implements EventEJBRemote {
	@PersistenceContext(unitName = "skiworld-ejb")
	EntityManager em;

	/**
	 * Default constructor.
	 */
	public EventEJB() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addEvent(Events event) {
		em.merge(event);

	}

	@Override
	public void updateEvent(Events event) {
		em.merge(event);

	}

	@Override
	public void deleteEvent(Events event) {
		em.remove(em.merge(event));

	}

	@Override
	public Events findEventById(Long id) {
		return em.find(Events.class, id);
	}
	

	@Override
	public List<Events> findAllEvent() {
		return em.createQuery("SELECT e from Events e", Events.class).getResultList();
	}

}
