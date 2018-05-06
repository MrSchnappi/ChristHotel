package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Payment;
import until.DaoFactory;
import until.DataBaseBean;

public class PaymentDao implements IPayment {
	 Connection conn = null;
	   PreparedStatement psmt = null;
	   ResultSet rs = null;
	@Override
	public void insertPayment(Payment payment) {
		// TODO Auto-generated method stub
			conn = DataBaseBean.getConnection();
			try {
				psmt = conn.prepareStatement("INSERT INTO PAYMENT(CLIENTid,ROOMid,DAYS,UNTILPRICE,PAY,MONEY) VALUES (?,?,?,?,?,?)");
				psmt.setInt(1, Integer.parseInt(payment.getCno()));
				psmt.setInt(2, Integer.parseInt(payment.getRno()));
				psmt.setInt(3,payment.getDays());
				psmt.setFloat(4, payment.getUntilPrice());
				psmt.setFloat(5, payment.getPay());
				psmt.setFloat(6, payment.getMoney());
				rs=psmt.executeQuery();				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
