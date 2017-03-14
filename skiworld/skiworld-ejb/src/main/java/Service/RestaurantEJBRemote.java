package Service;

import javax.ejb.Remote;

import Entity.Restaurant;

@Remote
public interface RestaurantEJBRemote {
		public void addRestaurant (Restaurant restaurant);
		public void deleteRestaurant (Restaurant restaurant);
		public void updateRestaurant (Restaurant restaurant);
		public Restaurant displayRestaurantById (Long id);

}
