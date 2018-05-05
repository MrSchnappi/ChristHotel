package model;

public class client {
	int clientid; 
	String  clientno; 
	String  clienttype;
	String clientname;
	String clientphone;
	String  clientinfo;
	public client()
	{
		
	}
	public  client (int clientid,String clientno,String clienttype,String clientname,String clientphone,String clientinfo)
	{
		this.clientid=clientid; 
		this.clientinfo=clientinfo;
		this.clientname=clientname;
		this.clientno=clientno; 
		this.clientphone=clientphone; 
		this.clienttype=clienttype;
	}

	public int getClientid() {
		return clientid;
	}

	public void setClientid(int clientid) {
		this.clientid = clientid;
	}

	public String getClientno() {
		return clientno;
	}

	public void setClientno(String clientno) {
		this.clientno = clientno;
	}

	public String getClienttype() {
		return clienttype;
	}
	

	public void setClienttype(String clienttype) {
		this.clienttype = clienttype;
	}

	public String getClientname() {
		return clientname;
	}

	public void setClientname(String clientname) {
		this.clientname = clientname;
	}

	public String getClientphone() {
		return clientphone;
	}

	public void setClientphone(String clientphone) {
		this.clientphone = clientphone;
	}

	public String getClientinfo() {
		return clientinfo;
	}

	public void setClientinfo(String clientinfo) {
		this.clientinfo = clientinfo;
	}
}
