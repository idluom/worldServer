package Entity;


import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="admin")
@DiscriminatorValue(value="admin")
public class Admin extends Member implements Serializable{
	
	private static final long serialVersionUID = 1L;

}
