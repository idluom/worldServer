package Entity;

import java.io.Serializable;
import java.lang.Float;
import java.lang.Long;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Equipement
 *
 */
@Entity


public class Equipement implements Serializable {

	   
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String category;
	private Float price;
	private String type;
	private static final long serialVersionUID = 1L;
   @ManyToOne
   private Shop shop ;
   @ManyToOne
   private Inventory inventory ;
   
   

	public Equipement() {
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
	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}   
	public Float getPrice() {
		return this.price;
	}

	
	public void setPrice(Float price) {
		this.price = price;
	}   
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public Shop getShop() {
		return shop;
	}
	public void setShop(Shop shop) {
		this.shop = shop;
	}
	
	
	/*public Inventory getInventory() {
		return inventory;
	}
	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}*/
	@Override
	public String toString() {
		return "Equipement [name=" + name + ", category=" + category + ", price=" + price + ", type=" + type + "]";
	}
	
	
   
}
