package valueAnno;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	
	
	public static void main(String[] args) {
		
		
		ApplicationContext apx = new AnnotationConfigApplicationContext(AppConfig.class);
		
		A a = apx.getBean("a",A.class);
		B b = apx.getBean("b",B.class);
		C c = apx.getBean("c",C.class);
//		b.funb();
//		a.funA();
		c.funC();
		
	}
}
