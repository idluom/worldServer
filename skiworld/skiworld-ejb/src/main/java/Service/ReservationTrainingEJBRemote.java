package Service;

import java.util.List;

import javax.ejb.Remote;

import Entity.Training;
import Entity.TraningSkier;

@Remote
public interface ReservationTrainingEJBRemote {
	public void addReservationTraining(TraningSkier reservation);
	public List<Training> showmyReservation(int pin);
}
