package Service;

import java.util.List;

import javax.ejb.Remote;

import Entity.Bill;

@Remote
public interface BillEJBRemote {
	public void addBill(Bill B) ;
	public void delete(Bill B) ;
	public void update(Bill B);
	public Bill FindById(Long id);
	public List<Bill> DisplayAllBills();
	
	
	

}
