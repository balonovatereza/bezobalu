package cz.czechitas.bezobalu.controllers;

import java.math.BigDecimal;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;

import cz.czechitas.bezobalu.bean.Produkt;
import cz.czechitas.bezobalu.dao.JdbcDao;

public class SpocitejController {
	
	public static BigDecimal round(float d, int decimalPlace) {
	    BigDecimal bd = new BigDecimal(Float.toString(d));
	    bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);       
	    return bd;
	}

	private JdbcDao jdbcDao = new JdbcDao();
	int idProduktu = 0;
	int gramy = 0;
	float vypocetF = 0;
	BigDecimal vypocet;

	public void handle(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("tento controller je SpocitejController");

//osetruji oba vstupy, kdyby byly null
		if ((request == null) || (request.getParameter("idProduktu") == null)) {
			idProduktu = 1;
		} else {
			idProduktu = Integer.parseInt(request.getParameter("idProduktu"));
		}

		if ((request == null) || (request.getParameter("gramy") == null)|| (request.getParameter("gramy").equals(""))) {
			gramy = 1;
		} else {
			gramy = Integer.parseInt(request.getParameter("gramy"));
		}

		vypocetF = jdbcDao.najdiCenu(idProduktu) / 100 * gramy;
		vypocet= round(vypocetF,2);
		request.setAttribute("vypocet", vypocet);
	}

		public ArrayList<String> vypis(HttpServletRequest request, HttpServletResponse response) {
	
			HttpSession session = request.getSession();
			ArrayList<String> seznamVypoctu = (ArrayList<String>) session.getAttribute("seznamVypoctu");
			if (seznamVypoctu == null) {
				seznamVypoctu = new ArrayList<String>();
			}
			String radek = "";
	
			// osetruji oba vstupy, kdyby byly null
			if ((request == null) || (request.getParameter("idProduktu") == null)) {
				idProduktu = 1;
			} else {
				idProduktu = Integer.parseInt(request.getParameter("idProduktu"));
			}
	
			if ((request == null) || (request.getParameter("gramy") == null) || (request.getParameter("gramy").equals(""))) {
				gramy = 1;
			} else {
				gramy = Integer.parseInt(request.getParameter("gramy"));
			}
			Produkt produkt = new Produkt();
			produkt = jdbcDao.vratProdukt(idProduktu);
					
			radek = produkt.getNazev() + ": " + gramy + " gr za " + vypocet+" kè ";
			seznamVypoctu.add(radek);
			session.setAttribute("seznamVypoctu", seznamVypoctu);
			return seznamVypoctu;
		}
}
