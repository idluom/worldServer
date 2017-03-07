package Entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: TrainingSkierID
 *
 */
@Embeddable

public class TrainingSkierID implements Serializable {

	
	private long idSkierPK;
	private long idTrainingPK;
	private static final long serialVersionUID = 1L;

	public TrainingSkierID() {
		super();
	}   
	public long getIdSkierPK() {
		return this.idSkierPK;
	}

	public void setIdSkierPK(long idSkierPK) {
		this.idSkierPK = idSkierPK;
	}   
	public long getIdTrainingPK() {
		return this.idTrainingPK;
	}

	public void setIdTrainingPK(long idTrainingPK) {
		this.idTrainingPK = idTrainingPK;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idSkierPK ^ (idSkierPK >>> 32));
		result = prime * result + (int) (idTrainingPK ^ (idTrainingPK >>> 32));
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
		TrainingSkierID other = (TrainingSkierID) obj;
		if (idSkierPK != other.idSkierPK)
			return false;
		if (idTrainingPK != other.idTrainingPK)
			return false;
		return true;
	}
   
}
