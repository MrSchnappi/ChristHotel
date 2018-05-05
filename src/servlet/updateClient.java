package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.client;
import until.DaoFactory;

/**
 * Servlet implementation class updateClient
 */
@WebServlet("/updateClient")
public class updateClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateClient() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		System.out.println("Come in");
		String ClientNO = request.getParameter("id");
		System.out.println("传递过来的ID是  "+ClientNO);
		client   client = DaoFactory.getClientDao().getClient(ClientNO);
		if(client==null)System.out.println("hhhhh");
		request.setAttribute("Client", client);
		System.err.println(client.getClientid()+client.getClientinfo()+client.getClientname());
		request.getRequestDispatcher("updateClient.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
