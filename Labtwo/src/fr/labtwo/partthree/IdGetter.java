package fr.labtwo.partthree;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class IdGetter
 */
@WebServlet("/IdGetter")
public class IdGetter extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String[] allPseudo = {"lmd","steveJ","Turning","MaxW","abc","root", "NicoTesla"};
    private static HashMap<String,String> passwd = new HashMap();
    
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IdGetter() {
        super();
        // TODO Auto-generated constructor stub
        passwd.put(allPseudo[0],"divad");
        passwd.put(allPseudo[1],"azert");
        passwd.put(allPseudo[2],"azerty");
        passwd.put(allPseudo[3],"Magneto");
        passwd.put(allPseudo[4],"123");
        passwd.put("root","root");
        passwd.put(allPseudo[6],"Electro");
    }
    
    
   
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setHeader("content-type", "text/plain");
		PrintWriter w = response.getWriter();
		w.print("Please Don't use this url with a get method.\n This servlet is only to tcheck the pseudo in the part 3 of the lab2. Thank you.");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setHeader("content-type", "text/plain");
		int p = request.getParameterMap().size();
		if(p == 1){
			String id = request.getParameter("id");
			String res = (Arrays.asList(allPseudo).contains(id)) ? "1" : "0";
			response.getWriter().write(res);
		} else {
			String id = request.getParameter("id");
			String pwd = request.getParameter("passwd");
			if( Arrays.asList(allPseudo).contains(id)){
				if(passwd.get(id).equals(pwd)){
					response.getWriter().write("1");
				} else {
					response.getWriter().write("0");
				}
			} else {
				response.getWriter().write("0");
			}
		}
		
	}

}