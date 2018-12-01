package cz.czechitas.bezobalu.servlets;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cz.czechitas.bezobalu.controllers.FiltrPController;
import cz.czechitas.bezobalu.controllers.OdeslatController;
import cz.czechitas.bezobalu.controllers.SpocitejController;
import cz.czechitas.bezobalu.controllers.ZobrazKController;

/**
 * Servlet implementation class KalkulaceServlet
 */
@WebServlet("/kalkulace")
public class KalkulaceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private FiltrPController filtrPController = new FiltrPController();
	private ZobrazKController zobrazKController = new ZobrazKController();
	private SpocitejController spocitejController = new SpocitejController();
	private OdeslatController odeslatController = new OdeslatController();



	@Override
    public void init(ServletConfig config) throws ServletException {

        super.init(config);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = request.getParameter("action");
		zobrazKController.zobrazKategorii(request, response); //zobrazi zvolenou kategorii do nadpisu
		filtrPController.handle(request, response); //vraci ArrayList produktu do dropdown listu
        if (action != null){
            if (action.equals("spocitej")) {
                spocitejController.handle(request, response); //vraci jeden aktualni vypocet
                spocitejController.vypis(request, response); //vraci seznam vypoctu aktualizovany o aktualni vypocet
            } else if (action.equals("odeslat")) {
                odeslatController.handle(request, response);
            }
        }


		getServletConfig().getServletContext().getRequestDispatcher("/kalkulace.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
