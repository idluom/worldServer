package Entity;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import java.util.List;

import javax.persistence.*;





/**
 * Entity implementation class for Entity: Shop
 *
 */
@Entity

public class Shop implements Serializable {

	   
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private static final long serialVersionUID = 1L;
	@OneToMany(mappedBy="shop" ,fetch =FetchType.EAGER)
	private List<Equipement> listEquipements;
	@OneToOne (cascade=CascadeType.PERSIST)
	@JoinColumn(name="inventory_fk")
	private Inventory inventory;
    
	
	
	public Shop(String name, List<Equipement> listEquipements, Inventory inventory) {
		super();
		this.name = name;
		this.listEquipements = listEquipements;
		this.inventory = inventory;
	}
	public Shop() {
		super();
	}   
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Shop [id=" + id + ", name=" + name + "]";
	}
	public List<Equipement> getListEquipements() {
		return listEquipements;
	}
	public void setListEquipements(List<Equipement> listEquipements) {
		this.listEquipements = listEquipements;
	}
	public Inventory getInventory() {
		return inventory;
	}
	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}
	
   
}
