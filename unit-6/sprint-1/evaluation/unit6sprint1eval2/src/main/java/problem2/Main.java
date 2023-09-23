package problem2;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	
	public static void main(String[] args) {
		ApplicationContext apc = new ClassPathXmlApplicationContext("applicationContext.xml");
		Service dl  = (Service)apc.getBean(Service.class,"dls");
		try {
			Connection conn = dl.makeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		dl.read();
		dl.update();
	}
	
	
	
}
