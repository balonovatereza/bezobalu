package cz.czechitas.bezobalu.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cz.czechitas.bezobalu.dao.JdbcDao;

public class FiltrPController {
	
	private JdbcDao jdbcDao = new JdbcDao();

	public void handle(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("tento controller je FiltrPController");
		
		int idMesta =  Integer.parseInt(request.getParameter("idMesta"));
		int idKategorie =  Integer.parseInt(request.getParameter("idKategorie"));
		
		request.setAttribute("vyfiltrovaneProdukty", jdbcDao.vyfiltrujProdukty(idMesta,idKategorie));
	}
}
