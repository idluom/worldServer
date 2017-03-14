package Entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;


@Entity
public class Trip implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id ;
	private String description;
	private float price;
	private int number;
	private Date date;
	private String video;
	@ManyToMany
	private List<Skier> skier; 
	private static final long serialVersionUID = 1L;
	public Trip(){}
	
	
	public Trip(String description, float price, int number, Date date) {
		super();
		this.description = description;
		this.price = price;
		this.number = number;
		this.date = date;
	}


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
	public String getVideo() {
		return video;
	}
	public void setVideo(String video) {
		this.video = video;
	}

	public List<Skier> getSkier() {
		return skier;
	}


	public void setSkier(List<Skier> skier) {
		this.skier = skier;
	}


	@Override
	public String toString() {
		return "Trip [id=" + id + ", description=" + description + ", price=" + price + ", number=" + number + ", date="
				+ date + "]";
	}
	
	

}
