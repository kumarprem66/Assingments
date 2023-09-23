package constructorAuto;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {

	
	public static void main(String[] args) {
		
		
		ApplicationContext apx = new ClassPathXmlApplicationContext("appContext.xml");
		Demo cus = apx.getBean("d1",Demo.class);
		cus.showDetails();
		
		ClassPathXmlApplicationContext ctx = (ClassPathXmlApplicationContext)apx;
		ctx.close();
		
		
	}
}


