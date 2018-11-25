package cz.czechitas.bezobalu.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ActionServlet
 */
@WebServlet("/ActionServlet")
public class ActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int Kategorie = 0;
       
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
		ArrayList<Kategorie> vyfiltrovaneKategorie = new ArrayList<Kategorie>();
		
		//tohle jen fiktivni naplneni listu pro Alcu
		Kategorie lusteniny = new Kategorie(1, "lusteniny");
		Kategorie kosmetika = new Kategorie(2, "kosmetika ");
		
		
		vyfiltrovaneKategorie.add(lusteniny);
		vyfiltrovaneKategorie.add(kosmetika);
		
		String action = request.getParameter("action");
		
		if (action.equals("vyfiltrujKaterogie")) {
			request.setAttribute("vyfiltrovaneKategorie", vyfiltrovaneKategorie);
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
