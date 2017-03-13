package Service;

import java.util.Date;
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
	public List<Bill> FindByDate(Date date );
	public List<Bill> FindByEquipementName(String name);
	
	

}
