package Service;

import javax.ejb.Remote;

import Entity.Inventory;

@Remote
public interface InventoryEJBRemote {
 public void update(Inventory I);
 public Inventory findInventoryByID(Long id);
 
}
