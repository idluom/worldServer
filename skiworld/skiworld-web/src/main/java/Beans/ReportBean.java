package Beans;

import java.io.Serializable;
import java.util.Date;
import java.util.Properties;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import Entity.Report;
import Service.ReportEJB;

@ManagedBean
@RequestScoped
public class ReportBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private ReportEJB reportEjb = new ReportEJB();

	private Report report = new Report();
	private String passwd;

	public Report getReport() {
		return report;
	}

	public void setReport(Report report) {
		this.report = report;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public void envoyer() {
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(report.getSenderMail(), passwd);
			}
		});
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(report.getSenderMail()));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("mahmoud.bouden@esprit.tn"));
			message.setSubject(report.getMailObject());
			message.setText(report.getMailBody());
			report.setDateReport(new Date());
			reportEjb.sendReport(report);
			Transport.send(message);

		} catch (MessagingException e) {}
	}
}
