import java.util.*;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.*;  
import javax.activation.*;  
  
public class SendEmail  
{  
 public static void main(String [] args){  
      String to = "idipeshr@gmail.com";//change accordingly  
      String from = "idipeshr@gmail.com"; 
     
      
      
     //Get the session object  
      Properties properties = System.getProperties();  
              
     // properties.setProperty("mail.smtp.port", "9090");
      properties.put("mail.smtp.starttls.enable", "true"); 
      properties.put("mail.smtp.host", "smtp.gmail.com");
      properties.put("mail.smtp.user", "idipeshr@gmail.com"); // User name
      properties.put("mail.smtp.password", "Swordfi3*"); // password
      properties.put("mail.smtp.port", "587");
      properties.put("mail.smtp.auth", "true");
      Session session = Session.getDefaultInstance(properties); 
         		    new Authenticator() {
    		        protected PasswordAuthentication  getPasswordAuthentication() {
    		        return new PasswordAuthentication(
    		                    "idipeshr@gmail.com", "Swordfi3*");
    		               }};
    		    
 
 
     //compose the message  
      try{  
         MimeMessage message = new MimeMessage(session);  
         message.setFrom(new InternetAddress(from));  
         message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
         message.setSubject("Ping - Jenkins Job");  
         message.setText("Hello, Jenkins Test  ");  
  
         // Send message  
         Transport.send(message);  
         System.out.println("message sent successfully....");  
  
      }catch (MessagingException mex) {mex.printStackTrace();}  
   }  
} 