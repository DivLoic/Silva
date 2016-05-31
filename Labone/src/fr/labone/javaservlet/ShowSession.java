package fr.labone.javaservlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.joda.time.*;
import org.joda.time.format.DateTimeFormat;


/**
 * Servlet implementation class ShowSession
 */
@WebServlet("/ShowSession")
public class ShowSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowSession() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession s = request.getSession();
		Object l = s.getAttribute("laps");
		
		if(l == null){
			int laps = 0;
			s.setAttribute("laps", laps);
		} else {
			int laps = Integer.parseInt(l.toString()) + 1;
			s.setAttribute("laps", laps);
		}
		s.setAttribute("days", -1);
		this.getServletContext().getRequestDispatcher("/partone/checkpoint.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = (String)request.getParameter("name");
		String date = (String)request.getParameter("date");
		date = date +"/2015";
		
		DateTime t1 = new DateTime();
		new DateTime();
		DateTime now = DateTime.now();
		
		try	{
			t1 = DateTime.parse(date, DateTimeFormat.forPattern("dd/MM/yyyy"));
		} catch(Exception e) {
			
		}
		int diff = Days.daysBetween(now, t1).getDays();
		
		if(diff < 0)diff = diff + 365;
		request.getSession().setAttribute("days", diff);
		request.getSession().setAttribute("name", name);
		this.getServletContext().getRequestDispatcher("/partone/checkpoint.jsp").forward(request, response);

	}
	

}
