package annotationAppraoch2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	
	public static void main(String[] args) {

		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		
		A obj = ctx.getBean("amar",A.class);
		
		obj.funA();
		
		obj.getCities();
	}
}
