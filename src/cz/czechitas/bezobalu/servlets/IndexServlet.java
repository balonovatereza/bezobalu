package cz.czechitas.bezobalu.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cz.czechitas.bezobalu.controllers.FiltrKController;
import cz.czechitas.bezobalu.controllers.VratMestaController;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/vyberMesta")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	VratMestaController vratMestaController = new VratMestaController();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		vratMestaController.handle(request, response); //vraci vsechna mesta, co jsou v databazi
		getServletConfig().getServletContext().getRequestDispatcher("/vyberMesta.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
