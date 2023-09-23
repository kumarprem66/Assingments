package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringAppApplication {

	public static void main(String[] args) {
		ApplicationContext apx = SpringApplication.run(SpringAppApplication.class, args);
		A a = apx.getBean(A.class);
		a.funa();
		
	}

}
