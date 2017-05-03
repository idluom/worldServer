package Service;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import Entity.EquipementSkier;

/**
 * Session Bean implementation class EquipementSkierEJB
 */
@Stateless
@LocalBean
public class EquipementSkierEJB implements EquipementSkierEJBRemote {
	@PersistenceContext(unitName="skiworld-ejb")
	EntityManager em;
    /**
     * Default constructor. 
     */
    public EquipementSkierEJB() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void addEquipmentSkier(EquipementSkier E) {
		
		em.persist(em.merge(E));
	}

	@Override
	public void deleteEquipementSkier(EquipementSkier E) {
		// TODO Auto-generated method stub
		em.remove(em.merge(E));
		
	}

	@Override
	public void updateEquipementSkier(EquipementSkier E) {
		em.merge(E);
		
	}

	@Override
	public EquipementSkier findEquipementSkierById(Long id) {
		return em.find(EquipementSkier.class, id);
	}

}
