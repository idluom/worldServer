package Entity;

import java.io.Serializable;




import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class Track implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long idTrack;
	
	private float length;
	
	private String difficulty;
	
	private float price;
	
	private String title;
	private String description;
	private byte[] image;
	
	
	
	
//	@OneToMany(mappedBy="track")
//	private List<TrackSkier> listTrackSkier;

	public Track(){
		
	}

	public Track(long id,String difficulty, float length, float price,byte[] image) {
		this.idTrack=id;
		this.difficulty=difficulty;
		this.length=length;
		this.price=price;
		this.image=image;
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

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public void setIdTrack(long idTrack) {
		this.idTrack = idTrack;
	}
	
	
	
}
