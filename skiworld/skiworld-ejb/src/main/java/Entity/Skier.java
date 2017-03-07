package Entity;

import java.io.Serializable;
import java.lang.Float;
import java.lang.String;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Skier
 *
 */
@Entity

public class Skier implements Serializable {

	   
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long idSkier;
	private int pin;
	private Float credit;
	private String name;
	private String lastName;
	private String address;
	private Date birthday;
	private static final long serialVersionUID = 1L;
	
	@OneToMany(mappedBy="skier")
	private List<TrackSkier> listTrackSkier;
	
	@OneToMany(mappedBy="skier")
	private List<TraningSkier> listTrainingSkier;
	public Skier() {
		super();
	}   
	public long getIdSkier() {
		return this.idSkier;
	}

	public void setIdSkier(long idSkier) {
		this.idSkier = idSkier;
	}   
	public int getPin() {
		return this.pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}   
	public Float getCredit() {
		return this.credit;
	}

	public void setCredit(Float credit) {
		this.credit = credit;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}   
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}   
	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	@Override
	public String toString() {
		return "Skier [idSkier=" + idSkier + ", pin=" + pin + ", credit=" + credit + ", name=" + name + ", lastName="
				+ lastName + ", address=" + address + ", birthday=" + birthday + "]";
	}
	
	
   
}
