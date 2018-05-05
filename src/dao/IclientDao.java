package dao;

import java.util.List;

import com.sun.security.ntlm.Client;

import model.client;
import until.Pagination;

public interface IclientDao {
	  public List<client> getAllClient(Pagination pagination);
	    public client  getClient(String Cno);
	    public void insertClient(client cli);
	
	    public void  deleteClient(String Cno);
	    public void  updateClient(client client);
	    
	   public List<client> getSomeClient(String text);
	   
}
