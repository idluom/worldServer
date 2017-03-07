package Entity;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Restaurant
 *
 */
@Entity

public class Restaurant implements Serializable {

	   
	@Id
	@GeneratedValue
	private Long idRestaurant;
	private String nameRestaurant;
	@OneToMany (mappedBy="restaurant")
	private List <TableRestaurant> tableRestaurant;
	private static final long serialVersionUID = 1L;

	public Restaurant() {
	}   
	
	/**
	 * @param nameRestaurant
	 */
	public Restaurant(String nameRestaurant) {
		this.nameRestaurant = nameRestaurant;
	}

	public Long getIdRestaurant() {
		return this.idRestaurant;
	}

	public void setIdRestaurant(Long idRestaurant) {
		this.idRestaurant = idRestaurant;
	}   
	public String getNameRestaurant() {
		return this.nameRestaurant;
	}

	public void setNameRestaurant(String nameRestaurant) {
		this.nameRestaurant = nameRestaurant;
	}

	@Override
	public String toString() {
		return "Restaurant [nameRestaurant=" + nameRestaurant + "]";
	}
   
}
