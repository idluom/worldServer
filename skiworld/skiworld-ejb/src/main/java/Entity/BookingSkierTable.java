package Entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class BookingSkierTable implements Serializable{
//	enum bookTime{
//		7:00
//	}
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue 
	private Long idBookingTable;
	@ManyToOne
	@JoinColumn(name="idTablePK",insertable=false,updatable=false)
	private TableRestaurant tableRestaurant;
	@ManyToOne
	@JoinColumn(name="idSkierPK",insertable=false,updatable=false)
	private Skier skier;
	
	private Date createdOn;
	private Date bookDate;
	private Date bookTime;
	private float bookPrice;
	private String cancellationCode;
	
	/**
	 * 
	 */
	public BookingSkierTable() {
		super();
	}
	
	public Long getIdBookingTable() {
		return idBookingTable;
	}

	public void setIdBookingTable(Long idBookingTable) {
		this.idBookingTable = idBookingTable;
	}

	public TableRestaurant getTableRestaurant() {
		return tableRestaurant;
	}
	public void setTableRestaurant(TableRestaurant tableRestaurant) {
		this.tableRestaurant = tableRestaurant;
	}
	public Skier getSkier() {
		return skier;
	}
	public void setSkier(Skier skier) {
		this.skier = skier;
	}
	public float getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(float bookPrice) {
		this.bookPrice = bookPrice;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	public String getCancellationCode() {
		return cancellationCode;
	}
	public void setCancellationCode(String cancellationCode) {
		this.cancellationCode = cancellationCode;
	}
	public Date getBookDate() {
		return bookDate;
	}
	public void setBookDate(Date bookDate) {
		this.bookDate = bookDate;
	}

	public Date getBookTime() {
		return bookTime;
	}

	public void setBookTime(Date bookTime) {
		this.bookTime = bookTime;
	}
	

}
