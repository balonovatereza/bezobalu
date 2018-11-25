package cz.czechitas.bezobalu.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class FiltrKController {

	private JdbcDao jdbcDao = new JdbcDao();
	
	public void handle(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("tento controller je FiltrKController");
		
		String name =  request.getParameter("name");
		
		//zde si z cvicnych duvodu vysvetlime model
				//cilem je, aby model zapsal do requestu a mohli jsme ho zobrazit v summary.jsp
				
				String name =  request.getParameter("name");
				String surname =  request.getParameter("surname");
				
				Employee employee = new Employee();
				
				employee.setName(name);
				employee.setSurname(surname);
				employee.setId(1);
				employee.setStatus(true);
				
				fileDao.save(employee); 
				jdbcDao.save(employee); //tady se mi zavola ta datova vrstva a ulozi toho zamestnance do toho listu
		
		//request.setAttribute("empList", fileDao.load());
	}
	
}
