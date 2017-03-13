package Service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Entity.DayMenu;
import Entity.Product;

/**
 * Session Bean implementation class ProductEJB
 */
@Stateless
@LocalBean
public class ProductEJB implements ProductEJBRemote {
	@PersistenceContext(unitName="skiworld-ejb")
	EntityManager em;
    /**
     * Default constructor. 
     */
    public ProductEJB() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void addProduct(Product product) {
			em.persist(product);
	}

	@Override
	public void deleteProduct(Product product) {
		Product m = em.merge(product);
		em.remove(m);
	}

	@Override
	public void updateProduct(Product product) {
			em.merge(product);
	}

	@Override
	public Product displayProductById(Long idProduct) {

	return em.find(Product.class, idProduct);
	}
	public List<Product> findAllProduct() {
		return  em.createQuery("SELECT p from Product p",Product.class).getResultList();
		
	}
}
