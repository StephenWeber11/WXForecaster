/*
 * Code from Chapter 14 of textbook
 */
package Util;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

/**
 *
 * @author Stephen
 */
public class MailUtil {
    
    public static void sendMail(String toAddr, String fromAddr, String subject,
            String body, boolean bodyIsHTML) throws MessagingException{
        
        Properties props = new Properties();
        props.put("mail.transport.protocol","smtps");
        props.put("mail.smtps.host","smtp.gmail.com");
        props.put("mail.smtps.port",465);
        props.put("mail.smtps.auth","true");
        props.put("mail.smtps.quitwait","false");
        Session session = Session.getDefaultInstance(props);
        
        //Create the message
        Message message = new MimeMessage(session);
        message.setSubject(subject);
        if(bodyIsHTML){
            message.setContent(body,"text/html");
        }else{
            message.setText(body);
        }
        
        //Address the message
        Address fromAddress = new InternetAddress(fromAddr);
        Address toAddress = new InternetAddress(toAddr);
        message.setFrom(fromAddress);
        message.setRecipient(Message.RecipientType.TO,toAddress);
        
        //Send the message
        Transport transport = session.getTransport();
        transport.connect("sweber19@uncc.edu","UAlbany-14");
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
        
    }
}
