package cz.czechitas.bezobalu.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FiltrKController {

	
	public void handle(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("tento controller je FiltrKController");
		
		//request.setAttribute("empList", fileDao.load());
	}
	
}
