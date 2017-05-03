package Beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import Entity.Events;
import Entity.Skier;
import Service.EventEJB;
import Service.SkierEJB;

@ManagedBean
@ViewScoped
public class EventBean implements Serializable {
	private static final long serialVersionUID = 1L;
	@EJB
	private EventEJB eventServices;
	@EJB
	private SkierEJB skierEJB;
	private Events event;
	private Skier skier;
	private List<Events> listEvents;
	private boolean formDisplayed=false;
	private int nbr;

	public EventBean() {

	}
	@PostConstruct
	public void init() {
		listEvents = eventServices.findAllEvent();
		event=new Events();
		skier = new Skier();
	}
	public String showForm(){
		String navTo="";
		setFormDisplayed(true);
		return navTo;
	}
	
	public String checkSkier() {
		try {
			System.out.println(skier.getCardNumber());
			Skier s = skierEJB.findSkierByCardNumber(skier.getCardNumber());
			System.out.println(s);
			System.out.println("avant reservation");
			if (s.getCredit() > event.getPrice()) {
				System.out.println("pendat reservation");
				s.setCredit(s.getCredit() - event.getPrice());
				s.getListEvents().add(event);
				event.getListSkier().add(s);
				System.out.println("avant update");
				skierEJB.updateSkier(s);
				eventServices.updateEvent(event);
				System.out.println("after update");
				
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Success !", "Enjoy !"));
			} else {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Error !", "Please Check Your Credit Before Continuing !"));
			}
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error !", "Something Went Wrong !"));
			return "";
		}
		return "ListEvent";
	}

	public Events getEvent() {
		return event;
	}

	public void setEvent(Events event) {
		this.event = event;
	}

	public List<Events> getListEvents() {
		return listEvents;
	}

	public void setListEvents(List<Events> listEvents) {
		this.listEvents = listEvents;
	}

	public boolean isFormDisplayed() {
		return formDisplayed;
	}

	public void setFormDisplayed(boolean formDisplayed) {
		this.formDisplayed = formDisplayed;
	}

	public Skier getSkier() {
		return skier;
	}

	public void setSkier(Skier skier) {
		this.skier = skier;
	}
	public int getNbr() {
		return nbr;
	}
	public void setNbr(int nbr) {
		this.nbr = nbr;
	}

}
