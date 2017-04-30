package Entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: TrackSkierID
 *
 */
@Embeddable

public class TrackSkierID implements Serializable {

	
	private Long idSkierPK;
	private Long idTrackPK;
	private static final long serialVersionUID = 1L;

	public TrackSkierID() {
		
	}   
	

	public Long getIdSkierPK() {
		return idSkierPK;
	}

	public void setIdSkierPK(Long idSkierPK) {
		this.idSkierPK = idSkierPK;
	}


	public Long getIdTrackPK() {
		return idTrackPK;
	}


	public void setIdTrackPK(Long idTrackPK) {
		this.idTrackPK = idTrackPK;
	}

	@Override
	public int hashCode() {
		
		return super.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
	
		return super.equals(obj);
	}
   
}
