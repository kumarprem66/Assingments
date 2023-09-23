package com.example.demo;

import org.springframework.stereotype.Controller;

@Controller
public class A {

	@RequestMapping("/hello")
	public String funa() {
		return "prem kumar";
	}
	
	
}
