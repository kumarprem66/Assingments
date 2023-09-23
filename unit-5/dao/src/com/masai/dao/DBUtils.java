package com.masai.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DBUtils {

	static String URL,user,password;
	
	static {
		
		try {
			
//			registering the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
//			make the connection with database
			
//			i am using .properties file to read the database related info using RESOURSEBUNDLE CLASS
			
			ResourceBundle rb = ResourceBundle.getBundle("db");
			
			URL = rb.getString("URL");
			user = rb.getString("USER");
			password = rb.getString("PASS");
			
		}catch(ClassNotFoundException ex) {
			System.out.println("Driver didn't registered");
			System.exit(1);
		}
	}
	
	
	
	static Connection getConnection() throws SQLException{
		
//		return the connection
		return DriverManager.getConnection(URL,user,password);
	}
	
	
	static void closeConnection(Connection connection) throws SQLException {
		
//		close the connection
		if(connection != null) {
			connection.close();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

