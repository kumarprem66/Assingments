package Day1;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
	
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");				
		}catch(ClassNotFoundException ex) {
			System.exit(1);
		}
	}
	
	final static String URL = "jdbc:mysql://localhost:3306/sprint3_day1";
	final static String USER = "root";
	final static String PASS = "premk";
	
	static Connection makeConnection() throws SQLException{
		return DriverManager.getConnection(URL, USER, PASS);
	}

	static void closeConnection(Connection connection) throws SQLException{
		if(connection != null)
			connection.close();
	}
	

	static void insertMobile(Scanner sc) {
		try {
			Connection connection = makeConnection();
			System.out.print("Enter Model number ");
			String modelNo = sc.next();
			
			System.out.print("Enter Company ");
			String company = sc.next();
			System.out.print("Enter Price ");
			int price = sc.nextInt();
			System.out.print("Enter MFG date ");
			LocalDate mfgDate = LocalDate.parse(sc.next());
			
			String insertQuery = "INSERT INTO mobile (modelNo,company,price,mfgDate) VALUES(?,?,?,?)";
			
			PreparedStatement ps = connection.prepareStatement(insertQuery);
			ps.setString(1, modelNo);
			ps.setString(2, company);
			ps.setDouble(3, price);
			ps.setDate(4, Date.valueOf(mfgDate));
			
			if(ps.executeUpdate() > 0) {
				System.out.println("Mobile added successfully");
			}else {
				System.out.println("No Mobile Added");
			}
			
			closeConnection(connection);
		}catch(SQLException e) {
			System.out.println(e);
		}
	}
	
	static void updateMobile(Scanner sc) {
		try {
			Connection connection = makeConnection();
			System.out.print("Enter Model number ");
			String modelNo = sc.next();
			
			System.out.print("Enter Company ");
			String company = sc.next();
			System.out.print("Enter Price ");
			int price = sc.nextInt();
			System.out.print("Enter MFG date ");
			LocalDate mfgDate = LocalDate.parse(sc.next());
			
			String updateQuery = "UPDATE mobile SET company = ?,price = ?,mfgDate = ? where modelNo = ?";
			
			PreparedStatement ps = connection.prepareStatement(updateQuery);
			ps.setString(1, modelNo);
			ps.setString(2, company);
			ps.setDouble(3, price);
			ps.setDate(4, Date.valueOf(mfgDate));
			
			if(ps.executeUpdate() > 0) {
				System.out.println("Mobile Updated successfully");
			}else {
				System.out.println("No Mobile updated");
			}
			
			closeConnection(connection);
		}catch(SQLException e) {
			System.out.println(e);
		}
	}
	
	
	static void deleteMobile(Scanner sc) {
		try {
			Connection connection = makeConnection();
			System.out.print("Enter Model number ");
			String modelNo = sc.next();
			
			
			String deleteQuery = "DELETE FROM mobile where modelNo = ?";
			
			PreparedStatement ps = connection.prepareStatement(deleteQuery);
			ps.setString(1, modelNo);
		
			if(ps.executeUpdate() > 0) {
				System.out.println("Mobile Deleted successfully");
			}else {
				System.out.println("No Mobile deleted");
			}
			
			closeConnection(connection);
		}catch(SQLException e) {
			System.out.println(e);
		}
	}
	
	static void viewmobiles() {
		try {
			
			Connection conn = makeConnection();
		
			String viewQuery = "SELECT * FROM mobile";
			PreparedStatement ps = conn.prepareStatement(viewQuery);
			ResultSet resultset = ps.executeQuery();
			resultset.isBeforeFirst();
			resultset.getRow();
			if(!resultset.isBeforeFirst() && resultset.getRow()==0) {
				
				System.out.println("No data available");
			}else {
				while(resultset.next()) {
					String model = resultset.getString(2);
					String company = resultset.getString(2);
					int price = resultset.getInt(4);
					LocalDate local  = resultset.getDate(5).toLocalDate();
					
					System.out.println(model + ": " + company + ": " + price + ": " + local);	
				}
				
			}
			
			closeConnection(conn);
			
			
		}catch(SQLException ex) {
			System.out.println(ex);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
	}

}
