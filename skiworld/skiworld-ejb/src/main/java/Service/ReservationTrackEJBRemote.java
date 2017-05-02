package Service;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import Entity.Track;
import Entity.TrackSkier;
@Remote
public interface ReservationTrackEJBRemote {
	public void addReservationTrack(TrackSkier reservation);
	public List<TrackSkier> checkReservation(long idTrack,Date date);
}
