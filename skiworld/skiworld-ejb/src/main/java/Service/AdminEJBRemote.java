package Service;

import java.util.List;

import javax.ejb.Remote;

import Entity.Admin;
import Entity.HotelManager;
import Entity.Member;
import Entity.RestaurantOwner;
import Entity.ShopOwner;

@Remote
public interface AdminEJBRemote {

	public void addAdmin(Member member);
	public void updateAdmin(Member member);
	public void deleteAdmin(Admin a);
	public boolean deleteAdmin(int a);
	public List<Member> displayAll();
	public Admin getAdmin();
	public HotelManager getHotelManager();
	public ShopOwner getShopOwner();
	public RestaurantOwner getRestaurantOwner();
	
}
