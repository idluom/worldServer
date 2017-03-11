package Entity;

import java.util.Properties;
import javax.mail.*;
import javax.mail.Transport;
import javax.mail.internet.*;

public class Mail {
    private static String USER_NAME ;  // GMail user name (just the part before "@gmail.com")
    private static String PASSWORD ; // GMail password
    private static String RECIPIENT;
    private static String ssubject;
    private static String bbody;

    public static String getUSER_NAME() {
        return USER_NAME;
    }

    public static void setUSER_NAME(String USER_NAME) {
        Mail.USER_NAME = USER_NAME;
    }

    public static String getPASSWORD() {
        return PASSWORD;
    }

    public static void setPASSWORD(String PASSWORD) {
        Mail.PASSWORD = PASSWORD;
    }

    public static String getRECIPIENT() {
        return RECIPIENT;
    }

    public static void setRECIPIENT(String RECIPIENT) {
        Mail.RECIPIENT = RECIPIENT;
    }

    public static String getSsubject() {
        return ssubject;
    }

    public static void setSsubject(String ssubject) {
        Mail.ssubject = ssubject;
    }

    public static String getBbody() {
        return bbody;
    }

    public static void setBbody(String bbody) {
        Mail.bbody = bbody;
    }
    

    public static void sendFromGMaill(String from, String pass, String[] to, String subject, String body) {
        Properties props = System.getProperties();
        String host = "smtp.gmail.com";
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
       // props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", from);
        props.put("mail.smtp.password", pass);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(from));
            InternetAddress[] toAddress = new InternetAddress[to.length];

            // To get the array of addresses
            for (int i = 0; i < to.length; i++) {
                toAddress[i] = new InternetAddress(to[i]);
            }

            for (InternetAddress toAddres : toAddress) {
                message.addRecipient(Message.RecipientType.TO, toAddres);
            }

            message.setSubject(subject);
            message.setText(body);
            Transport transport = (Transport) session.getTransport("smtp");
            ((Transport) transport).connect(host, from, pass);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        } catch (AddressException ae) {
        } catch (MessagingException me) {
        }
    }
}