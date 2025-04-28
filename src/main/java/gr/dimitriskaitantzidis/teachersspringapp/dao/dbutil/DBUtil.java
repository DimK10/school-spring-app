package gr.dimitriskaitantzidis.teachersspringapp.dao.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	
	private static Connection conn;
	
	/*
	 *  No instances will be available
	 */
	private DBUtil() {}
	
	public static Connection openConnection() throws SQLException  {
		String url = "jdbc:mysql://localhost:3306/teachers?useSSL=false";
		String username = "thanos2";
		String password = "Thanos12";
		
		conn =  DriverManager.getConnection(url, username, password);
		
		return conn;
	}
	
	public static void closeConnection() throws SQLException {
		conn.close();
	}
}
