package Entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Training implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private long idTraining;
	private Date begeningDate;
	private Date endDate;
	private int number;
	private Float price;
	private String level;
	public long getIdTraining() {
		return idTraining;
	}
	public void setIdTraining(long idTraining) {
		this.idTraining = idTraining;
	}
	public Date getBegeningDate() {
		return begeningDate;
	}
	public void setBegeningDate(Date begeningDate) {
		this.begeningDate = begeningDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public Training() {
		super();
	}
	@Override
	public String toString() {
		return "Training [idTraining=" + idTraining + ", begeningDate=" + begeningDate + ", endDate=" + endDate
				+ ", number=" + number + ", price=" + price + ", level=" + level + "]";
	}
	
	
	
	
}
