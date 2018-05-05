package model;

public class room {
	String  Rno;
	String  Rtype;
	String Rprice; 
	String Rstate;
	public room() {
		// TODO Auto-generated constructor stub
	}
	public String getRno() {
		return Rno;
	}

	public void setRno(String rno) {
		Rno = rno;
	}

	public String getRtype() {
		return Rtype;
	}

	public void setRtype(String rtype) {
		Rtype = rtype;
	}

	public String getRprice() {
		return Rprice;
	}

	public void setRprice(String rprice) {
		Rprice = rprice;
	}

	public String getRstate() {
		return Rstate;
	}

	public void setRstate(String rstate) {
		Rstate = rstate;
	}


	
	public room(String Rno,String Rtype,String Rprice,String Rstate)
	{
		this.Rno=Rno;
		this.Rprice=Rprice;
		this.Rstate=Rstate; 
		this.Rtype=Rtype;
	}

	
	

}
