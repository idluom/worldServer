package Beans;


import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import Entity.Equipement;
import Service.EquipementEJB;
import Service.EquipementEJBRemote;

import java.util.ArrayList;
import java.util.List;

@ManagedBean
@SessionScoped
public class ShopBean {
 @EJB
 private EquipementEJB equipementEJB ;
 private Equipement equipement = new Equipement() ; 
 private List<Equipement> listequipement = new ArrayList<Equipement>() ;
 private String key;
 
 @PostConstruct
 public void init() {
	listequipement= equipementEJB.displayAllEquipement(); 
 }
public EquipementEJB getEquipementEJB() {
	return equipementEJB;
}
public void setEquipementEJB(EquipementEJB equipementEJB) {
	this.equipementEJB = equipementEJB;
}
public Equipement getEquipement() {
	return equipement;
}
public void setEquipement(Equipement equipement) {
	this.equipement = equipement;
}
public List<Equipement> getListequipement() {
	return listequipement;
}
public void setListequipement(List<Equipement> listequipement) {
	this.listequipement = listequipement;
}
 public List<Equipement> doAfficherListEquipement()
 {
	return equipementEJB.displayAllEquipement(); 
 }
 
 
 public List<Equipement> doAfficherListDiscount()
 {
	return equipementEJB.displayAllDiscountEquipement(); 
 }
public String getKey() {
	return key;
}
public void setKey(String key) {
	this.key = key;
}
 public String search()
 {
	 listequipement=equipementEJB.searchEquipement(key);
	for (Equipement equipement : listequipement) {
		System.out.println(equipement);
	}
	return "";
	 
 }
 
}
