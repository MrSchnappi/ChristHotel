package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;

import model.client;
import until.DataBaseBean;
import until.Pagination;

public class ClientDao implements IclientDao {

	   Connection conn = null;
	   PreparedStatement psmt = null;
	   ResultSet rs = null;

	public List<client> getAllClient(Pagination pagination) {
		List<client> clients = new ArrayList<>();
		conn = DataBaseBean.getConnection();
		try {
			psmt = conn.prepareStatement("SELECT COUNT(*) AS COUNTS FROM CLIENT");
			rs = psmt.executeQuery();
			rs.next();
			
			pagination.setCountSize(rs.getInt("COUNTS"));
			
			
			System.err.println(pagination.getCountSize());
			
			
			int start = (pagination.getPageNo() - 1)*pagination.getPageSize();
			int end = pagination.getPageNo()*pagination.getPageSize();

			
			psmt=conn.prepareStatement("SELECT * FROM (SELECT ROWNUM NO , s.* FROM (SELECT * FROM CLIENT ORDER BY CLIENTID ASC) s WHERE ROWNUM<=?) WHERE NO>=?");	
			psmt.setInt(1, end);
			psmt.setInt(2, start);
			rs=psmt.executeQuery();
			while(rs.next())
			{
				client SingleClient = new client();
				SingleClient.setClientid(Integer.parseInt(rs.getString("CLIENTid")));//编号
				SingleClient.setClientinfo(rs.getString("CLIENTINFO"));
				SingleClient.setClientname(rs.getString("CLIENTNAME"));
				SingleClient.setClientno(rs.getString("CLIENTNO"));//身份证号
				SingleClient.setClientphone(rs.getString("CLIENTPHONE"));
				SingleClient.setClienttype(rs.getString("CLIENTTYPE"));
				clients.add(SingleClient);				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			DataBaseBean.close(rs, psmt, conn);
		}
		return clients;
	}

	/*
	 * OK
	 * 
	 */
	@Override
	public client getClient(String Cno) {
		// TODO Auto-generated method stub
		conn = DataBaseBean.getConnection();
		try {
			psmt=conn.prepareStatement("SELECT * FROM CLIENT WHERE CLIENTID=?");
			psmt.setInt(1, Integer.parseInt(Cno));
			rs=psmt.executeQuery();
			if(rs.next())
			{
				client SingleClient = new client();
				SingleClient.setClientid(Integer.parseInt(rs.getString("CLIENTid")));//编号
				SingleClient.setClientinfo(rs.getString("CLIENTINFO"));
				SingleClient.setClientname(rs.getString("CLIENTNAME"));
				SingleClient.setClientno(rs.getString("CLIENTNO"));//身份证号
				SingleClient.setClientphone(rs.getString("CLIENTPHONE"));
				SingleClient.setClienttype(rs.getString("CLIENTTYPE"));
				return SingleClient;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			DataBaseBean.close(rs, psmt, conn);
		}
		return null;
	
	}
/*
 * OK
 * 
 */
	@Override
	public void insertClient(client cli) {
		// TODO Auto-generated method stub		
            conn = DataBaseBean.getConnection();
            try {
		    psmt = conn.prepareStatement("INSERT INTO CLIENT VALUES (?,?,?,?,?,?)");
            psmt.setInt(1, cli.getClientid());
            psmt.setString(2, cli.getClientno());
            psmt.setString(3, cli.getClienttype());
            psmt.setString(4, cli.getClientname());
            psmt.setString(5, cli.getClientphone());
            psmt.setString(6, cli.getClientinfo());
            psmt.executeUpdate();
    	} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				DataBaseBean.close(rs, psmt, conn);
			}

	}
	
/*
 * OK
 * 
 */
	@Override
	public void deleteClient(String Cno) {
		// TODO Auto-generated method stub
		conn = DataBaseBean.getConnection();
try {
		psmt=conn.prepareStatement("DELETE FROM CLIENT WHERE CLIENTid=?");	
		psmt.setString(1, Cno);
		psmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DataBaseBean.close(rs, psmt, conn);
		}
	}

	@Override
	public void updateClient(client client) {
		// TODO Auto-generated method stub
		conn = DataBaseBean.getConnection();
        try {
		psmt = conn.prepareStatement("UPDATE CLIENT SET CLIENTNO=?,CLIENTTYPE=?,CLIENTNAME=?,CLIENTPHONE=?,CLIENTINFO=? WHERE CLIENTid=? ");
        psmt.setString(1, client.getClientno());        
        psmt.setString(2,client.getClienttype());
        psmt.setString(3, client.getClientname());     
        psmt.setString(4, client.getClientphone());
        psmt.setString(5, client.getClientinfo());
        psmt.setInt(6, client.getClientid());
        psmt.executeUpdate();
    	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally 
        {
			DataBaseBean.close(rs, psmt, conn);
		}      
	}

	@Override
	public List<client> getSomeClient(String text) {
		List<client> clients = new ArrayList<>();
		conn = DataBaseBean.getConnection();
		try {
			
			psmt = conn.prepareStatement("SELECT * FROM CLIENT WHERE CLIENTNO LIKE ? OR  CLIENTTYPE LIKE ? OR CLIENTNAME LIKE ? OR CLIENTPHONE LIKE ? ");
			psmt.setString(1, text);
			psmt.setString(2, text);
			psmt.setString(3, text);
			psmt.setString(4, text);
			
			rs=psmt.executeQuery();
			while(rs.next())
			{
				client SingleClient = new client();
				SingleClient.setClientid(Integer.parseInt(rs.getString("CLIENTid")));//编号
				SingleClient.setClientinfo(rs.getString("CLIENTINFO"));
				SingleClient.setClientname(rs.getString("CLIENTNAME"));
				SingleClient.setClientno(rs.getString("CLIENTNO"));//身份证号
				SingleClient.setClientphone(rs.getString("CLIENTPHONE"));
				SingleClient.setClienttype(rs.getString("CLIENTTYPE"));
				clients.add(SingleClient);				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			DataBaseBean.close(rs, psmt, conn);
		}
		return clients;
	}

}
