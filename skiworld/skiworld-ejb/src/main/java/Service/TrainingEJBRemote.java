package Service;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import Entity.Training;

@Remote
public interface TrainingEJBRemote {
	public void addTraining(Training t);
	public void deleteTraining(Training t);
	public void updateTraing(Training t);
	public Training findTrainingById(long id);
	public List<Training> findAllTraining();
	public List <Training> findAllTrainingByLevel(String level,Date Bd);
}
