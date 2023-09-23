package autowiring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		ApplicationContext apx = new ClassPathXmlApplicationContext("applicationContext.xml");
		Customer cus = apx.getBean("customer",Customer.class);
		cus.displayOrder();
	}
}
