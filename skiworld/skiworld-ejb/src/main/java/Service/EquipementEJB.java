package Service;

import java.util.Date;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Entity.Equipement;
import Entity.Skier;

/**
 * Session Bean implementation class EquipementEJB
 */
@Stateless
public class EquipementEJB implements EquipementEJBRemote {
	@PersistenceContext(unitName="skiworld-ejb")
	EntityManager em;
    /**
     * Default constructor. 
     */
    public EquipementEJB() {
        // TODO Auto-generated constructor stub
    }
	@Override
	public void addEquipement(Equipement E) {
		em.persist(E);
		
	}
	@Override
	public void updateEquipement(Equipement E) {
		em.merge(E);
		
	}
	@Override
	public Equipement findEquipementById(Long id) {
		return em.find(Equipement.class, id);
	}
	@Override
	public void delete(Equipement E) {
		
		em.remove(em.merge(E));
		
	}
	@Override
	public float priceAfterDiscount(Equipement E) {
	return E.getPrice()-((E.getPrice()/100)*E.getDiscount().getPercentage());
	
		
	}
	
	

}
