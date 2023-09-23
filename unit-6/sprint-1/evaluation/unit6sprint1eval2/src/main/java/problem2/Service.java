package problem2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Service implements Database {
	
	 String URL;
	 String USER ;
	 String PASS ;
	
	
	

	public Service(String uRL, String uSER, String pASS) {
		super();
		URL = uRL;
		USER = uSER;
		PASS = pASS;
	}

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");				
		}catch(ClassNotFoundException ex) {
			System.exit(1);
		}
	}
	
	public Connection makeConnection() throws SQLException{
		return DriverManager.getConnection(URL, USER, PASS);
	}
	

	
	
	@Override
	public void getConnection() {
		try {
			makeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	@Override
	public void create() {
		
		System.out.println("data inserted");
	}

	@Override
	public void read() {
		System.out.println("data read");
		
	}

	@Override
	public void update() {
		System.out.println("data updated");
		
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		System.out.println("data deleted");
		
	}

}
