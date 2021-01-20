package util;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class JDBCConnection {
	
	/*Maintain and observe a single connection 
	 * Object with in this class. If no connection exists,
	 * we will create one. If a connection does exist, 
	 * make a new one and return it. 
	 */
	
	private static Connection conn = null;
	
	public static Connection getConnection() {
		
		try {
			
			if(conn == null) {
				
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
				Properties props = new Properties();
//				FileInputStream input = new FileInputStream(new File("/scr/main/resources/connection.properties"));
				FileInputStream input = new FileInputStream(JDBCConnection.class.getClassLoader().getResource("connection.properties").getFile());
				props.load(input);
				
				String url = props.getProperty("url");
				String username = props.getProperty("username");
				String password = props.getProperty("password");
				
				conn = DriverManager.getConnection(url, username, password);
				
				return conn;
			} else {
				return conn;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	/*
	 * This is for testing only, not needed to use JDBC
	 */
	
	public static void main(String[] args) {
		
		System.out.println("main reached");
		Connection conn1 = getConnection();
		System.out.println(conn1);
	}

}
