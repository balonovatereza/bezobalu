package cz.czechitas.bezobalu.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cz.czechitas.bezobalu.bean.Kategorie;
import cz.czechitas.bezobalu.dao.JdbcDao;

public class FiltrPController {

	private JdbcDao jdbcDao = new JdbcDao();

	public void handle(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("tento controller je FiltrPController");
		int idMesta=0;
		int idKategorie=0;
		
		if ((request == null) || (request.getParameter("idMesta") == null)) {
			idMesta = 1;
		} else {
			idMesta = Integer.parseInt(request.getParameter("idMesta"));
		}
		
		if ((request == null) || (request.getParameter("idKategorie") == null)) {
			idKategorie = 1;
		} else {
			idKategorie = Integer.parseInt(request.getParameter("idKategorie"));
		}
		
		request.setAttribute("vyfiltrovaneProdukty", jdbcDao.vyfiltrujProdukty(idMesta, idKategorie));
	}

}
