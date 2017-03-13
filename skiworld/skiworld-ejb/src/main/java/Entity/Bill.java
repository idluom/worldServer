package Entity;

import java.io.Serializable;
import java.lang.Float;
import java.lang.Long;
import java.lang.String;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Bill
 *
 */
@Entity

public class Bill implements Serializable {

	   
	@Id
	@GeneratedValue
	private Long id;
	private Float Cost;
	private String equipementName;
	private Date date ;
	private static final long serialVersionUID = 1L;

	public Bill() {
		super();
	}   
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}   
	public Float getCost() {
		return this.Cost;
	}

	public void setCost(Float Cost) {
		this.Cost = Cost;
	}   
	public String getEquipementName() {
		return this.equipementName;
	}

	public void setEquipementName(String equipementName) {
		this.equipementName = equipementName;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Bill [Cost=" + Cost + ", equipementName=" + equipementName + ", date=" + date + "]";
	}
	
	
	
   
}
