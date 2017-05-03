package Entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
@Embeddable
public class ReservationSkierRoomID implements Serializable{

	private Long idSkierPK;
	private Long idRoomPK;
	private static final long serialVersionUID = 1L;

	public ReservationSkierRoomID() {
		super();
	}

	public Long getIdSkierPK() {
		return idSkierPK;
	}

	public void setIdSkierPK(Long idSkierPK) {
		this.idSkierPK = idSkierPK;
	}

	public Long getIdRoomPK() {
		return idRoomPK;
	}

	public void setIdRoomPK(Long idRoomPK) {
		this.idRoomPK = idRoomPK;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idRoomPK == null) ? 0 : idRoomPK.hashCode());
		result = prime * result + ((idSkierPK == null) ? 0 : idSkierPK.hashCode());
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
		ReservationSkierRoomID other = (ReservationSkierRoomID) obj;
		if (idRoomPK == null) {
			if (other.idRoomPK != null)
				return false;
		} else if (!idRoomPK.equals(other.idRoomPK))
			return false;
		if (idSkierPK == null) {
			if (other.idSkierPK != null)
				return false;
		} else if (!idSkierPK.equals(other.idSkierPK))
			return false;
		return true;
	}

	

	
	
	
}
