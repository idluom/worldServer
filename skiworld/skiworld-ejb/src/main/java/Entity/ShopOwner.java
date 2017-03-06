package Entity;


import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="shopowner")
@DiscriminatorValue(value="shopowner")
public class ShopOwner extends Member implements Serializable  {

	private static final long serialVersionUID = 1L;
}
