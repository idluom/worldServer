package Entity;

import java.io.Serializable;
import java.lang.Float;
import java.lang.Long;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Discount
 *
 */
@Entity

public class Discount implements Serializable {

	@Id
	@GeneratedValue
	private Long id;
	private Float percentage;
	private Date beginning ;
	private Date end ;
	
	private static final long serialVersionUID = 1L;
	@OneToMany(mappedBy="discount")
	private List<Equipement> listEquipements;
	
	

	
	public Discount(Float percentage, Date beginning, Date end, List<Equipement> listEquipements) {
		super();
		this.percentage = percentage;
		this.beginning = beginning;
		this.end = end;
		this.listEquipements = listEquipements;
	}
	public Discount() {
		super();
	}   
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}   
	public Float getPercentage() {
		return this.percentage;
	}

	public void setPercentage(Float percentage) {
		this.percentage = percentage;
	}
	
	
	
	public List<Equipement> getListEquipements() {
		return listEquipements;
	}
	public void setListEquipements(List<Equipement> listEquipements) {
		this.listEquipements = listEquipements;
	}
	
	
	public Date getBeginning() {
		return beginning;
	}
	public void setBeginning(Date beginning) {
		this.beginning = beginning;
	}
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
		this.end = end;
	}
	@Override
	public String toString() {
		return "Discount [percentage=" + percentage + "]";
	}
	
	
   
}
