package cz.czechitas.bezobalu.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cz.czechitas.bezobalu.dao.JdbcDao;

public class VratMestaController {
	
	private JdbcDao jdbcDao = new JdbcDao();
	
	public void handle(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("tento controller je VratMestaController");

			request.setAttribute("vsechnaMesta", jdbcDao.vratMesta());

	}

}
