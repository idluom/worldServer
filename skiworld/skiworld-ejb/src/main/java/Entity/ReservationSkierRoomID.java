package Entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
@Embeddable
public class ReservationSkierRoomID implements Serializable{

	private int idSkierPK;
	private int idRoomPK;
	private static final long serialVersionUID = 1L;

	public ReservationSkierRoomID() {
		super();
	}

	public int getIdSkierPK() {
		return idSkierPK;
	}

	public void setIdSkierPK(int idSkierPK) {
		this.idSkierPK = idSkierPK;
	}

	public int getIdRoomPK() {
		return idRoomPK;
	}

	public void setIdRoomPK(int idRoomPK) {
		this.idRoomPK = idRoomPK;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idRoomPK;
		result = prime * result + idSkierPK;
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
		if (idRoomPK != other.idRoomPK)
			return false;
		if (idSkierPK != other.idSkierPK)
			return false;
		return true;
	}

	

	
	
	
}
