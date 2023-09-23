package com.example.demo;
import problem1.*;
import problem2.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CouplingApplication {

	public static void main(String[] args) {
		SpringApplication.run(CouplingApplication.class, args);
		System.out.println("hello world");
		
//		///////////////////////    problem -1       //////////////////
		
//		tightly coupled
//		GmailUser gut = new GmailUser();
		
		
//		loosely coupled
		
//		GmailUser gu = new GmailUser(new EmailOrganiser());
//		gu.sendEmails();
//		gu.readEmails();
//		gu.organiseEmails();
		
		
//		////////////////////////////   problem-2        ////////////////
		
//		 loosely coupled 
		UberDriver ud = new UberDriver(new UberX());
		ud.drive();
		
	}

}
