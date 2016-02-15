package fr.labone.mvc.controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.format.DateTimeFormat;

import fr.labone.mvc.model.Humain;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String birthDay = request.getParameter("birthDay");
		String sex = request.getParameter("sex");
		
		Humain h = new Humain(firstName, lastName, birthDay, sex);
		
		request.setAttribute("beanH", h);
		
		DateTime bDay = new DateTime();
		DateTime tLimit = new DateTime();
		tLimit = DateTime.parse("30/12/1989", DateTimeFormat.forPattern("dd/MM/yyyy"));
		
		try	{
			bDay = DateTime.parse(birthDay, DateTimeFormat.forPattern("dd/MM/yyyy"));
		} catch(Exception e) {
			this.getServletContext().getRequestDispatcher("/parttree/table.jsp").forward(request, response);
		}
		
		if(bDay.isBefore(tLimit)){
			this.getServletContext().getRequestDispatcher("/parttree/allowed.jsp").forward(request, response);
		} else {

			this.getServletContext().getRequestDispatcher("/parttree/rejected.jsp").forward(request, response);
		}
		
		
	}
	
}
