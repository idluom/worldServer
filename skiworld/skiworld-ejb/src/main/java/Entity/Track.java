package Entity;

import java.io.Serializable;



import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity

public class Track implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long idTrack;
	
	private float length;
	
	private String difficulty;
	
	private float price;
	
	private String title;
	private String description;
	@OneToMany(mappedBy="track")
	private List<TrackSkier> listTrackSkier;

	public Track(){
		
	}

	public Track(String difficulty, float length, float price) {
		this.difficulty=difficulty;
		this.length=length;
		this.price=price;
	}

	public long getIdTrack() {
		return idTrack;
	}

	public void setIdTrack(Long idTrack) {
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
