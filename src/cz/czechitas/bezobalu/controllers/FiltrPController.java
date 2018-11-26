package cz.czechitas.bezobalu.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cz.czechitas.bezobalu.bean.Kategorie;
import cz.czechitas.bezobalu.dao.JdbcDao;

public class FiltrPController {

	private JdbcDao jdbcDao = new JdbcDao();

	public void handle(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("tento controller je FiltrPController");
		// mesto uz bylo osetreno v predchozim kontrolu FiltrK a pokud neni zadane, je jednicka, nemuze nastat null
		int idMesta = Integer.parseInt(request.getParameter("idMesta"));
		// kategorie je osetrena uz v predchozi kontroleru ZobrazK a pokud neni zadana, je jednicka nemuze nastat null
		int idKategorie = Integer.parseInt(request.getParameter("idKategorie"));

		request.setAttribute("vyfiltrovaneProdukty", jdbcDao.vyfiltrujProdukty(idMesta, idKategorie));
	}

}
