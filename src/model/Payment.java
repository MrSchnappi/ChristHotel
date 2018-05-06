package model;

public class Payment {
	String  Cno;
	public String getCno() {
		return Cno;
	}
	public void setCno(String cno) {
		Cno = cno;
	}
	public String getRno() {
		return Rno;
	}
	public void setRno(String rno) {
		Rno = rno;
	}
	String  Rno;
	int days;
	float untilPrice;
	float pay;
	float money;//押金
	public float getMoney() {
	return money;
	}
	public void setMoney(float money) {
		this.money = money;
	}
	public Payment(int days ,float untilPrice,	float pay,float money,String Cno,String Rno) {
		this.days=days;
		this.untilPrice=untilPrice;
		this.money = money;
		this.pay=pay;
		this.Cno=Cno;
		this.Rno=Rno;
	}
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
	}
	public float getUntilPrice() {
		return untilPrice;
	}
	public void setUntilPrice(float untilPrice) {
		this.untilPrice = untilPrice;
	}
	public float getPay() {
		return pay;
	}
	public void setPay(float pay) {
		this.pay = pay;
	}

}
