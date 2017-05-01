package Entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: TrackSkier
 *
 */
@Entity

public class TrackSkier implements Serializable {

	@EmbeddedId
	private TrackSkierID TrackSkierID;
	private static final long serialVersionUID = 1L;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idTrackPK",insertable=false,updatable=false)
	private Track track;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idSkierPK",insertable=false,updatable=false)
	private Skier skier;
	private int nbrePlaces;
	
	public TrackSkier(){
		TrackSkierID = new TrackSkierID();
	}
	
	
	
	public int getNbrePlaces() {
		return nbrePlaces;
	}
	public void setNbrePlaces(int nbrePlaces) {
		this.nbrePlaces = nbrePlaces;
	}
	  
	public TrackSkierID getTrackSkierID() {
		return this.TrackSkierID;
	}

	public void setTrackSkierID(TrackSkierID TrackSkierID) {
		this.TrackSkierID = TrackSkierID;
	}
	public Track getTrack() {
		return track;
	}
	public void setTrack(Track track) {
		TrackSkierID.setIdTrackPK(track.getIdTrack());
		this.track = track;
	}
	public Skier getSkier() {
		return skier;
	}
	public void setSkier(Skier skier) {
		TrackSkierID.setIdSkierPK(skier.getIdSkier());
		this.skier = skier;
	}

	@Override
	public String toString() {
		return "TrackSkier [TrackSkierID=" + TrackSkierID + ", track=" + track + ", skier=" + skier + ", nbrePlaces="
				+ nbrePlaces + "]";
	}
   
}
