package Service;

import java.util.List;

import javax.ejb.Remote;

import Entity.Product;


@Remote
public interface ProductEJBRemote {
	public void addProduct (Product product);
	public void deleteProduct (Product product);
	public void updateProduct (Product product);
	public Product displayProductById (Long idProduct);
	public List<Product> findAllProduct() ;
	public byte[] findPictureByProductName(String productName);
}
