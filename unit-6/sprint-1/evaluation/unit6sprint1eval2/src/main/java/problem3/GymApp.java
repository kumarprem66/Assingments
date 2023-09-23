package problem3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GymApp {


	public static void main(String[] args) {

		ApplicationContext apc = new ClassPathXmlApplicationContext("applicationContext.xml");
		GymManager dl  = (GymManager)apc.getBean(GymManager.class,"dls");
		dl.displayDetail();
	}
 
}