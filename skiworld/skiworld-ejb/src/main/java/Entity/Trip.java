package Entity;

import java.io.Serializable;
import java.util.Date;


import javax.persistence.*;


@Entity
public class Trip implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Integer id ;
	String description;
	float price;
	int number;
	Date date;
	
	private static final long serialVersionUID = 1L;
	public Trip(){}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Trip [id=" + id + ", description=" + description + ", price=" + price + ", number=" + number + ", date="
				+ date + "]";
	}
	
	

}
