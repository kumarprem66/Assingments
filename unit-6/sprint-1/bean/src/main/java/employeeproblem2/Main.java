package employeeproblem2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		
		ApplicationContext apx = new ClassPathXmlApplicationContext("appContext.xml");
		Demo dem = apx.getBean("demo",Demo.class);
		dem.showDetails();
	}
}
