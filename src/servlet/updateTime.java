package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.taglibs.standard.lang.jstl.test.beans.Factory;

import dao.ClientDao;
import model.client;
import until.DaoFactory;

/**
 * Servlet implementation class updateTime
 */
@WebServlet("/updateTime")
public class updateTime extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateTime() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String days=request.getParameter("form_data");
		String clientid = request.getParameter("clientnu");
		String  roomnu = request.getParameter("roomnu");
		PrintWriter out = response.getWriter();
		if(days!=null)
		{		 
			
			new DaoFactory().getCheckInDao().updateCheckInDay(roomnu, clientid, days);
	       out.print("OK");
     	   	out.flush();
				out.close();
		   }
		else
		{
			 out.print("failed");
	     	   	out.flush();
					out.close();
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
