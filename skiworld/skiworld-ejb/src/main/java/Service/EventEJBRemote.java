package Service;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import Entity.Events;


@Remote
public interface EventEJBRemote {
	public void addEvent(Events event);
	public void updateEvent(Events event);
	public void deleteEvent(Events event);
	public Events findEventById(Long id);
	public List<Events> findAllEvent();
	public boolean findEventByDate(Date date);
}
