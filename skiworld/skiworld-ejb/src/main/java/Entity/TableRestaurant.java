package Entity;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.Long;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: TableRestaurant
 *
 */
@Entity

public class TableRestaurant implements Serializable {

	@Id
	@GeneratedValue
	private Long idTable;
	private Integer seattingCapacity;
	private Integer tableNumber;
	@ManyToOne
	private Restaurant restaurant;
	private static final long serialVersionUID = 1L;

	public TableRestaurant() {
	}   
	public Long getIdTable() {
		return this.idTable;
	}

	public void setIdTable(Long idTable) {
		this.idTable = idTable;
	}   
	public Integer getSeattingCapacity() {
		return this.seattingCapacity;
	}

	public void setSeattingCapacity(Integer seattingCapacity) {
		this.seattingCapacity = seattingCapacity;
	}   
	public Integer getTableNumber() {
		return this.tableNumber;
	}

	public void setTableNumber(Integer tableNumber) {
		this.tableNumber = tableNumber;
	}
	/**
	 * @param seattingCapacity
	 * @param tableNumber
	 * @param restaurant
	 */
	public TableRestaurant(Integer seattingCapacity, Integer tableNumber, Restaurant restaurant) {
		super();
		this.seattingCapacity = seattingCapacity;
		this.tableNumber = tableNumber;
		this.restaurant = restaurant;
	}
   
}
