package cz.czechitas.bezobalu.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OdeslatController {
	public void handle(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("tento controller je OdeslatController");
		
		//request.setAttribute("empList", fileDao.load());
	}
}
