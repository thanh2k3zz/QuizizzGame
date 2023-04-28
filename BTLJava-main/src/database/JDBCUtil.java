package database;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.DatabaseMetaData;
import com.mysql.cj.jdbc.Driver;

public class JDBCUtil {
	public static Connection getConnection() {
		Connection c = null;
		try {
			// Dki MySQL Driver voi DriverManager
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			
			// cac thong so
			String url = "jdbc:mysql://localhost:3306/quizgame";
			String username = "root";
			String password = "";
			
			// tao ket noi
			c = DriverManager.getConnection(url, username, password);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return c;
	}
	
	public static void closeConnection(Connection c) {
		try {
			if(c!=null) {
				c.close();
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void printInfo(Connection c) {
		try {
			if(c!=null) {
				DatabaseMetaData mtdt = (DatabaseMetaData) c.getMetaData();
				System.out.println(mtdt.getDatabaseProductName());
				System.out.println(mtdt.getDatabaseProductVersion());
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
}