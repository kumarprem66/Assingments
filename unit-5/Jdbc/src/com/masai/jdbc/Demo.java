package com.masai.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;




public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String name = "root";
			String pass = "premk";
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/day6",name,pass);
			System.out.println("connection established");
//			Statement st = con.createStatement();
//			ResultSet rs = st.executeQuery("Select * from st");
//			
//			while(rs.next()) {
//				System.out.println("Name- "+rs.getString(0));
//			}
		
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	

	}

}
