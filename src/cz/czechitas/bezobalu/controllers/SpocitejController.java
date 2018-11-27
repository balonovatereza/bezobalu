package cz.czechitas.bezobalu.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;

import cz.czechitas.bezobalu.dao.JdbcDao;

public class SpocitejController {

	private JdbcDao jdbcDao = new JdbcDao();
	int idProduktu = 0;
	int gramy = 0;
	float vypocet = 0;

	public void handle(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("tento controller je SpocitejController");

//osetruji oba vstupy, kdyby byly null
		if ((request == null) || (request.getParameter("idProduktu") == null)) {
			idProduktu = 1;
		} else {
			idProduktu = Integer.parseInt(request.getParameter("idProduktu"));
		}

		if ((request == null) || (request.getParameter("gramy") == null)) {
			gramy = 1;
		} else {
			gramy = Integer.parseInt(request.getParameter("gramy"));
		}

		vypocet = jdbcDao.najdiCenu(idProduktu) / 100 * gramy;
		request.setAttribute("vypocet", vypocet);
	}

	public ArrayList<String> vypis(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		ArrayList<String> seznamVypoctu = (ArrayList<String>) session.getAttribute("seznamVypoctu");
		if (seznamVypoctu == null) {
			seznamVypoctu = new ArrayList<String>();
		} 
		String radek = "";
		
		//osetruji oba vstupy, kdyby byly null
				if ((request == null) || (request.getParameter("idProduktu") == null)) {
					idProduktu = 1;
				} else {
					idProduktu = Integer.parseInt(request.getParameter("idProduktu"));
				}

				if ((request == null) || (request.getParameter("gramy") == null)) {
					gramy = 1;
				} else {
					gramy = Integer.parseInt(request.getParameter("gramy"));
				}
				
		radek = idProduktu + " " + gramy + " " + vypocet;
		seznamVypoctu.add(radek);
		session.setAttribute("seznamVypoctu", seznamVypoctu);
		return seznamVypoctu;
	}
}
