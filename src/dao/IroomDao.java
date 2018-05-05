package dao;

import java.util.List;

import model.room;
import until.Pagination;

public interface IroomDao {
	public room getroombyRno(String rno);//按照房间号查询
	public List<room> getroombystate(String state);//按照房间状态查询
	public void insertroom(room house);//添加房间
	public void deleteroom(String room);//删除房间
	public void updateroom(room room);//修改房间
	public void updateroomState(int Rno,String State);
	public List<room>getAllroom(Pagination pagination);//按规格显示房间
}
