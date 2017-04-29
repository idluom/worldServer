package Beans;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import Entity.Newsletter;
import Service.NewsletterEJB;

@ManagedBean
@ViewScoped
public class NewsletterBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private NewsletterEJB newsEJB = new NewsletterEJB();
	private Newsletter newsletter = new Newsletter();
	public static Newsletter mail = new Newsletter();
	
	public Newsletter getNewsletter() {
		return newsletter;
	}
	
	public void setNewsletter(Newsletter newsletter) {
		mail = newsletter;
		this.newsletter = newsletter;
	}
	
	public String addUserToList() {
		newsEJB.addUserToList(newsletter);
		return "";
	}
}
