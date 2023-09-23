package gPay;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main3 {

	public static void main(String[] args) {
		
		ApplicationContext apx = new ClassPathXmlApplicationContext("applicationContext.xml");
		PaymentPresentation pp2 = apx.getBean("pp",PaymentPresentation.class);
		pp2.presentTransactionDetails();
		
//		
//		<bean id="pp" class="gPay.PaymentPresentation">
//		<property name="transactionService" ref="tid"></property>
//	</bean>
//	
//	<bean id="aid" class="gPay.AccountDetailsDao"/>
//	
//	
//	<bean id="tid" class="gPay.TransactionService">
//		<property name="accountDetailsDao" ref="aid"></property>
//	</bean>
	}
}
