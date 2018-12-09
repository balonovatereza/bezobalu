package cz.czechitas.bezobalu.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sendgrid.Content;
import com.sendgrid.Email;
import com.sendgrid.Mail;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;

public class OdeslatController {

	public void handle(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("tento controller je OdeslatController");

		String novyEmail = "";

		if ((request == null) || (request.getParameter("email") == null)|| (request.getParameter("email").equals(""))) {
			novyEmail = "elichnovska@gmail.com";
		} else {
			novyEmail = request.getParameter("email");
		}

		String tabulka = "<html><body><ul>";
		//String tabulka = "";
		HttpSession session = request.getSession();
		ArrayList<String> seznamVypoctu = (ArrayList<String>) session.getAttribute("seznamVypoctu");

		if (seznamVypoctu != null) {
			for (String radek : seznamVypoctu) {
				tabulka =tabulka + "<li>"+ radek+ "</li>";
				//tabulka = tabulka+radek+"%n";
			}
		}
		tabulka=tabulka+"<ul></body></html>";
		

		Email from = new Email("bezobalu25@gmail.com");
		String subject = "Váš nákupní seznam do BezObalu";
		Email to = new Email(novyEmail);
		Content content = new Content("text/html", tabulka);
		Mail mail = new Mail(from, subject, to, content);

		SendGrid sg = new SendGrid("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");
		Request req = new Request();
		try {
			req.setMethod(Method.POST);
			req.setEndpoint("mail/send");
			req.setBody(mail.build());
			Response res = sg.api(req);
			System.out.println(res.getStatusCode());
			System.out.println(res.getBody());
			System.out.println(res.getHeaders());
		} catch (IOException ex) {
			System.out.print("adad");
		}
		
		seznamVypoctu.clear();

	}
}
