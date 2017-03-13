package Service;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Entity.Shop;


/**
 * Session Bean implementation class ShopEJB
 */
@Stateless
public class ShopEJB implements ShopEJBRemote {

	@PersistenceContext(unitName="skiworld-ejb")
	EntityManager em;
    /**
     * Default constructor. 
     */
    public ShopEJB() {
        // TODO Auto-generated constructor stub
    }
	@Override
	public void addShop(Shop S) {
		em.persist(S);
		
	}
	@Override
	public void updateShop(Shop S) {
		em.merge(S);
		
	}
	@Override
	public Shop findShopById(Long id) {
		return em.find(Shop.class, id);
		
	}
	@Override
	public void delete(Shop S) {
		// pour convertir en etat managed
		em.remove(em.merge(S));
		
	}

}
