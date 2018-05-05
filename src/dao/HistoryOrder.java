package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.checkin;
import model.client;
import until.DataBaseBean;

public class HistoryOrder {
	List<checkin> Orders;
	ResultSet rSet;
	Connection connection;
	PreparedStatement pStatement;
	DataBaseBean dbBaseBean;
	String OrderInfo ="select ROOMID,CLIENTID,CLIENTNAME from CLIENT NATURAL JOIN  CHECKIN  where rownum<=6";
	 public List<checkin> GetOrder()
		{
			dbBaseBean = new DataBaseBean();
			Orders = new ArrayList<>();
			connection = dbBaseBean.getConnection();
				try {
					pStatement=  connection.prepareStatement(OrderInfo);
					rSet = pStatement.executeQuery();
					while(rSet.next()) 
					{
						checkin order = new checkin();
						order.setCheckin_clientid(rSet.getString("CLIENTID"));
						order.setCheckin_roomid(rSet.getString("ROOMID"));
						order.setClientname(rSet.getString("CLIENTNAME"));	
						Orders.add(order);	
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return Orders;
}
}

