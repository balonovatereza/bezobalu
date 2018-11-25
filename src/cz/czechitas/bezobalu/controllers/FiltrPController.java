package cz.czechitas.bezobalu.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FiltrPController {

	public void handle(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("tento controller je FiltrPController");
		
		//request.setAttribute("empList", fileDao.load());
	}
}
