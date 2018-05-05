package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sun.security.ntlm.Client;

import model.client;
import until.DataBaseBean;

public class IndexUser {
	List<client> clients;

	   ResultSet rSet;
	   Connection connection;
	   PreparedStatement pStatement;
	   DataBaseBean dbBaseBean;
	   String UserInfo = "select CLIENTid,CLIENTNAME ,CLIENTPHONE from CLIENT  where rownum<=6";
	public List<client> GetIndexClient()
	{
		dbBaseBean = new DataBaseBean();
		clients = new ArrayList<>();
		connection = dbBaseBean.getConnection();
		try {
			pStatement=  connection.prepareStatement(UserInfo);
			rSet = pStatement.executeQuery();
			while(rSet.next()) 
			{
				client 	user = new client();
				user.setClientid(Integer.parseInt(rSet.getString("CLIENTid")));
				user.setClientname(rSet.getString("CLIENTNAME"));
				user.setClientphone(rSet.getString("CLIENTPHONE"));
				System.err.println(rSet.getString("CLIENTPHONE"));
				clients.add(user);	
	    System.out.println("循环次数在累加");
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return clients;
	}

}
