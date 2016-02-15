package fr.labone.javaservlet;


import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieParser
 */
@WebServlet("/CookieParser")
public class CookieParser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CookieParser() {
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
		Enumeration<String> post = request.getParameterNames();
		
		while(post.hasMoreElements()){
			String field = post.nextElement();
			String value = request.getParameter(field);
			if(!value.equals("")){
				String cookieName = "coo_"+field;
				Cookie ck = new Cookie(cookieName, value);
				response.addCookie(ck);
			}
		}
		
		this.getServletContext().getRequestDispatcher("/partone/cookiealert.jsp").forward(request, response);
	}

}
