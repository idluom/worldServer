package Service;

import javax.ejb.Remote;

import Entity.TraningSkier;

@Remote
public interface ReservationTrainingEJBRemote {
	public void addReservationTraining(TraningSkier reservation);
}
