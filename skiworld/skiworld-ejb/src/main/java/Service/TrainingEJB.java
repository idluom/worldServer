package Service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Entity.Track;
import Entity.Training;

@Stateless
public class TrainingEJB implements TrainingEJBRemote {
	@PersistenceContext(unitName="skiworld-ejb")
	EntityManager em;

	@Override
	public void addTraining(Training t) {
		em.persist(t);
	}

	@Override
	public void deleteTraining(Training t) {
		em.remove(em.merge(t));
		
	}

	@Override
	public void updateTraing(Training t) {
		
		em.merge(t);
	}

	@Override
	public Training findTrainingById(long idTraining) {
		
		return em.createQuery("select p from Training p where p.idTraining=?1",Training.class).setParameter(1,idTraining).getSingleResult();
		//return em.createQuery("select p from Track p where p.difficulty=?1",Track.class).setParameter(1,diff).getSingleResult();
	}

	@Override
	public List<Training> findAllTraining() {
		
		return em.createQuery("select p from Training p",Training.class).getResultList();
	}
	
}
