package com.masaischool.first_maven_project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DBUtils {

	
	static String URL,USER,PASS;
	
	
	static {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			ResourceBundle rb = ResourceBundle.getBundle("databasecourt");
			URL = rb.getString("URL");
			USER = rb.getString("USER");
			PASS = rb.getString("PASS");
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			
			System.out.println("driver didn't register");
			System.exit(1);
		}
	}
	
	public static Connection makeConnection() throws SQLException {
		
		return DriverManager.getConnection(URL,USER,PASS);
	}
	
	public static void closeConnection(Connection conn) throws SQLException {
		
		if(conn != null) {
			conn.close();
		}
	}
	
}
