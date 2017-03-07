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
	@ManyToOne
	@JoinColumn(name="idTrackPK",insertable=false,updatable=false)
	private Track track;
	@ManyToOne
	@JoinColumn(name="idSkierPK",insertable=false,updatable=false)
	private Skier skier;
	public TrackSkier() {
		super();
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
		this.track = track;
	}
	public Skier getSkier() {
		return skier;
	}
	public void setSkier(Skier skier) {
		this.skier = skier;
	}
   
}
