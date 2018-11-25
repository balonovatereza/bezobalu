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

		int idMesta = 0;
		if (request != null) {
			if (request.getParameter("idMesta") == null) {
				idMesta = 1;
			} else {
				idMesta = Integer.parseInt(request.getParameter("idMesta"));
			}
			request.setAttribute("vyfiltrovaneKategorie", jdbcDao.vyfiltrujKategorie(idMesta));
		}

	}

}
