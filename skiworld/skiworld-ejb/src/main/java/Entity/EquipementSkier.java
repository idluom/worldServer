package Entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: EquipementSkier
 *
 */
@Entity

public class EquipementSkier implements Serializable {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	private Date datefin ;
	private Date datedebut ;
	private Float price ;
	private Integer number ;
	private static final long serialVersionUID = 1L;
	@ManyToOne
	private Equipement Equipement;
	@ManyToOne
	private Skier skier;
	
	public EquipementSkier() {
		
	}

	


	public Equipement getEquipement() {
		return Equipement;
	}

	public void setEquipement(Equipement equipement) {
		
		Equipement = equipement;
	}

	public Skier getSkier() {
		return skier;
	}

	public void setSkier(Skier skier) {
		
		this.skier = skier;
	}

	public Date getDatefin() {
		return datefin;
	}

	public void setDatefin(Date datefin) {
		this.datefin = datefin;
	}

	public Date getDatedebut() {
		return datedebut;
	}

	public void setDatedebut(Date datedebut) {
		this.datedebut = datedebut;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}




	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}




	@Override
	public String toString() {
		return "EquipementSkier [id=" + id + ", datefin=" + datefin + ", datedebut=" + datedebut + ", price=" + price
				+ ", number=" + number + ", Equipement=" + Equipement + ", skier=" + skier + "]";
	}
	
	
	
	
	
   
}
