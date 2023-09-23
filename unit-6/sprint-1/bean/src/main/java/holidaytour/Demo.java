package holidaytour;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo {

	public static void main(String[] args) {
		
		
		ApplicationContext apx = new ClassPathXmlApplicationContext("appContext.xml");
		HolidayPackage hp = apx.getBean("holiday",HolidayPackage.class);
		hp.showDetails();
	}
}
