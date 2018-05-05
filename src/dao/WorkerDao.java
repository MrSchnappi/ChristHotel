package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.client;
import model.worker;
import until.DataBaseBean;
import until.Pagination;

public class WorkerDao implements IWorkerDao {
	   Connection conn = null;
	   PreparedStatement psmt = null;
	   ResultSet rs = null;
	@Override
	public List<worker> getAllWorker(Pagination pagination) {
		// TODO Auto-generated method stub
		 List<worker> workers = new ArrayList<worker>();
	        try {
	            conn = DataBaseBean.getConnection();
	            psmt = conn.prepareStatement("select count(*) as counts from WORKER");
	            rs = psmt.executeQuery();
	            rs.next();
	            //求总记录数
	            pagination.setCountSize(rs.getInt("counts"));
	            int start = (pagination.getPageNo() - 1) * pagination.getPageSize() + 1;//开始位置
	            int end = pagination.getPageNo() * pagination.getPageSize();//结束位置
	            psmt = conn.prepareStatement("SELECT * FROM (SELECT ROWNUM NO , s.* FROM (SELECT * FROM WORKER ORDER BY sno ASC) s WHERE ROWNUM<=?) WHERE NO>=?");

	            psmt.setInt(1, end);
	            psmt.setInt(2, start);
	            rs = psmt.executeQuery();
	            while (rs.next()) {
	            	worker SingleWorker = new worker();
					SingleWorker.setWorkerid(rs.getString("WORKERID"));//编号
					SingleWorker.setWorker_name(rs.getString("WORKER_NAME"));
					SingleWorker.setWorker_gender(rs.getString("WORK_GENDER"));;
					SingleWorker.setWorker_age(rs.getString("WORKWE_AGE"));
					SingleWorker.setWorkerpwd(rs.getString("WORKPWD"));
				    workers.add(SingleWorker);
	            }
	        } catch (SQLException e) {
	        	e.printStackTrace();
	        } finally {
	            DataBaseBean.close(rs, psmt, conn);
	        }
	        return workers;

	}
	@Override
	public void insertWorker(worker worker) {
		// TODO Auto-generated method stub
		  conn = DataBaseBean.getConnection();
          try {
		  psmt = conn.prepareStatement("INSERT INTO WORKER VALUES (?,?,?,?,?)");
          psmt.setInt(1, Integer.parseInt(worker.getWorkerid()));
          psmt.setString(2, worker.getWorker_name());
          psmt.setString(3, worker.getWorker_gender());
          psmt.setString(4, worker.getWorker_age());
          psmt.setString(5, worker.getWorkerpwd());
          psmt.executeUpdate();
  	} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				DataBaseBean.close(rs, psmt, conn);
			}

	}

	@Override
	public void deleteWorker(String wno) {
		// TODO Auto-generated method stub
		conn = DataBaseBean.getConnection();
		try {
				psmt=conn.prepareStatement("DELETE FROM WORKER WHERE WORKERID=?");	
				psmt.setInt(1, Integer.parseInt(wno));
				psmt.executeQuery();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					DataBaseBean.close(rs, psmt, conn);
				}	
	}

	@Override
	public void updateWorker(worker people) {
		// TODO Auto-generated method stub
		conn = DataBaseBean.getConnection();
        try {
		psmt = conn.prepareStatement("UPDATE WORKER SET WORKER_NAME=?,WORK_GENDER=?,WORKWE_AGE=?,WORKPWD=? WHERE WORKERID=? ");
        psmt.setString(1, people.getWorker_name());        
        psmt.setString(2,people.getWorker_gender());
        psmt.setString(3,people.getWorker_age());     
        psmt.setString(4,people.getWorkerpwd());
        psmt.setInt(5, Integer.parseInt(people.getWorkerid()));
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
	public worker getWorker(String wno) {
		// TODO Auto-generated method stub
		conn = DataBaseBean.getConnection();
		try {
			psmt=conn.prepareStatement("SELECT * FROM WORKER WHERE WORKERID=?");
			psmt.setString(1, wno);
			rs=psmt.executeQuery();
			if(rs.next())
			{
				worker SingleWorker = new worker();
				SingleWorker.setWorkerid(rs.getString("WORKERID"));//编号
				SingleWorker.setWorker_name(rs.getString("WORKER_NAME"));
				SingleWorker.setWorker_gender(rs.getString("WORK_GENDER"));;
				SingleWorker.setWorker_age(rs.getString("WORKWE_AGE"));
				SingleWorker.setWorkerpwd(rs.getString("WORKPWD"));
				return SingleWorker;
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
