package Entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
/**
 * Entity implementation class for Entity: DayMenu
 *
 */
@Entity

public class DayMenu implements Serializable {
	@Id
	@GeneratedValue
	private Long idDayMenu ;
	private Date dayMenuDate;
	@OneToMany (mappedBy="menu")
	private List <Product> dayMenuList;
	private static final long serialVersionUID = 1L;

	public DayMenu() {
		super();
	}

	public Date getDayMenuDate() {
		return dayMenuDate;
	}

	public void setDayMenuDate(Date dayMenuDate) {
		this.dayMenuDate = dayMenuDate;
	}

	public List<Product> getDayMenuList() {
		return dayMenuList;
	}

	public void setDayMenuList(List<Product> dayMenuList) {
		this.dayMenuList = dayMenuList;
	}

	@Override
	public String toString() {
		return "DayMenu [dayMenuDate=" + dayMenuDate + ", dayMenuList=" + dayMenuList + "]";
	}

	
   
}
