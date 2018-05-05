package until;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 封装数据库连接对象方法和关闭数据库连接对象方法
 */
public class DataBaseBean {
    public static Connection getConnection() {
        Connection conn = null;
        String driver = "oracle.jdbc.driver.OracleDriver";
        String url="jdbc:oracle:thin:@(description=(address=(protocol=tcp)(port=1521)(host=localhost)(PORT = 1521))(connect_data=(SERVER = DEDICATED)(service_name=XE)))";
        String username = "Chao";
        String password = "123456";
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DataBaseBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }

    public static void close(ResultSet rs, Statement stmt, Connection conn) {

        try {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseBean.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
