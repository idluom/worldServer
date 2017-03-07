package Entity;


import java.io.Serializable;
import java.util.List;
import javax.persistence.OneToMany;
import javax.persistence.*;

@Entity
public class Admin extends Member implements Serializable{
	
	private static final long serialVersionUID = 1L;
	public Admin() {
		super();
	}
}
