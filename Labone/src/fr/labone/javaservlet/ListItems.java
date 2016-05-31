package fr.labone.javaservlet;


import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ListItems
 */
@WebServlet("/ListItems")
public class ListItems extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListItems() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession s = request.getSession();
		if(s.getAttribute("list") == null){
			s.setAttribute("line", "U can set your first Article right now !!!");
		} else {
			s.setAttribute("line", "check the Item list below.");
		}
		
		if(s.getAttribute("items") == null){ 
			HashMap<String, Integer> items = new HashMap<String, Integer>(); 
			s.setAttribute("items", items);
		}
		
		this.getServletContext().getRequestDispatcher("/partone/item.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession s = request.getSession();
		String i = request.getParameter("item");
		
		if(s.getAttribute("items") == null){ 
			HashMap<String, Integer> items = new HashMap<String, Integer>(); 
			s.setAttribute("items", items);
		}
		
		HashMap<String, Integer> box = (HashMap<String, Integer>)s.getAttribute("items");
		
		if(!i.trim().equals("")){
			if(box.containsKey(i)){
				box.put(i, box.get(i)+1);
			} else {
				box.put(i, 1);
			}
			
			s.setAttribute("line", "This i yout list of items!");
		} else {
			s.setAttribute("line", "Let's add an item!");
		}
		
		this.getServletContext().getRequestDispatcher("/partone/item.jsp").forward(request, response);
	}

}
