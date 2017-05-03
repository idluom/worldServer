package Beans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import Entity.Hotel;
import Service.HotelEJB;

@ManagedBean
@ViewScoped
public class HotelBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Hotel hotel;
	@EJB
	private HotelEJB hotelEJB;
	public HotelBean() {
	
	}
	@PostConstruct
	public void init(){
		Long l= new Long(1);
		setHotel(hotelEJB.findHotelById(l));
	
	}
	public Hotel getHotel() {
		return hotel;
	}
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

}
