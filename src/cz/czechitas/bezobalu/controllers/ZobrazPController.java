package cz.czechitas.bezobalu.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cz.czechitas.bezobalu.dao.JdbcDao;

public class ZobrazPController {
	
	private JdbcDao jdbcDao = new JdbcDao();
	
	public void zobrazProdukt(HttpServletRequest request, HttpServletResponse response) {
		int idProduktu=Integer.parseInt(request.getParameter("idKategorie"));
		
		//request.setAttribute("zobrazProdukt", jdbcDao.vratProdukt(idProduktu));
		
	}

}
