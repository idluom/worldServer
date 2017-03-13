package Entity;

import java.io.Serializable;
import java.lang.Long;
import java.util.List;

import javax.persistence.*;


/**
 * Entity implementation class for Entity: Inventory
 *
 */
@Entity

public class Inventory implements Serializable {

	   
	@Id
	@GeneratedValue
	private Long id;
	private Long capacity;
	private static final long serialVersionUID = 1L;
	@OneToOne(mappedBy="inventory")
	private Shop shop;
	@OneToMany(mappedBy="inventory")
	private List<Equipement> listEquipement;
	
	
	
	public Inventory(Long capacity, Shop shop, List<Equipement> listEquipement) {
		super();
		this.capacity = capacity;
		this.shop = shop;
		this.listEquipement = listEquipement;
	}
	public Inventory() {
		super();
	}   
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}   
	public Long getCapacity() {
		return this.capacity;
	}

	public void setCapacity(Long capacity) {
		this.capacity = capacity;
	}
	
	public Shop getShop() {
		return shop;
	}
	public void setShop(Shop shop) {
		this.shop = shop;
	}
	public List<Equipement> getListEquipements() {
		return listEquipement;
	}
	public void setListEquipements(List<Equipement> listEquipements) {
		this.listEquipement = listEquipements;
	}
	@Override
	public String toString() {
		return "Inventory [id=" + id + ", capacity=" + capacity + "]";
	}
   
}
