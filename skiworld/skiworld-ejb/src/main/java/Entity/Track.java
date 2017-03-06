package Entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Track")
public class Track implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long idTrack;
	@Column(name="length")
	private float length;
	@Column(name="difficulty")
	private String difficulty;
	@Column(name="price")
	private float price;
	@ManyToOne
	private Admin admin;
	
	@ManyToMany
	private List<Skier> listSkier;
	
	public Track(){
		
	}

	public long getIdTrack() {
		return idTrack;
	}

	public void setIdTrack(long idTrack) {
		this.idTrack = idTrack;
	}

	public float getLength() {
		return length;
	}

	public void setLength(float length) {
		this.length = length;
	}

	public String getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Track [idTrack=" + idTrack + ", length=" + length + ", difficulty=" + difficulty + ", price=" + price
				+ "]";
	}
	
	
	
}
