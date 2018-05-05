package test;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * JDBC测试类
 *
 * @author Administrator
 */
public class JDBCTest {

    //JDBC操作
    public static void main(String[] args) {
        Connection conn;//数据库连接对象
        PreparedStatement psmt;//预编译的语句对象
        ResultSet rs;//结果集

        String driver = "oracle.jdbc.driver.OracleDriver";
       // String url = "jdbc:oracle:thin:@localhost:1521:orcl";
        String url="jdbc:oracle:thin:@(description=(address=(protocol=tcp)(port=1521)(host=localhost)(PORT = 1521))(connect_data=(SERVER = DEDICATED)(service_name=XE)))";
        String username = "Chao";
        String password = "123456";
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
           psmt = conn.prepareStatement("select * from worker where WORKERID=?");
            psmt.setString(1, "1");
           rs = psmt.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("WORKER_NAME"));
      //          System.out.println(rs.getString("sname"));
     //           System.out.println(rs.getString("ssex"));
        //        System.out.println(rs.getInt("sage"));
            }
            rs.close();
            psmt.close();
            conn.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JDBCTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(JDBCTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        //课程
     //    try {
      //      Class.forName(driver);
     //       conn = DriverManager.getConnection(url, username, passwrod);
    //        psmt = conn.prepareStatement("select * from course where cno=?");
    //        psmt.setString(1, "0101");
    //        rs = psmt.executeQuery();
    //        while (rs.next()) {
       //         System.out.println(rs.getString("cno"));
       //         System.out.println(rs.getString("cname"));
        //        System.out.println(rs.getString("teacher"));
               
      //      }
    //        rs.close();
    //        psmt.close();
    //        conn.close();
    //    } catch (ClassNotFoundException ex) {
    //        Logger.getLogger(JDBCTest.class.getName()).log(Level.SEVERE, null, ex);
    //    } catch (SQLException ex) {
   //         Logger.getLogger(JDBCTest.class.getName()).log(Level.SEVERE, null, ex);
   //     }
         
         
   //      try {
  // //         Class.forName(driver);
   //         conn = DriverManager.getConnection(url, username, passwrod);
   //         psmt = conn.prepareStatement("select * from score where sno=? and cno=?");
     //       System.out.println("psmt "+psmt);
   //         psmt.setString(1, "9512101");
     //       psmt.setString(2, "0101");
   //         rs = psmt.executeQuery();
    //        while (rs.next()) {
    //            System.out.println(rs.getString("sno"));
     //           System.out.println(rs.getString("cno"));
     //           System.out.println(rs.getString("score"));
               
    //        }
     //       rs.close();
     //       psmt.close();
    //        conn.close();
   //     } catch (ClassNotFoundException ex) {
    //        Logger.getLogger(JDBCTest.class.getName()).log(Level.SEVERE, null, ex);
    //    } catch (SQLException ex) {
     //       Logger.getLogger(JDBCTest.class.getName()).log(Level.SEVERE, null, ex);
   ///     }  


    }

}
