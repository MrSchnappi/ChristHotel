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
import until.Pagination;

public class CheckInDao implements ICheckInDao {
	  Connection conn = null;
	   PreparedStatement psmt = null;
	   ResultSet rs = null;
	@Override
	public List<checkin> getAllCheckIn(Pagination pagination) {
		// TODO Auto-generated method stub
		 List<checkin> checkins = new ArrayList<checkin>();
	        try {
	            conn = DataBaseBean.getConnection();
	            psmt = conn.prepareStatement("select count(*) as counts from CHECKIN");
	            rs = psmt.executeQuery();
	            rs.next();
	            //求总记录数
	            pagination.setCountSize(rs.getInt("counts"));
	            int start = (pagination.getPageNo() - 1) * pagination.getPageSize() + 1;//开始位置
	            int end = pagination.getPageNo() * pagination.getPageSize();//结束位置
	            psmt = conn.prepareStatement("SELECT * FROM (SELECT ROWNUM NO , s.* FROM (SELECT * FROM CHECKIN ORDER BY sno ASC) s WHERE ROWNUM<=?) WHERE NO>=?");
	            psmt.setInt(1, end);
	            psmt.setInt(2, start);
	            rs = psmt.executeQuery();
	            while (rs.next()) {
	            	checkin chin = new checkin();
	            	chin.setCheckin_clientid(rs.getString("CLIENTID"));
	            	chin.setCheckin_roomid(rs.getString("ROOMID"));
	            	chin.setCheckininfo(rs.getString("CHECKININFO"));
	            	chin.setCheckinmoney(rs.getString("CHECKINMONEY"));
	            	chin.setCheckinnum(rs.getString("CHECKINNUM"));
	            	chin.setCheckintime(rs.getString("CHECKINTIME"));
	            	chin.setClientname(rs.getString("CLIENTNAME"));
	            	chin.setDeparturetime(rs.getString("DEPARTURETIME"));
	            	checkins.add(chin);
	            }
	        } catch (SQLException e) {
	        	e.printStackTrace();
	        } finally {
	            DataBaseBean.close(rs, psmt, conn);
	        }
	        return checkins;
		
	}

	@Override
	public void updateCheckInByRoomID(checkin checkin) {
		// TODO Auto-generated method stub
		conn = DataBaseBean.getConnection();
        try {
		psmt = conn.prepareStatement("UPDATE CHECKIN SET CLIENTID=?,CHECKINNUM=?,CHECKINTIME=?,DEPARTURETIME=? CHECKINMONEY=? CHECKININFO=?WHERE ROOMID=? ");
        psmt.setString(1, checkin.getCheckin_clientid());        
        psmt.setInt(2,Integer.parseInt(checkin.getCheckinnum()));
        psmt.setString(3,"to_date( "+checkin.getCheckintime()+",'yyyy-mm-dd')");     
        psmt.setString(4, "to_date( "+checkin.getDeparturetime()+",'yyyy-mm-dd')");
        psmt.setInt(5, Integer.parseInt(checkin.getCheckinmoney()));
        psmt.setString(6,checkin.getCheckininfo());
        psmt.setInt(7, Integer.parseInt(checkin.getCheckin_roomid()));
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
	public void insertCheckin(checkin checkin) {
		// TODO Auto-generated method stub
		conn = DataBaseBean.getConnection();
        try {
		psmt = conn.prepareStatement("INSERT INTO CHECKIN VALUES (?,?,?,to_date( ?,'mm/dd/yyyy'),to_date( ?,'mm/dd/yyyy'),?,?) ");
		 psmt.setInt(1, Integer.parseInt(checkin.getCheckin_roomid()));
        psmt.setInt(2,  Integer.parseInt(checkin.getCheckin_clientid()));        
        psmt.setInt(3,Integer.parseInt(checkin.getCheckinnum()));
        psmt.setString(4,checkin.getCheckintime());     
        psmt.setString(5, checkin.getDeparturetime());
        psmt.setInt(6, Integer.parseInt(checkin.getCheckinmoney()));
        psmt.setString(7,checkin.getCheckininfo());
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
	public void deleteCheckin(String ROOMID,String  CLIENTID) {
		// TODO Auto-generated method stub
		conn = DataBaseBean.getConnection();
		try {
				psmt=conn.prepareStatement("DELETE FROM CHECKIN WHERE CLIENTid=? AND ROOMID=?");	
				psmt.setInt(1, Integer.parseInt(ROOMID));
				psmt.setInt(2, Integer.parseInt(CLIENTID));
				psmt.executeQuery();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					DataBaseBean.close(rs, psmt, conn);
				}
	}

	@Override
	public checkin getCheckinByRno(String Rno) {
		// TODO Auto-generated method stub
		conn = DataBaseBean.getConnection();
		try {
			psmt=conn.prepareStatement("SELECT * FROM  CLIENT NATURAL JOIN  CHECKIN WHERE ROOMID=?");
			psmt.setString(1, Rno);
			rs=psmt.executeQuery();
			if(rs.next())
			{
				checkin SingleCheckin = new checkin();
				SingleCheckin.setCheckin_clientid(rs.getString("CLIENTID"));
				SingleCheckin.setCheckin_roomid(rs.getString("ROOMID"));
				SingleCheckin.setCheckininfo(rs.getString("CHECKININFO"));
				SingleCheckin.setCheckinmoney(rs.getString("CHECKINMONEY"));
				SingleCheckin.setCheckinnum(rs.getString("CHECKINNUM"));
				SingleCheckin.setCheckintime(rs.getString("CHECKINTIME"));
				SingleCheckin.setClientname(rs.getString("CLIENTNAME"));
				SingleCheckin.setDeparturetime(rs.getString("DEPARTURETIME"));
				return SingleCheckin;
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

	@Override
	public checkin getCheckinByCno(String Cno) {
		// TODO Auto-generated method stub
		conn = DataBaseBean.getConnection();
		try {
			psmt=conn.prepareStatement("SELECT * FROM  CLIENT NATURAL JOIN  CHECKIN WHERE CLIENTID=?");
			psmt.setString(1, Cno);
			rs=psmt.executeQuery();
			if(rs.next())
			{
				checkin SingleCheckin = new checkin();
				SingleCheckin.setCheckin_clientid(rs.getString("CLIENTID"));
				SingleCheckin.setCheckin_roomid(rs.getString("ROOMID"));
				SingleCheckin.setCheckininfo(rs.getString("CHECKININFO"));
				SingleCheckin.setCheckinmoney(rs.getString("CHECKINMONEY"));
				SingleCheckin.setCheckinnum(rs.getString("CHECKINNUM"));
				SingleCheckin.setCheckintime(rs.getString("CHECKINTIME"));
				SingleCheckin.setClientname(rs.getString("CLIENTNAME"));
				SingleCheckin.setDeparturetime(rs.getString("DEPARTURETIME"));;
				return SingleCheckin;
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
	
	

}
