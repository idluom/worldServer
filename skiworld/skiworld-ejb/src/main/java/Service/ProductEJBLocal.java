package Service;

import java.util.List;

import javax.ejb.Local;

import Entity.Product;


@Local
public interface ProductEJBLocal {
	public void addProduct (Product product);
	public void deleteProduct (Product product);
	public void updateProduct (Product product);
	public Product displayProductById (Long idProduct);
	public List<Product> findAllProduct() ;
	public byte[] findPictureByProductName(String productName);
}
