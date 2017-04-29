package Service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Entity.Events;
import Entity.Skier;

/**
 * Session Bean implementation class SkierEJB
 */
@Stateless
@LocalBean
public class SkierEJB implements SkierEJBRemote {
	@PersistenceContext(unitName="skiworld-ejb")
	EntityManager em;
    /**
     * Default constructor. 
     */
    public SkierEJB() {
       
    }
	@Override
	public void addSkier(Skier S) {
		em.persist(S);
		
	}
	@Override
	public void updateSkier(Skier S) {
		em.merge(S);
		
	}
	@Override
	public Skier findSkierById(Long id) {
	return	em.find(Skier.class, id) ;
		
	}
	@Override
	public void delete(Skier S) {
		
		em.remove(em.merge(S));
		
	}
	@Override
	public List<Skier> findSkiersByEvent(Events event) {
		List<Skier> listSkier=new ArrayList<Skier>();
		listSkier=em.createQuery("select s from Skier s join s.listEvents e where e.id="+event.getIdEvents()).getResultList();
		return listSkier;
	}
	
	public Skier findSkierByCardNumber(int card) {
		return (Skier) em.createQuery("SELECT s FROM Skier s where s.cardNumber="+card);
	}
}
