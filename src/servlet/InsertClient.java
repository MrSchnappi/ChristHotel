package servlet;
import java.util.regex.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.org.apache.xalan.internal.xsltc.compiler.Pattern;
import com.sun.org.apache.xerces.internal.impl.xs.SchemaSymbols;

import dao.ClientDao;
import model.client;
import until.DaoFactory;

@WebServlet("/InsertClient")
public class InsertClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertClient() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String datapackage=request.getParameter("form_data");
		PrintWriter out = response.getWriter();
		if(datapackage!=null)
		{		 
			String[] data = request.getParameter("form_data").split("&");
			
			String clientNo =data[0].substring(data[0].indexOf("=")+1);
			String idCard = data[1].substring(data[1].indexOf("=")+1);
			String clientname = data[2].substring(data[2].indexOf("=")+1);
			String phoneNumber = data[3].substring(data[3].indexOf("=")+1);
			String clientType = data[4].substring(data[4].indexOf("=")+1);
			String clientInfo  = data[5].substring(data[5].indexOf("=")+1,data[5].indexOf("+"));
			String clientInfoNew=clientInfo.trim();
			System.out.println("解析后的数据为  "+clientInfoNew
					+"   "+clientNo+"   "+clientname+"   "+clientType+"   "+phoneNumber);
			if(clientNo.length()>9||clientNo.length()<6||idCard.length()!=18||phoneNumber.length()!=11||clientInfo.length()>20)
			{
				out.print("输入格式有问题，检查后输入");
				out.flush();
				out.close();
			}
		
			 if (DaoFactory.getClientDao().getClient(clientNo)!=null) {
					out.print("客户编号已经存在");
					out.flush();
					out.close();
				}
			else
			{	
			client client = new client(Integer.parseInt(clientNo), idCard, clientType, clientname, phoneNumber,clientInfoNew);
			new ClientDao().insertClient(client);	
			out.print("OK");
			out.flush();
			out.close();
		   }
		}
		else
		{
		String ClientNo  = request.getParameter("ClientNo");
		String clientname = request.getParameter("Name");
		String IdCard = request.getParameter("IdCard");
		String phoneNumber = request.getParameter("phoneNumber");
		String ClientInfo  = request.getParameter("ClientInfo");
		String ClientType = request.getParameter("ClientType");
		System.err.println("hello  this message is "+ClientNo +IdCard+phoneNumber+ClientInfo+ClientType);
		String clientInfoNew=ClientInfo.trim();
		client client = new client(Integer.parseInt(ClientNo), IdCard, ClientType, clientname, phoneNumber,clientInfoNew);
		new ClientDao().insertClient(client);	
		request.getRequestDispatcher("user.jsp").forward(request, response);
		}
	}

}
