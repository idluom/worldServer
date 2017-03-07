package Entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Menu
 *
 */
@Entity

public class Menu implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long idMenu;
	@OneToMany (mappedBy = "menu")
	private List <Product> listProduct ;
	public Menu() {
	}
	public Long getIdMenu() {
		return idMenu;
	}
	public void setIdMenu(Long idMenu) {
		this.idMenu = idMenu;
	}
	public List<Product> getListProduct() {
		return listProduct;
	}
	public void setListProduct(List<Product> listProduct) {
		this.listProduct = listProduct;
	}

   
}
