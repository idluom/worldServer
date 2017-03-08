package Service;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Entity.Discount;

/**
 * Session Bean implementation class DiscountEJB
 */
@Stateless
public class DiscountEJB implements DiscountEJBRemote {
	@PersistenceContext(unitName="skiworld-ejb")
	EntityManager em;
    /**
     * Default constructor. 
     */
    public DiscountEJB() {
       
    }

	@Override
	public void addDiscount(Discount D) {
		em.persist(D);
		
	}

	@Override
	public void updateDiscount(Discount D) {
	em.merge(D);
		
	}

	@Override
	public Discount findDiscountById(Long id) {
		return em.find(Discount.class, id);
	}

	@Override
	public void delete(Discount D) {
		
		em.remove(em.merge(D));
		
	}

}
