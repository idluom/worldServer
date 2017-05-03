package Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import Entity.Events;
import Entity.Room;

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
	}

	@Override
	public void addEvent(Events event) {
		em.persist(event);

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

	@Override
	public boolean findEventByDate(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Long i;
		i = (Long) em.createQuery("Select count(*) from Events e where e.date like '" + sdf.format(date) + "%'")
				.getSingleResult();
		if (i > 1){
			return false;
		}
		else if (i == 1) {

			Events event = em
					.createQuery("Select e from Events e where e.date like '" + sdf.format(date) + "%'", Events.class)
					.getSingleResult();
			String date1 = sdf.format(date);
			String dated1 = date1 + " 12:00";

			try {
				if (date.before(sdf2.parse(dated1))) {
					if (event.getDate().before(sdf2.parse(dated1)))
						return false;
					else
						return true;
				}
				else {
					if (event.getDate().before(sdf2.parse(dated1)))
						return true;
					else
						return false;
					
				}
			} catch (ParseException e) {
				e.printStackTrace();
				return false;
			}

		} else
			return true;
		
	}

	@Override
	public List<Events> findAllEventNotStarted() {
		Date date=new Date();
		return em.createQuery("SELECT e from Events e where e.date>:date", Events.class).setParameter("date", date).getResultList();
		
	}
	
	public List<Events> findEventsByDates(Date datedebut,Date datefin){
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String datedebut1 = sdf2.format(datedebut);
		String datefin1 = sdf2.format(datefin);
		
		List <Events> list= em.createQuery("Select e from Events e where e.date BETWEEN '"+datedebut1+"' AND '"+datefin1+"'").getResultList();
		return list;
		
		
	}
	

}
