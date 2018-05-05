package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CheckInDao;
import dao.ClientDao;
import model.checkin;
import model.client;

/**
 * Servlet implementation class InsertCheckin
 */
@WebServlet("/InsertCheckin")
public class InsertCheckin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertCheckin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		String ClientNo  = request.getParameter("ClientNo");
		String CheckRoom = request.getParameter("CheckRoom");
		String CheckinNum = request.getParameter("CheckinNum");
		String CheckinMoney = request.getParameter("CheckinMoney");
		String CheckinTime  = request.getParameter("CheckinTime");//to_date('2018-04-01','yyyy-mm-dd')
		String DepartureTime =request.getParameter("DepartureTime");
		String CheckinInfo = request.getParameter("CheckinInfo").trim();
		System.err.println("hello  this message is "+ClientNo +CheckRoom+CheckinNum+CheckinMoney+CheckinTime+DepartureTime+CheckinInfo);
	    checkin checkin = new checkin(CheckRoom, ClientNo, CheckinTime, CheckinNum, CheckinInfo, DepartureTime, CheckinMoney);
       
		new CheckInDao().insertCheckin(checkin);
	    response.sendRedirect("checkin.jsp");
		//request.getRequestDispatcher("user.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
