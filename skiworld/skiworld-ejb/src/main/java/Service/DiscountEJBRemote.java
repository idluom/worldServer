package Service;



import javax.ejb.Remote;

import Entity.Discount;

@Remote
public interface DiscountEJBRemote {
	public void addDiscount(Discount D);
	public void updateDiscount(Discount D);
	public Discount findDiscountById(Long id);
	public void delete (Discount D);
	public Discount findByPercentage(Float percentage) ;
	
	

}
