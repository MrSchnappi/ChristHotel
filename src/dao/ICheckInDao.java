package dao;
import java.util.List;

import model.Payment;
import model.checkin;

import until.Pagination;

public interface ICheckInDao {
	public List<checkin> getAllCheckIn(Pagination pagination);
    public void updateCheckInByRoomID(checkin checkin ); 
    public void insertCheckin(checkin checkin);
    public void  deleteCheckin(String ROOMID,String  CLIENTID);
    public  checkin  getCheckinByRno(String Rno);
    public  checkin  getCheckinByCno(String Cno);
    public   void    updateCheckInDay(String Rno,String Cno,String day);
    public   Payment    SumMoney(String ROOMID,String  CLIENTID );
}
