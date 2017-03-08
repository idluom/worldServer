package Service;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Entity.Inventory;

/**
 * Session Bean implementation class InventoryEJB
 */
@Stateless
public class InventoryEJB implements InventoryEJBRemote {

	@PersistenceContext(unitName="skiworld-ejb")
	EntityManager em;
    /**
     * Default constructor. 
     */
    public InventoryEJB() {
        // TODO Auto-generated constructor stub
    }
    
	@Override
	public void update(Inventory I) {
		em.merge(I);
		}

	@Override
	public Inventory findInventoryByID(Long id) {
		return em.find(Inventory.class, id);
	}

	

}
