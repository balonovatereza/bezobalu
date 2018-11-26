package cz.czechitas.bezobalu.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cz.czechitas.bezobalu.dao.JdbcDao;

public class ZobrazPController {
	
	private JdbcDao jdbcDao = new JdbcDao();
	
	public void zobrazProdukt(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("tento controller je ZobrazPController");
		int idProduktu=Integer.parseInt(request.getParameter("idKategorie"));
		
		if (request != null) {
			if (request.getParameter("idProduktu") == null) {
				idProduktu = 1;
			} else {
				idProduktu = Integer.parseInt(request.getParameter("idKategorie"));
			}
			request.setAttribute("vyfiltrovaneKategorie", jdbcDao.vyfiltrujKategorie(idProduktu));
		}
		
		request.setAttribute("zobrazProdukt", jdbcDao.vratProdukt(idProduktu));
		
	}

}
