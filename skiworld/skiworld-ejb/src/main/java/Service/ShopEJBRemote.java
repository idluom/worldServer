package Service;

import javax.ejb.Remote;

import Entity.Shop;


@Remote
public interface ShopEJBRemote {
	public void addShop(Shop S);
	public void updateShop(Shop S);
	public Shop findShopById(Long id) ;
	public void delete(Shop S) ;
	
}
