package Service;

import java.util.List;

import javax.ejb.Remote;

import Entity.Trip;

@Remote
public interface TripEJBRemote {

	public void addTrip(Trip t);
	public void deleteTrip(Trip t);
	public void updateTrip(Trip t);
	public Trip findById(int id);
	public List<Trip> DisplayAll();
	public Long nbrSkier(int id);
	
}
