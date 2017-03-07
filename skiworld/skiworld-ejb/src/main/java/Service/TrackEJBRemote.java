package Service;

import javax.ejb.Remote;

import Entity.Track;


@Remote
public interface TrackEJBRemote {
	public void addTrack(Track t);
}
