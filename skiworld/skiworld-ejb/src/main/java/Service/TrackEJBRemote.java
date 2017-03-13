package Service;



import java.util.List;

import javax.ejb.Remote;

import Entity.Track;


@Remote
public interface TrackEJBRemote {
	public void addTrack(Track t);
	public void deleteTrack(Track t);
	public void updateTrack(Track t);
	public Track findTrackById(Long idTrack);
	public List<Track> findAll();
	public Track findTrackByDiff(String diff);
}
