package cz.czechitas.bezobalu.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cz.czechitas.bezobalu.dao.JdbcDao;

public class ZobrazKController {

	private JdbcDao jdbcDao = new JdbcDao();
	
	public void zobrazKategorii(HttpServletRequest request, HttpServletResponse response) {
		int idKategorie=0;
		if (request == null || request.getParameter("idKategorie")==null) {
			idKategorie = 1;
		} else {
			idKategorie=Integer.parseInt(request.getParameter("idKategorie"));
		}
		
		//request.setAttribute("zobrazKategorii", jdbcDao.vratKategorii(idKategorie));
		
	}
	
	
}
