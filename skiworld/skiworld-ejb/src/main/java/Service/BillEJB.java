package Service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Entity.Bill;


/**
 * Session Bean implementation class BillEJB
 */
@Stateless
public class BillEJB implements BillEJBRemote {
	@PersistenceContext(unitName="skiworld-ejb")
	EntityManager em;
    /**
     * Default constructor. 
     */
    public BillEJB() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void addBill(Bill B) {
		em.persist(B);
		
	}

	@Override
	public void delete(Bill B) {
		em.remove(em.merge(B));
		
	}

	@Override
	public void update(Bill B) {
		em.merge(B);
		
	}

	@Override
	public Bill FindById(Long id) {
	 return	em.find(Bill.class, id) ;
	}

	@Override
	public List<Bill> DisplayAllBills() {
		 return em.createQuery("SELECT r FROM Bill r ", Bill.class).getResultList();
		
	}

	
}
