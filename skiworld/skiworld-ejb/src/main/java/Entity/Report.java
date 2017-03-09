package Entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Report implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idReport;
	private String senderMail;
	private String mailObject;
	private String mailBody;
	private Date dateReport;
	
	private static final long serialVersionUID = 1L;
	
	public Report() {
		// TODO Auto-generated constructor stub
	}

	public Long getIdReport() {
		return idReport;
	}

	public void setIdReport(Long idReport) {
		this.idReport = idReport;
	}

	public String getSenderMail() {
		return senderMail;
	}

	public void setSenderMail(String senderMail) {
		this.senderMail = senderMail;
	}

	public String getMailObject() {
		return mailObject;
	}

	public void setMailObject(String mailObject) {
		this.mailObject = mailObject;
	}

	public String getMailBody() {
		return mailBody;
	}

	public void setMailBody(String mailBody) {
		this.mailBody = mailBody;
	}
	
	public void setDateReport(Date dateReport) {
		this.dateReport = dateReport;
	}
	
	public Date getDateReport() {
		return dateReport;
	}
	
}
