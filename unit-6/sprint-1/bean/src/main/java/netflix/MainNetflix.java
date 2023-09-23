package netflix;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainNetflix {

	public static void main(String[] args) {
		ApplicationContext apx = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService use = (UserService)apx.getBean(UserService.class,"userser");
		use.userlogin("prem");
		use.getReccomendaedService();
	}
}
