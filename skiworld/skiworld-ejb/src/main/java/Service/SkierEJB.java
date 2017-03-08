package Service;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Entity.Skier;

/**
 * Session Bean implementation class SkierEJB
 */
@Stateless
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
	
	
}
