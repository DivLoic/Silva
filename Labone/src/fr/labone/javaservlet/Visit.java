package fr.labone.javaservlet;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;

/**
 * Servlet implementation class Visite
 */
@WebServlet("/Visit")
public class Visit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Visit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Cookie[] cs = request.getCookies();
		Boolean found = false;
		for(Cookie c : cs){
			if(c.getName().equals("visited")){
				int nb = Integer.parseInt(c.getValue(), 10) + 1;
				c.setValue(Integer.toString(nb));
				response.addCookie(c);
				found = true;
			}
		}
		
		if(!found){
			Cookie visited = new Cookie("visited", "1");
			response.addCookie(visited);
		}
		
		response.sendRedirect("/Labone/index.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
