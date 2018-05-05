package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClientDao;
import model.client;

/**
 * Servlet implementation class UpdateClientData
 */

public class UpdateClientData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateClientData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
		String ClientNo  = request.getParameter("ClientNo");
		String clientname = request.getParameter("Name");
		String IdCard = request.getParameter("IdCard");
		String phoneNumber = request.getParameter("phoneNumber");
		String ClientInfo  = request.getParameter("ClientInfo");
		String ClientType = request.getParameter("ClientType");
		System.err.println("hello  this message is "+ClientNo +IdCard+phoneNumber+ClientInfo+ClientType);
		String clientInfoNew=ClientInfo.trim();
		client client = new client(Integer.parseInt(ClientNo), IdCard, ClientType, clientname, phoneNumber,clientInfoNew);
		new ClientDao().updateClient(client);
		request.getRequestDispatcher("clientinfo.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
