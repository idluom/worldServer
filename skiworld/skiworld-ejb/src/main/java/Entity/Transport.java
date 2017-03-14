package Entity;

import java.io.Serializable;
import java.lang.Float;
import java.lang.Integer;
import java.lang.Long;
import java.lang.String;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Transport
 *
 */
@Entity

public class Transport implements Serializable {

	@Id
	@GeneratedValue
	private Long idTransport;
	@Column(length = 255, nullable = false)
	private String departurePlace;
	@Column(length = 255, nullable = false)
	private String arrivalPlace;
	@Column(nullable = false)
	private Date departureDate;
	@Column(nullable = false)
	private Date arrivalDate;
	private Float price;
	private String type;
	private Integer numberPlaces;
	@ManyToMany
	private List<Trip> listTrip;
	private static final long serialVersionUID = 1L;

	public Transport() {
	}

	/**
	 * @param departurePlace
	 * @param arrivalPlace
	 * @param departureDate
	 * @param arrivalDate
	 * @param i
	 * @param type
	 * @param numberPlaces
	 */
	public Transport(String departurePlace, String arrivalPlace, Date departureDate, Date arrivalDate, Float price,
			String type, Integer numberPlaces) {
		this.departurePlace = departurePlace;
		this.arrivalPlace = arrivalPlace;
		this.departureDate = departureDate;
		this.arrivalDate = arrivalDate;
		this.price = price;
		this.type = type;
		this.numberPlaces = numberPlaces;
	}

	public List<Trip> getListTrip() {
		return listTrip;
	}

	public void setListTrip(List<Trip> listTrip) {
		this.listTrip = listTrip;
	}

	public Long getIdTransport() {
		return this.idTransport;
	}

	public void setIdTransport(Long idTransport) {
		this.idTransport = idTransport;
	}

	public String getDeparturePlace() {
		return this.departurePlace;
	}

	public void setDeparturePlace(String departurePlace) {
		this.departurePlace = departurePlace;
	}

	public String getArrivalPlace() {
		return this.arrivalPlace;
	}

	public void setArrivalPlace(String arrivalPlace) {
		this.arrivalPlace = arrivalPlace;
	}

	public Date getDepartureDate() {
		return this.departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	public Date getArrivalDate() {
		return this.arrivalDate;
	}

	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public Float getPrice() {
		return this.price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getNumberPlaces() {
		return this.numberPlaces;
	}

	public void setNumberPlaces(Integer numberPlaces) {
		this.numberPlaces = numberPlaces;
	}

	@Override
	public String toString() {
		return "Transport [departurePlace=" + departurePlace + ", arrivalPlace=" + arrivalPlace + ", departureDate="
				+ departureDate + ", arrivalDate=" + arrivalDate + ", price=" + price + ", type=" + type
				+ ", numberPlaces=" + numberPlaces + "]";
	}

}
