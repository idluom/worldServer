package Beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import Entity.Equipement;
import Entity.EquipementSkier;
import Entity.Skier;
import Service.EquipementEJB;
import Service.EquipementSkierEJB;
import Service.SkierEJB;

@ManagedBean
@SessionScoped
public class AchatEquipementBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private Skier skier = new Skier();
	@EJB
	private SkierEJB skierEJB = new SkierEJB();
	@EJB
	private EquipementEJB equipementEJB = new EquipementEJB();
	@EJB
	private EquipementSkierEJB a = new EquipementSkierEJB();
	private EquipementSkier achat = new EquipementSkier();
	private boolean formDisplayed = false;
	private Equipement E = new Equipement();
	private Date date = new Date();
	private List<Equipement> panierequipement = new ArrayList<Equipement>();
	private float somme = 0;


	public AchatEquipementBean() {
		super();
	}

	public EquipementSkierEJB getA() {
		return a;
	}

	public void setA(EquipementSkierEJB a) {
		this.a = a;
	}

	public EquipementSkier getAchat() {
		return achat;
	}

	public void setAchat(EquipementSkier achat) {
		this.achat = achat;
	}

	public Skier getSkier() {
		return skier;
	}

	public void setSkier(Skier skier) {
		this.skier = skier;
	}

	public SkierEJB getSkierEJB() {
		return skierEJB;
	}

	public void setSkierEJB(SkierEJB skierEJB) {
		this.skierEJB = skierEJB;
	}

	public EquipementEJB getEquipementEJB() {
		return equipementEJB;
	}

	public void setEquipementEJB(EquipementEJB equipementEJB) {
		this.equipementEJB = equipementEJB;
	}

	public boolean isFormDisplayed() {
		return formDisplayed;
	}

	public void setFormDisplayed(boolean formDisplayed) {
		this.formDisplayed = formDisplayed;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Equipement getE() {
		return E;
	}

	public void setE(Equipement e) {
		E = e;
	}

	public List<Equipement> getPanierequipement() {
		return panierequipement;
	}

	public void setPanierequipement(List<Equipement> panierequipement) {
		this.panierequipement = panierequipement;
	}

	public float getSomme() {
		return somme;
	}

	public void setSomme(float somme) {
		this.somme = somme;
	}
	
	

	

	public String showForm() {
		String navTo = "formBy?faces-redirect=true";
		setFormDisplayed(true);
		return navTo;
	}

	public void info() {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Success !", " By Successfuk !"));
	}

	public void error(String msg) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error !", msg));
	}

	public String achat() {
		Skier s = null;
		try {
			s = skierEJB.findSkierByCardNumber(skier.getCardNumber());
		} catch (Exception e) {
			error("check your cardnumber");
			return "";

		}
		System.out.println(s);
		System.out.println(E);
		System.out.println("-------");
		if (s.getCredit() < E.getPrice()) {
			error("insuffisant credits");
			return "";
		}
		if (E.getShopquantity() == 0) {
			error("quantity unavailabe");
			return "";

		}
		achat.setSkier(s);

		achat.setEquipement(E);

		achat.setPrice(E.getPrice());

		a.addEquipmentSkier(achat);

		s.setCredit(s.getCredit() - E.getPrice());

		skierEJB.updateSkier(s);

		Equipement h = equipementEJB.findEquipementById(E.getId());

		System.out.println(h);

		h.setShopquantity(h.getShopquantity() - 1);

		equipementEJB.updateEquipement(h);

		info();
		return "";
	}

	public String rentForm() {
		String navTo = "rent?faces-redirect=true";
		setFormDisplayed(true);
		return navTo;
	}

	public String rent() {
		Skier s = null;
		try {
			s = skierEJB.findSkierByCardNumber(skier.getCardNumber());
		} catch (Exception e) {
			error("check you cardnumber");
			return "";

		}
		int k = achat.getDatefin().getDay() - achat.getDatedebut().getDay();
		System.out.println("!!!!!!!!!" + k);
		System.out.println(s);
		System.out.println(E);
		if (s.getCredit() < (achat.getNumber() * (E.getPrice() / 10)) * k) {
			error("insuffisant credit");
			return "";

		}

		if (achat.getNumber() > E.getInventoryquantity()) {
			error(" quantity unavailable");
			return "";

		}
		if (achat.getDatedebut().after(achat.getDatefin())) {
			error("check the date choice");
			return "";

		}
		achat.setSkier(s);
		achat.setEquipement(E);
		System.out.println(achat);
		achat.setPrice((E.getPrice() / 10) * achat.getNumber());
		a.addEquipmentSkier(achat);

		s.setCredit(s.getCredit() - ((E.getPrice() / 10) * achat.getNumber()));

		skierEJB.updateSkier(s);

		Equipement h = equipementEJB.findEquipementById(E.getId());

		System.out.println(h);

		h.setShopquantity(h.getShopquantity() - achat.getNumber());

		equipementEJB.updateEquipement(h);

		info();

		return "";

	}

	public String addtobascket() {
		if (E.getShopquantity() == 0) {
			System.out.println("hahahahahahahaha");
			error("quantity unavailable");
			return "";
		}
		panierequipement.add(E);
		somme = somme + E.getPrice();
		return "";
	}

	public String achatpanier() {
		Skier s = null;
		try {
			s = skierEJB.findSkierByCardNumber(skier.getCardNumber());
		} catch (Exception e) {
			error("check you cardnumber");
			return "";
}
		if (s.getCredit() < somme) {
			error("insuffisant credit");
			panierequipement = new ArrayList<>();
			somme = 0;
			return "";
		}

		for (Equipement equipement : panierequipement) {
			achat = new EquipementSkier();
			achat.setSkier(s);
			achat.setEquipement(equipement);
			
			achat.setPrice(equipement.getPrice());
			Equipement h = equipementEJB.findEquipementById(equipement.getId());
			h.setShopquantity(h.getShopquantity()- 1);
			
			equipementEJB.updateEquipement(h);

			a.addEquipmentSkier(achat);

		}
		s.setCredit(s.getCredit() - somme);
		skierEJB.updateSkier(s);

		panierequipement = new ArrayList<>();
		somme = 0;

		info();
		return "";

	}
	public String deletefrompanier()
	{
		panierequipement.remove(E);
		somme= somme-E.getPrice();
		return "";
	}

}
