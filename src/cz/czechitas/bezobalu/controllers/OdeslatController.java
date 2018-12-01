package cz.czechitas.bezobalu.controllers;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OdeslatController {
	
	public void handle(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("tento controller je OdeslatController");
		Properties props = new Properties();
		
		final String username = "bezobalu25@gmail.com";
        final String password = "Tankt3434";

        
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.imaps.ssl.trust", "*");
        props.put("mail.debug", "true");

        Session session = Session.getInstance(props,
          new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
          });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("bezobalu25@gmail.com"));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress("elichnovska@gmail.com"));
            message.setSubject("A testing mail header !!!");
            message.setText("Dear Mail Crawler");

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

	}
}
