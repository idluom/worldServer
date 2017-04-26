package Beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import Entity.Track;
import Entity.Trip;
import Service.TripEJBRemote;

@ManagedBean
@ApplicationScoped
public class TripBean implements Serializable {
	public TripBean() {
		super();
	}
	private List<Trip> fr;
	private List<Trip> lt;
	@EJB
	private TripEJBRemote tripEJB;
	@PostConstruct
	public void init()
	{		
		
	fr= tripEJB.DisplayAll();
	
	}
	public List<Trip> getLt() {
		return lt;
	}
	public void setLt(List<Trip> lt) {
		this.lt = lt;
	}
	private String ab ;
	public String getAb() {
		return ab;
	}
	public void setAb(String ab) {
		this.ab = ab;
	}
	
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	
 	  private int currentItem = 0;

 	  
 	  
	
	
public String getDescription()
{
	return lt.get(currentItem).getDescription();
}
	
public int getId()
{
	return lt.get(currentItem).getId();
}
public List<Trip> getFr() {
	return fr;
}
public void setFr(List<Trip> fr) {
	this.fr = fr;
}	

	


	

}
