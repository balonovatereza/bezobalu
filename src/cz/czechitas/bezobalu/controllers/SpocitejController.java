package cz.czechitas.bezobalu.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cz.czechitas.bezobalu.dao.JdbcDao;

public class SpocitejController {

	private JdbcDao jdbcDao = new JdbcDao();
	int idProduktu = 0;
	int gramy = 0;
	float vypocet = 0;

	public void handle(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("tento controller je SpocitejController");

		idProduktu = Integer.parseInt(request.getParameter("idProduktu"));
		gramy = Integer.parseInt(request.getParameter("gramy"));

		vypocet = jdbcDao.najdiCenu(idProduktu) / 100 * gramy;

		request.setAttribute("vypocet", vypocet);
	}

	public ArrayList<String> vypis(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<String> seznamVypoctu = new ArrayList<String>();
		String radek = "";
		idProduktu = Integer.parseInt(request.getParameter("idProduktu"));
		gramy = Integer.parseInt(request.getParameter("gramy"));
		radek = idProduktu+" "+gramy+" "+vypocet;
		seznamVypoctu.add(radek);
		return seznamVypoctu;
	}
	// request.setAttribute("empList", fileDao.load());
}
