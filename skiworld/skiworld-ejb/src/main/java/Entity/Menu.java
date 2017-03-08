package Entity;

import java.util.List;



public class Menu {
	
	private List <Product> listProduct ;
	
	public Menu() {
	}

	public List<Product> getListProduct() {
		return listProduct;
	}

	public void setListProduct(List<Product> listProduct) {
		this.listProduct = listProduct;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((listProduct == null) ? 0 : listProduct.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Menu other = (Menu) obj;
		if (listProduct == null) {
			if (other.listProduct != null)
				return false;
		} else if (!listProduct.equals(other.listProduct))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Menu [listProduct=" + listProduct + "]";
	}
	

   
}
