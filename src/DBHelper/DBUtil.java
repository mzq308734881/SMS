package DBHelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class DBUtil {
     Connection con=null;
     Statement sql=null;
		
	//连接数据库
	public  Connection ConnectDB() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		}
		try {
			con = DriverManager
					.getConnection(
							"jdbc:sqlserver://localhost:1433;DatabaseName=JavaClassDesign",
							"sa", "ming520");
			con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			if (con == null) {
				JOptionPane.showMessageDialog(null, "连接数据库失败");
			}
		} catch (SQLException ee) {
			JOptionPane.showMessageDialog(null, "ConnectDB连接异常：" + ee.getMessage());
		}
		return con;
	}
	
    //关闭数据库连接
	public void ConnectClose() {
		try {
			if (ConnectDB() != null)
				ConnectDB().close();
		} catch (SQLException e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "ConnectClose关闭异常：" + e.getMessage());
		}
	}	
}
