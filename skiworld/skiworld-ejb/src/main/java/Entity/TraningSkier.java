package Entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: TraningSkier
 *
 */
@Entity

public class TraningSkier implements Serializable {

	@EmbeddedId
	private TrainingSkierID TrainingSkierID;
	@ManyToOne
	@JoinColumn(name="idTrainingPK",insertable=false,updatable=false)

	private Training training;
	@ManyToOne
	@JoinColumn(name="idSkierPK",insertable=false,updatable=false)

	private Skier skier;
	private static final long serialVersionUID = 1L;

	public TraningSkier() {
		super();
	}   
	public TrainingSkierID getTrainingSkierID() {
		return this.TrainingSkierID;
	}

	public void setTrainingSkierID(TrainingSkierID TrainingSkierID) {
		this.TrainingSkierID = TrainingSkierID;
	}   
	public Training getTraining() {
		return this.training;
	}

	public void setTraining(Training training) {
		this.training = training;
	}   
	public Skier getSkier() {
		return this.skier;
	}

	public void setSkier(Skier skier) {
		this.skier = skier;
	}
   
}
