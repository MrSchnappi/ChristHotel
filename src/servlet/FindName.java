package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.HistoryOrder;
import dao.IndexUser;
import dao.MessInfoTo;
import model.MessInfoToIndex;
import model.checkin;
import model.client;
import until.DataBaseBean;

/**
 * Servlet implementation class FindName
 */

public class FindName extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindName() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public  void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		  HttpSession session = request.getSession();
		  String id = request.getParameter("id");
		  String workername;
	//	   List<client> clients = new ArrayList<client>();
		   
	//	   List<checkin> Orders;
	//	   HistoryOrder historyOrder =new HistoryOrder();
	//	   Orders=historyOrder.GetOrder();
		   
		  
	//	  MessInfoTo messInfoTo =new MessInfoTo();
	//	  MessInfoToIndex messInfoToIndex =new MessInfoToIndex(); 
	//	  messInfoToIndex = messInfoTo.getInfo();
	//	  IndexUser indexUser = new IndexUser();
		  
		
		   ResultSet rSet;
		   Connection connection;
		   PreparedStatement pStatement;   
		   DataBaseBean dbc = new DataBaseBean();
		   connection = dbc.getConnection();
		  
		//  clients = indexUser.GetIndexClient();
	//	  System.err.println("here comes "+clients.size()+"elements");		
		// System.err.println(clients.get(0).getClientname());
		//    System.out.println("*************"+messInfoToIndex.getCheckInPeo());
		   try {
			pStatement=connection.prepareStatement("SELECT WORKER_NAME FROM WORKER WHERE WORKERID=?");
		    pStatement.setString(1, id);
		    rSet=pStatement.executeQuery();
		    if(rSet.next())
		    {
		        workername= rSet.getString("WORKER_NAME");   
		        request.setAttribute("workername", workername);
		    }
		//    request.setAttribute("orders", Orders);
		//    request.setAttribute("clients", clients);
		    request.setAttribute("id", id); 
		//    request.setAttribute("CheckInPeo", messInfoToIndex.getCheckInPeo());
		 //   request.setAttribute("SpareRoom",messInfoToIndex.getSpareRoom());
		 //   request.setAttribute("TocleanRoom", messInfoToIndex.getTocleanRoom());  
		   request.getRequestDispatcher("index.jsp").forward(request, response);
		   } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}

}
