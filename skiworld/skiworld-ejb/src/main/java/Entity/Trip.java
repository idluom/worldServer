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
	private byte[] picture;
	@ManyToMany
	private List<Skier> skier; 
	@ManyToMany(mappedBy="listTrip")
	private List<Transport> listTransport;
	private static final long serialVersionUID = 1L;
	public Trip(){}
	
	



	public Trip(Integer id, String description, float price, int number, Date date, String video, byte[] picture,
			List<Skier> skier, List<Transport> listTransport) {
		super();
		this.id = id;
		this.description = description;
		this.price = price;
		this.number = number;
		this.date = date;
		this.video = video;
		this.picture = picture;
		this.skier = skier;
		this.listTransport = listTransport;
	}


	public Trip(String description, float price, int number, Date date) {
		this.description = description;
		this.price = price;
		this.number = number;
		this.date = date;	
		}





	public List<Transport> getListTransport() {
		return listTransport;
	}


	public void setListTransport(List<Transport> listTransport) {
		this.listTransport = listTransport;
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





	public byte[] getPicture() {
		return picture;
	}





	public void setPicture(byte[] picture) {
		this.picture = picture;
	}


	
	

}
