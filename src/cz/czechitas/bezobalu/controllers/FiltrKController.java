package cz.czechitas.bezobalu.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cz.czechitas.bezobalu.bean.Kategorie;
import cz.czechitas.bezobalu.dao.JdbcDao;

public class FiltrKController {

	private JdbcDao jdbcDao = new JdbcDao();
	
	public void handle(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("tento controller je FiltrKController");
		
		int idMesta =  Integer.parseInt(request.getParameter("idMesta"));
		
		
		ArrayList<Kategorie> vyfiltrovaneKategorie = new ArrayList<Kategorie>();
		
		for (Kategorie kategorie:  vyfiltrovaneKategorie) {
			System.out.println(kategorie.getId() + kategorie.getNazev());
		}
		
		request.setAttribute("vyfiltrovaneKategorie", jdbcDao.vyfiltrujKategorie(idMesta));
	}
	
}
