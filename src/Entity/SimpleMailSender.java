
package Entity;

/**
 *
 * @author Vatsala
 */
import java.security.Security;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SimpleMailSender {

    private static final String SmtpServer = "smtp.gmail.com";
//    private static String MsgContent;
//    private static String Subject;
//    private static String mailFrom;
//
//    private static String[] sendTo;

//    public static void main(String args[]) throws Exception {
//
//        Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
//        new SimpleMailSender().sendSSLMessage(sendTo, Subject, MsgContent, mailFrom);
//        System.out.println("Sucessfully Sent");
//    }

    public void sendSSLMessage(String recipients[], String subject, String message, String from) throws MessagingException {
        boolean debug = true;
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", SmtpServer);
        props.put("mail.smtp.port", "587");
        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("prognoz.superiors@gmail.com", "sup123456");
            }
        });

//        session.setDebug(debug);
        Message msg = new MimeMessage(session);
        InternetAddress addressFrom = new InternetAddress(from);
        msg.setFrom(addressFrom);
        InternetAddress[] addressTo = new InternetAddress[recipients.length];
        for (int i = 0; i < recipients.length; i++) {
            addressTo[i] = new InternetAddress(recipients[i]);
        }
        msg.setRecipients(Message.RecipientType.TO, addressTo);
        // Setting the Subject and Content Type
        msg.setSubject(subject);
        msg.setContent(message, "text/plain");
        Transport.send(msg);
    }
}
