package Entity;

import java.io.Serializable;
import java.lang.Float;
import java.lang.Long;
import java.lang.String;
import java.sql.Blob;

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
	private Float shopquantity ;
	private Float inventoryquantity ;
	@Lob
	private byte[] Photo ;
	private static final long serialVersionUID = 1L;
   @ManyToOne
   private Shop shop ;
   @ManyToOne
   private Inventory inventory ;
   @ManyToOne
   private Discount discount ;
   
   
    
   
	
	
	public Equipement(String name, String category, Float price, String type, Float shopquantity, Float inventoryquantity,
		byte[] photo, Shop shop, Inventory inventory, Discount discount) {
	super();
	this.name = name;
	this.category = category;
	this.price = price;
	this.type = type;
	this.shopquantity = shopquantity;
	this.inventoryquantity = inventoryquantity;
	Photo = photo;
	this.shop = shop;
	this.inventory = inventory;
	this.discount = discount;
}
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
	
	
	public Inventory getInventory() {
		return inventory;
	}
	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}
	public Discount getDiscount() {
		return discount;
	}
	public void setDiscount(Discount discount) {
		this.discount = discount;
	}
	
	public byte[] getPhoto() {
		return Photo;
	}
	public void setPhoto(byte[] photo) {
		Photo = photo;
	}
	
	public Float getShopquantity() {
		return shopquantity;
	}
	public void setShopquantity(Float shopquantity) {
		this.shopquantity = shopquantity;
	}
	public Float getInventoryquantity() {
		return inventoryquantity;
	}
	public void setInventoryquantity(Float inventoryquantity) {
		this.inventoryquantity = inventoryquantity;
	}
	@Override
	public String toString() {
		return "Equipement [name=" + name + ", category=" + category + ", price=" + price + ", type=" + type
				+ ", shopquantity=" + shopquantity + ", inventoryquantity=" + inventoryquantity + ", Photo=" + Photo
				+ ", shop=" + shop + ", inventory=" + inventory + ", discount=" + discount + "]";
	}
	
	
   
}
