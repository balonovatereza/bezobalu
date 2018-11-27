package cz.czechitas.bezobalu.controllers;

import java.util.Properties;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OdeslatController {
	public void handle(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("tento controller je OdeslatController");
		  /* 
			      // Recipient's email ID needs to be mentioned.
			      String to = "elichnovska@gmail.com";

			      // Sender's email ID needs to be mentioned
			      String from = "bezobalu25@gmail.com";

			      // Assuming you are sending email from localhost
			      String host = "localhost";

			      // Get system properties
			      Properties properties = System.getProperties();

			      // Setup mail server
			      properties.setProperty("smtp.google.com", host);

			      // Get the default Session object.
			      Session session = Session.getDefaultInstance(properties);

			      try {
			         // Create a default MimeMessage object.
			         MimeMessage message = new MimeMessage(session);
			         // Set From: header field of the header.
			         message.setFrom(new InternetAddress(from));
			         // Set To: header field of the header.
			         message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			         // Set Subject: header field
			         message.setSubject("This is the Subject Line!");
			         // Now set the actual message
			         message.setText("This is actual message");
			         // Send message
			         Transport.send(message);
			         System.out.println("Sent message successfully....");
			      } catch (MessagingException mex) {
			         mex.printStackTrace();
			      }*/
			   }
			}


