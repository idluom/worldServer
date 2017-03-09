package Entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Comment implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idComment;
	private String userAlias;
	private String comment;
	private Date dateComment;
	
	private static final long serialVersionUID = 1L;
	
	public Comment() {
		
	}
	
	public Long getIdComment() {
		return idComment;
	}
	
	public void setIdComment(Long idComment) {
		this.idComment = idComment;
	}
	
	public String getUserAlias() {
		return userAlias;
	}
	
	public void setUserAlias(String userAlias) {
		this.userAlias = userAlias;
	}
	
	public String getComment() {
		return comment;
	}
	
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public void setDateComment(Date dateComment) {
		this.dateComment = dateComment;
	}
	
	public Date getDateComment() {
		return dateComment;
	}
}
