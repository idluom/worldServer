package Service;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Entity.Restaurant;

/**
 * Session Bean implementation class RestaurantEJB
 */
@Stateless
@LocalBean
public class RestaurantEJB implements RestaurantEJBRemote {
	@PersistenceContext(unitName="skiworld-ejb")
	EntityManager em;
    /**
     * Default constructor. 
     */
    public RestaurantEJB() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void addRestaurant(Restaurant restaurant) {
		em.persist(restaurant);
		
	}

	@Override
	public void deleteRestaurant(Restaurant restaurant) {
		em.merge(restaurant);
		em.remove(restaurant);
	}

	@Override
	public void updateRestaurant(Restaurant restaurant) {
		em.merge(restaurant);
	}

	@Override
	public Restaurant displayRestaurantById(Long idRestaurant) {
		return em.find(Restaurant.class, idRestaurant);		
	}

}
