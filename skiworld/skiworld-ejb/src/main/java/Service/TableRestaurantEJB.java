package Service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Entity.TableRestaurant;

/**
 * Session Bean implementation class TableRestaurantEJB
 */
@Stateless
@LocalBean
public class TableRestaurantEJB implements TableRestaurantEJBRemote, TableRestaurantEJBLocal {

	@PersistenceContext(unitName="skiworld-ejb")
	EntityManager em;
    /**
     * Default constructor. 
     */
    public TableRestaurantEJB() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void addTable(TableRestaurant tableRestaurant) {
			em.persist(tableRestaurant);
	}

	@Override
	public void deleteTable(TableRestaurant tableRestaurant) {
		TableRestaurant m = em.merge(tableRestaurant);
		em.remove(m);
	}

	@Override
	public void updateTable(TableRestaurant tableRestaurant) {
			em.merge(tableRestaurant);
	}

	@Override
	public TableRestaurant displayTableById(Long idProduct) {

	return em.find(TableRestaurant.class, idProduct);
	}
	@Override
	public List<TableRestaurant> findAllTables() {
		return  em.createQuery("SELECT p from TableRestaurant p",TableRestaurant.class).getResultList();
	}
	
}
