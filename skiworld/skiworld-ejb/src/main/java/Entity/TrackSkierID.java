package Entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: TrackSkierID
 *
 */
@Embeddable

public class TrackSkierID implements Serializable {

	
	private long idSkierPK;
	private long idTrackPK;
	private static final long serialVersionUID = 1L;

	public TrackSkierID() {
		super();
	}   
	public long getIdSkierPK() {
		return this.idSkierPK;
	}

	public void setIdSkierPK(long idSkierPK) {
		this.idSkierPK = idSkierPK;
	}   
	public long getIdTrackPK() {
		return this.idTrackPK;
	}

	public void setIdTrackPK(long idTrackPK) {
		this.idTrackPK = idTrackPK;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idSkierPK ^ (idSkierPK >>> 32));
		result = prime * result + (int) (idTrackPK ^ (idTrackPK >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TrackSkierID other = (TrackSkierID) obj;
		if (idSkierPK != other.idSkierPK)
			return false;
		if (idTrackPK != other.idTrackPK)
			return false;
		return true;
	}
   
}
