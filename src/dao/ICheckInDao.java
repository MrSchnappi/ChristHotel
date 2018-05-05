package dao;
import java.util.List;

import model.checkin;
import until.Pagination;

public interface ICheckInDao {
	public List<checkin> getAllCheckIn(Pagination pagination);
    public void updateCheckInByRoomID(checkin checkin ); 
    public void insertCheckin(checkin checkin);
    public void  deleteCheckin(String ROOMID,String  CLIENTID);
    public  checkin  getCheckinByRno(String Rno);
    public  checkin  getCheckinByCno(String Cno);
}
