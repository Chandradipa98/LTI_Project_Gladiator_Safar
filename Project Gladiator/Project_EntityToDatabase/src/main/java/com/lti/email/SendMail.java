package com.lti.email;

import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {
	public String send;
	public String subject;
	public String mssg;
	
	public void sendEmail() {
		// Recipient's email ID needs to be mentioned.
	    String to = send;

	    // Sender's email ID needs to be mentioned
	    String from = "nagchandradipa@gmail.com";

	    // Assuming you are sending email from through gmails smtp
	    String host = "smtp.gmail.com";

	    // Get system properties
	    Properties properties = System.getProperties();
	   
	    // Setup mail server
	    properties.put("mail.smtp.host",host);
	    properties.put("mail.smtp.port","465");
	    properties.put("mail.smtp.ssl.enable","true");
	    properties.put("mail.smtp.auth","true");

	    // Get the Session object.// and pass username and password
	    Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

	        protected PasswordAuthentication getPasswordAuthentication() {

	            return new PasswordAuthentication("nagchandradipa@gmail.com", "mani2198");

	        }

	    });

	    // Used to debug SMTP issues
	    session.setDebug(true);

	    try {
	        // Create a default MimeMessage object.
	        MimeMessage message = new MimeMessage(session);

	        // Set From: header field of the header.
	        message.setFrom(new InternetAddress(from));

	        // Set To: header field of the header.
	        message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

	        // Set Subject: header field
	        message.setSubject(subject);

	        // Now set the actual message
	        message.setText(mssg);

	        System.out.println("sending...");
	        // Send message
	        Transport.send(message);
	        System.out.println("Sent message successfully....");
	    } catch (MessagingException mex) {
	        mex.printStackTrace();
	    }
	}
	
	public char[] createOtp() {
		
        String numbers = "0123456789"; 
        Random rndm_method = new Random(); 
  
        char[] otp = new char[6]; 
  
        for (int i = 0; i < 6; i++) 
        { 
            otp[i] = 
             numbers.charAt(rndm_method.nextInt(numbers.length())); 
        } 
        return otp; 
	}

}
