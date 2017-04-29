package Beans;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import Entity.Skier;
import Service.SkierEJB;

@ManagedBean
@RequestScoped
public class SkierBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Skier skier = new Skier();
	@EJB
	private SkierEJB skierEJB = new SkierEJB();

	public Skier getSkier() {
		return skier;
	}

	public void setSkier(Skier skier) {
		this.skier = skier;
	}

	public Skier checkSkier() {
		Skier s = null;
		try  {
			s = skierEJB.findSkierByCardNumber(skier.getCardNumber());
		} catch (Exception e) {
		}
		return s;
	}
}
