package Entity;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import java.util.List;

import javax.persistence.*;


/**
 * Entity implementation class for Entity: Product
 *
 */
@Entity

public class Product implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idProduct;
	private String nameProduct;
	private Float productPrice;
	private String category;
	private String type;
	private byte[] picture;
	@ManyToOne
	private DayMenu menu;
	private static final long serialVersionUID = 1L;

	public Product() {
	}   
	
	/**
	 * @param idProduct
	 * @param nameProduct
	 * @param category
	 * @param type
	 * @param menu
	 */
	
	public Long getIdProduct() {
		return this.idProduct;
	}

	/**
	 * @param nameProduct
	 * @param productPrice
	 * @param category
	 * @param type
	 * @param menu
	 */
	public Product(String nameProduct, Float productPrice, String category, String type, DayMenu menu) {
		super();
		this.nameProduct = nameProduct;
		this.productPrice = productPrice;
		this.category = category;
		this.type = type;
		this.menu = menu;
	}

	/**
	 * @param idProduct
	 * @param nameProduct
	 * @param productPrice
	 * @param category
	 * @param type
	 * @param picture
	 * @param menu
	 */
	public Product(Long idProduct, String nameProduct, Float productPrice, String category, String type, byte[] picture,
			DayMenu menu) {
		super();
		this.idProduct = idProduct;
		this.nameProduct = nameProduct;
		this.productPrice = productPrice;
		this.category = category;
		this.type = type;
		this.picture = picture;
		this.menu = menu;
	}

	public void setIdProduct(Long idProduct) {
		this.idProduct = idProduct;
	}   
	public String getNameProduct() {
		return this.nameProduct;
	}

	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}   
	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}   
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public DayMenu getMenu() {
		return menu;
	}
	public void setMenu(DayMenu menu) {
		this.menu = menu;
	}
	
	public Float getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Float productPrice) {
		this.productPrice = productPrice;
	}

	@Override
	public String toString() {
		return "Product [nameProduct=" + nameProduct + ", category=" + category + ", type=" + type +  "]";
	}

	public byte[] getPicture() {
		return picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}
	
}
