package cz.czechitas.bezobalu.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cz.czechitas.bezobalu.controllers.FiltrKController;
import cz.czechitas.bezobalu.controllers.FiltrPController;
import cz.czechitas.bezobalu.controllers.OdeslatController;
import cz.czechitas.bezobalu.controllers.SpocitejController;

/**
 * Servlet implementation class ActionServlet
 */
@WebServlet("/kalkulace")
public class ActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private FiltrKController filtrKController = new FiltrKController();
	private FiltrPController filtrPController = new FiltrPController();
	private SpocitejController spocitejController = new SpocitejController();
	private OdeslatController odeslatController = new OdeslatController();
	
	
	
	@Override
    public void init(ServletConfig config) throws ServletException {
		
        super.init(config);
    }
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		
		if (action.equals("vyfiltrujKaterogie")) {
			filtrKController.handle(request, response);
		} else if (action.equals("vyfiltrujProdukty")) {
			filtrPController.handle(request, response);
		} else if (action.equals("spocitej")) {
			spocitejController.handle(request, response);
		} else if (action.equals("odeslat")) {
			 odeslatController.handle(request, response);
		}
		
		getServletConfig().getServletContext().getRequestDispatcher("/kalkulace.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		doGet(request, response);
	}

}
