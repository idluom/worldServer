package Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import Entity.Equipement;


/**
 * Session Bean implementation class EquipementEJB
 */
@Stateless
@LocalBean
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
		System.out.println("ssss");
	return E.getPrice()-((E.getPrice()/100)*E.getDiscount().getPercentage());
	
	
		
	}
	@Override
	public List<Equipement> displayAllShopEquipement() {
		
		return em.createQuery("SELECT r FROM Equipement r WHERE r.shop is not null", Equipement.class).getResultList();
	}
	@Override
	public List<Equipement> displayAllInventoryEquipement() {
		return em.createQuery("SELECT r FROM Equipement r WHERE r.inventory is not null", Equipement.class).getResultList();
	}
	
	
	
	@Override
	public Equipement FindByName(String name) {
		try{ 
			 return	em.createQuery("SELECT m  FROM Equipement m WHERE m.name =?", Equipement.class)
				.setParameter(1,name).getSingleResult();
			}catch (Exception e) {	return null;}
	
	}
	@Override
	public List<Equipement> displayAllEquipement() {
		
		return em.createQuery("SELECT r FROM Equipement r ", Equipement.class).getResultList();
	}
	@Override
	public List<Equipement> displayAllDiscountEquipement() {
		return em.createQuery("SELECT r FROM Equipement r WHERE r.discount is not null", Equipement.class).getResultList();
	}
	@Override
	public List<Equipement> searchEquipement(String key) {	 
			
			 return em.createQuery("select u from Equipement  WHERE u.name like :1",Equipement.class).setParameter("1","%"+key+"%").getResultList();
		
			 
		}
	
	
	

}
