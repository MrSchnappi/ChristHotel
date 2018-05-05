package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.room;
import model.worker;
import until.DataBaseBean;
import until.Pagination;

public class RoomDao implements IroomDao{
	   Connection conn = null;
	   PreparedStatement psmt = null;
	   ResultSet rs = null;
	   List<room> rooms;
	@Override
	public room getroombyRno(String rno) {
		// TODO Auto-generated method stub
	   conn = DataBaseBean.getConnection();
	   try {
		psmt = conn.prepareStatement("SELECT * FROM ROOM WHERE ROOMid=?");
	   psmt.setString(1, rno);
		rs=psmt.executeQuery();
	   if(rs.next())
	   {
		   room room = new room();
		   room.setRno(rs.getString("ROOMid"));
		   room.setRprice(rs.getString("ROOMPRICE"));
		   room.setRstate(rs.getString("ROOMSTATE"));
		   room.setRtype(rs.getString("ROOMTYPE"));
		
		   return room;
	   }
	   } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DataBaseBean.close(rs, psmt, conn);
		}
		return null;
	}

	@Override
	public List<room> getroombystate(String state) {
		conn = DataBaseBean.getConnection();
		rooms = new ArrayList<>();
		   try {
			psmt = conn.prepareStatement("SELECT * FROM ROOM WHERE ROOMSTATE=?");
		   psmt.setString(1, state);
			rs=psmt.executeQuery();
		   while(rs.next())
		   {
			   room room = new room();
			   room.setRno(rs.getString("ROOMid"));
			   room.setRprice(rs.getString("ROOMPRICE"));
			   room.setRstate(rs.getString("ROOMSTATE"));
			   room.setRtype(rs.getString("ROOMTYPE"));
			   rooms.add(room);
			   return rooms;
		   }
		   } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				DataBaseBean.close(rs, psmt, conn);
			}
			return null;
	}

	@Override
	public void insertroom(room house) {
		// TODO Auto-generated method stub
		conn = DataBaseBean.getConnection();
		try {
			psmt= conn.prepareStatement("INSERT INTO ROOM VALUES (?,?,?,?)");
	
		psmt.setInt(1, Integer.parseInt(house.getRno()));
		psmt.setString(2, house.getRtype());
		psmt.setString(3, house.getRprice());
		psmt.setString(4, house.getRstate());
	   psmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DataBaseBean.close(rs, psmt, conn);
		}
	}

	@Override
	public void deleteroom(String room) {
		// TODO Auto-generated method stub
		conn = DataBaseBean.getConnection();
		try {
				psmt=conn.prepareStatement("DELETE FROM ROOM WHERE ROOMid=?");	
				psmt.setString(1, room);
				psmt.executeQuery();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					DataBaseBean.close(rs, psmt, conn);
				}	
	}

	@Override
	public void updateroom(room room) {
		// TODO Auto-generated method stub
		conn = DataBaseBean.getConnection();
        try {
		psmt = conn.prepareStatement("UPDATE ROOM SET ROOMTYPE=?,ROOMPRICE=?,ROOMSTATE=? WHERE ROOMid=? ");
        psmt.setString(1, room.getRtype());        
        psmt.setString(2,room.getRprice());
        psmt.setString(3, room.getRstate());  
        psmt.setInt(4, Integer.parseInt(room.getRno()));     
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
	public List<room> getAllroom(Pagination pagination) {
		// TODO Auto-generated method stub
		 List<room> rooms = new ArrayList<room>();
	        try {
	            conn = DataBaseBean.getConnection();
	            psmt = conn.prepareStatement("select count(*) as counts from ROOM");
	            rs = psmt.executeQuery();
	            rs.next();
	            //求总记录数
	            pagination.setCountSize(rs.getInt("counts"));
	            int start = (pagination.getPageNo() - 1) * pagination.getPageSize() + 1;//开始位置
	            int end = pagination.getPageNo() * pagination.getPageSize();//结束位置
	            psmt = conn.prepareStatement("SELECT * FROM (SELECT ROWNUM NO , s.* FROM (SELECT * FROM ROOM ORDER BY sno ASC) s WHERE ROWNUM<=?) WHERE NO>=?");

	            psmt.setInt(1, end);
	            psmt.setInt(2, start);
	            rs = psmt.executeQuery();
	            while (rs.next()) {
	            	room SingleRoom = new room();
	            	SingleRoom.setRno(rs.getString("ROOMid"));
	            	SingleRoom.setRprice(rs.getString("ROOMPRICE"));
	            	SingleRoom.setRstate(rs.getString("ROOMSTATE"));
	            	SingleRoom.setRtype(rs.getString("ROOMTYPE"));
	  			   rooms.add(SingleRoom);
	            }
	        } catch (SQLException e) {
	        	e.printStackTrace();
	        } finally {
	            DataBaseBean.close(rs, psmt, conn);
	        }
	        return rooms;
	}

}
