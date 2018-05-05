package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Payment;
import until.DaoFactory;

/**
 * Servlet implementation class deletecheckinfo
 */
@WebServlet("/deletecheckinfo")
public class deletecheckinfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deletecheckinfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		Payment pay;
	    String clientnu =request.getParameter("clientnu");
	    String roomnu =request.getParameter("roomnu");    
	   //计算钱的数值
	    
	    new DaoFactory().getCheckInDao().deleteCheckin(roomnu, clientnu);//删除记录
	    new DaoFactory().getRoomDao().updateroomState(Integer.parseInt(roomnu), "spare");//更改房间状态
	  
	   pay = new DaoFactory().getCheckInDao().SumMoney(roomnu, clientnu); 
	    request.setAttribute("pay", pay);
	    
	    
	    
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
