package Entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="restaurantowner")
@DiscriminatorValue(value="restaurantowner")
public class RestaurantOwner extends Member implements Serializable{

	private static final long serialVersionUID = 1L;
}
