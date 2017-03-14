package Service;

import java.text.SimpleDateFormat;

import java.util.Date;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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

	@Override
	public List<Training> findAllTrainingByLevel(String level,Date Bd) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String date=sdf.format(Bd);
		
		return em.createQuery("select p from Training p where p.level=?1 and p.begeningDate like '"+date+"%'",Training.class).setParameter(1,level).getResultList();
	//	return em.createQuery("select p from Training p where p.level=?1 and p.begeningDate=?2",Training.class).setParameter(1,level).setParameter(2, Bd).getResultList();
	}

	@Override
	public List<Training> findAllTrainingTransportByDate(Date d) {
		return em.createQuery("select p from Training p inner join Trip t where p.begeningDate=t.date and p.begeningDate=?1",Training.class).setParameter(1,d).getResultList();
		
	}
	
	
	
}
