package Service;

import java.util.List;

import javax.ejb.Remote;

import Entity.TableRestaurant;

@Remote
public interface TableRestaurantEJBRemote {

	void updateTable(TableRestaurant tableRestaurant);
	void addTable(TableRestaurant tableRestaurant);
	void deleteTable(TableRestaurant tableRestaurant);
	TableRestaurant displayTableById(Long idProduct);
	List<TableRestaurant> findAllTables();

}
