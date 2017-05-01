package Beans;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

import Entity.BookingSkierTable;
import Entity.Product;
import Entity.Skier;
import Service.BookingTableEJB;

@SessionScoped
@ManagedBean
public class BookingTableBean {
	@EJB
	private BookingTableEJB bookingTableEJB;
	private BookingSkierTable bookingSkierTable;
	private Skier skier;
	private Date dateNow ;
	
	@PostConstruct
	public void init() {
		setBookingSkierTable(new BookingSkierTable());
		setDateNow(new Date());
		
		}
	public void onDateSelect(SelectEvent event) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));
    }
     
    public void click() {
        RequestContext requestContext = RequestContext.getCurrentInstance();
         
        requestContext.update("form:display");
        requestContext.execute("PF('dlg').show()");
    }
	public BookingSkierTable getBookingSkierTable() {
		return bookingSkierTable;
	}
	
	public void setBookingSkierTable(BookingSkierTable bookingSkierTable) {
		this.bookingSkierTable = bookingSkierTable;
	}
	public Skier getSkier() {
		return skier;
	}
	public void setSkier(Skier skier) {
		this.skier = skier;
	}
	public Date getDateNow() {
		return dateNow;
	}
	public void setDateNow(Date dateNow) {
		this.dateNow = dateNow;
	}
	
	
}
