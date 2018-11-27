package cz.czechitas.bezobalu.servlets;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cz.czechitas.bezobalu.controllers.FiltrKController;

@WebServlet("/kategorie")
public class KategorieServlet extends HttpServlet  {
private static final long serialVersionUID = 1L;
	
	private FiltrKController filtrKController = new FiltrKController();

	
	
	@Override
    public void init(ServletConfig config) throws ServletException {
		
        super.init(config);
    }
       
  
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		
			filtrKController.handle(request, response); //vraci ArrayList kategorii do dropdown listu
		
		
		getServletConfig().getServletContext().getRequestDispatcher("/kategorie.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		doGet(request, response);
	}

}
