package circularBean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.masai.school.bean.practice.Travel;

public class Main2 {

	
	public static void main(String[] args) {
		
		ApplicationContext apc = new ClassPathXmlApplicationContext("applicationContext.xml");
		B b1 = apc.getBean(B.class,"bc");
		b1.showB();
	}
}
