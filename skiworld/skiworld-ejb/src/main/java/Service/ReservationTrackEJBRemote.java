package Service;

import javax.ejb.Remote;
import Entity.TrackSkier;
@Remote
public interface ReservationTrackEJBRemote {
	public void addReservationTrack(TrackSkier reservation);
}
