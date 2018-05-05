package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.MessInfoToIndex;
import until.DataBaseBean;

public class MessInfoTo {
	   ResultSet rSet;
	   Connection connection;
	   MessInfoToIndex  messInfoToIndex;
	   PreparedStatement pStatement;
	   String CheckInPeo = "select count(*) as CheckInPeo from CLIENT";
	   String ToCleanRoom = "select count(*)  as ToCleanRoom from ROOM where ROOMSTATE='toclean' ";
	   String SpareRoom = "select count(*) as SpareRoom from ROOM where ROOMSTATE='spare' ";
	   public MessInfoToIndex getInfo()
	   {
		   messInfoToIndex = new MessInfoToIndex();
		   DataBaseBean dbc = new DataBaseBean();
		   connection= dbc.getConnection();
			try {
				pStatement=  connection.prepareStatement(CheckInPeo);
				rSet = pStatement.executeQuery();
				if(rSet.next()) 
				{
					messInfoToIndex.setCheckInPeo(Integer.parseInt(rSet.getString("CheckInPeo")));
					System.err.println("+++++++++="+rSet.getString("CheckInPeo"));
		
				}
				//dbc.close(rSet, pStatement, connection);
				
				connection= dbc.getConnection();
				pStatement=  connection.prepareStatement(ToCleanRoom);
				rSet = pStatement.executeQuery();
				if(rSet.next()) 
				{
					messInfoToIndex.setTocleanRoom(Integer.parseInt(rSet.getString("ToCleanRoom")));
					
				}
		//		dbc.close(rSet, pStatement, connection);
				
				connection= dbc.getConnection();
				pStatement=  connection.prepareStatement(SpareRoom);
				rSet = pStatement.executeQuery();
				if(rSet.next()) 
				{
					messInfoToIndex.setSpareRoom(Integer.parseInt(rSet.getString("SpareRoom")));
				}
				dbc.close(rSet, pStatement, connection);		
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
			System.out.println("传递之前的数据为"+messInfoToIndex.getCheckInPeo());
		   return messInfoToIndex;
	   }

}
