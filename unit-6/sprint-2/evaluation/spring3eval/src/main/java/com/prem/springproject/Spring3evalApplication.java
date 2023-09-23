package com.prem.springproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class Spring3evalApplication {

	public static void main(String[] args) {
		SpringApplication.run(Spring3evalApplication.class, args);
		
		System.out.println("hello prem kumar");
//		exclude = {DataSourceAutoConfiguration.class}

	}

}
