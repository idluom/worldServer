package Entity;

import java.io.Serializable;


public class BookingSkierTableID implements Serializable{
	
	private int idSkierPK;
	private int idTablePK;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idSkierPK;
		result = prime * result + idTablePK;
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
		BookingSkierTableID other = (BookingSkierTableID) obj;
		if (idSkierPK != other.idSkierPK)
			return false;
		if (idTablePK != other.idTablePK)
			return false;
		return true;
	}
	
	private static final long serialVersionUID = 1L;
	public int getIdSkierPK() {
		return idSkierPK;
	}
	public void setIdSkierPK(int idSkierPK) {
		this.idSkierPK = idSkierPK;
	}
	public int getIdTablePK() {
		return idTablePK;
	}
	public void setIdTablePK(int idTablePK) {
		this.idTablePK = idTablePK;
	}

	
}
