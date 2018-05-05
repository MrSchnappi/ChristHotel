package servlet;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.client;
import until.DaoFactory;

/**
 * Servlet implementation class FindClient
 */

public class FindClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindClient() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub		
		request.setCharacterEncoding("UTF-8"); 
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		List<client> clients = new ArrayList<>();
		String type=request.getParameter("type");
		if(type.equals("NO"))
		{
            String text = request.getParameter("text").trim();
            client client = DaoFactory.getClientDao().getClient(text);
            clients.add(client);
            request.setAttribute("Clients", clients);
            request.getRequestDispatcher("FindClient.jsp").forward(request, response);
		}
		else{
			
			String text = URLDecoder.decode(request.getParameter("text"),"utf-8");
        text = text.trim();
			System.err.println(text);
			text = "%"+text+"%";
			System.out.println("空缺的地方时"+text);
			
			clients=DaoFactory.getClientDao().getSomeClient(text);
		    request.setAttribute("Clients", clients);
		    request.getRequestDispatcher("FindClient.jsp").forward(request, response);	
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
