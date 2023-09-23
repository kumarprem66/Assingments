package annotationApproach;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	
	public static void main(String[] args) {
		
//		ApplicationContext apx = new ClassPathXmlApplicationContext("applicationContext.xml");
//		A obj = apx.getBean("a",A.class);
//		obj.fun1();
		
		
//		using class instead of xml file
		
		ApplicationContext apx = new AnnotationConfigApplicationContext(AppConfig.class);
		A obj = apx.getBean("a",A.class);
		obj.fun1();

		
	}
}
