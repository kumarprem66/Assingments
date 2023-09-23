package zomato;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ZomatoMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext apc = new ClassPathXmlApplicationContext("applicationContext.xml");
		DeliveryService dl  = (DeliveryService)apc.getBean(DeliveryService.class,"dls");
		dl.deliveryMade();
//		
		
	
		
		int a = 5;
		int b = 6;
		System.out.println(a+b + " = "+a+b);
		
		
	}

}
