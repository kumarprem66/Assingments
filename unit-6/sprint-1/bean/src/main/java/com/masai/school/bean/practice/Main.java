package com.masai.school.bean.practice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {


		ApplicationContext apc = new ClassPathXmlApplicationContext("applicationContext.xml");
		Travel tv = apc.getBean(Travel.class,"t");
		tv.journey();
		 
	}

}
