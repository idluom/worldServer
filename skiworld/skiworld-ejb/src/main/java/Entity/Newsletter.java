package Entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Newsletter implements Serializable {
	
	@Id
	@GeneratedValue
	private long id;
	private String userMail;
	private static final long serialVersionUID = 1L;
	
	public Newsletter() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserMail() {
		return userMail;
	}

	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}
	
}
