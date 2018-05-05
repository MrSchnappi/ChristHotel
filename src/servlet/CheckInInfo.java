package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.checkin;
import model.client;
import until.DaoFactory;
import until.Pagination;

/**
 * Servlet implementation class CheckInInfo
 */
@WebServlet("/CheckInInfo")
public class CheckInInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckInInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		String pageNo  = request.getParameter("pageNo");
		int page = 1;
		if(pageNo != null)  page = Integer.parseInt(pageNo);
		
		Pagination pagination = new Pagination();
		pagination.setPageNo(page);
		pagination.setUrl("CheckInInfo?");
		
	///List<client> clients = DaoFactory.getClientDao().getAllClient(pagination);
	List<checkin> checkins = DaoFactory.getCheckInDao().getAllCheckIn(pagination);
	
	
	request.setAttribute("CheckInfos", checkins);
	request.setAttribute("pagination", pagination);
	String reString=pagination.getPageBar();
	System.err.println("this is  getPageBar   "+   reString);
	System.out.println("this is getNumPageBar  "+pagination.getNumPageBar());
	 request.getRequestDispatcher("CheckinInfo.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
