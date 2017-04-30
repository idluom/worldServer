package Service;

import java.util.List;

import javax.ejb.Local;

import Entity.TableRestaurant;

@Local
public interface TableRestaurantEJBLocal {

	void updateTable(TableRestaurant tableRestaurant);
	void addTable(TableRestaurant tableRestaurant);
	void deleteTable(TableRestaurant tableRestaurant);
	TableRestaurant displayTableById(Long idProduct);
	List<TableRestaurant> findAllTables();



}
