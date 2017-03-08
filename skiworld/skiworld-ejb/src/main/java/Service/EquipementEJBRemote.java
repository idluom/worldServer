package Service;

import javax.ejb.Remote;

import Entity.Equipement;
import Entity.Skier;

@Remote
public interface EquipementEJBRemote {
	public void addEquipement(Equipement E);
	public void updateEquipement(Equipement E);
	public Equipement findEquipementById(Long id);
	public void delete(Equipement E);
	public  float priceAfterDiscount(Equipement E) ;
	 
	
	

}
