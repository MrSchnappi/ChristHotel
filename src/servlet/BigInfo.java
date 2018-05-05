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
 * Servlet implementation class BigInfo
 */
@WebServlet("/BigInfo")
public class BigInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BigInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		  HttpSession session = request.getSession();
		   List<client> clients = new ArrayList<client>();
		   
		   List<checkin> Orders;
		   HistoryOrder historyOrder =new HistoryOrder();
		   Orders=historyOrder.GetOrder();//获取前6个记录
		   
		  
		  MessInfoTo messInfoTo =new MessInfoTo();
		  MessInfoToIndex messInfoToIndex =new MessInfoToIndex(); 
		  messInfoToIndex = messInfoTo.getInfo();
		  IndexUser indexUser = new IndexUser();
		  	 
		  clients = indexUser.GetIndexClient();
		  System.err.println("here comes "+clients.size()+"  elements");		
		   System.err.println(clients.get(0).getClientname());
		    System.out.println("**      "+messInfoToIndex.getCheckInPeo());

		    request.setAttribute("orders", Orders);
		    request.setAttribute("clients", clients);
		    request.setAttribute("CheckInPeo", messInfoToIndex.getCheckInPeo());
		    request.setAttribute("SpareRoom",messInfoToIndex.getSpareRoom());
		    request.setAttribute("TocleanRoom", messInfoToIndex.getTocleanRoom());  
		    System.out.println("客户的大小为"+clients.size());
		    System.out.println("入住信息的大小为"+Orders.size());
		   request.getRequestDispatcher("MassInfo.jsp").forward(request, response);
		 
		}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
