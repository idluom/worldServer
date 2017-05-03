package Service;

import javax.ejb.Remote;

import Entity.EquipementSkier;

@Remote
public interface EquipementSkierEJBRemote {
public void addEquipmentSkier(EquipementSkier E);
public void deleteEquipementSkier(EquipementSkier E);
public void updateEquipementSkier(EquipementSkier E);
public EquipementSkier findEquipementSkierById(Long id);

}
