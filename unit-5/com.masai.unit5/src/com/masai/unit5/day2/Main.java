package com.masai.unit5.day2;

import java.util.*;
import java.util.function.Consumer;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
//		Consumer<String> c = (t)->{
//			System.out.println(t);
//		};
		
		PrintList pt =  (city)-> {
				
			city.forEach( c -> {System.out.println(c);});
				
		};
		
//		Consumer<String> c = new Consumer<>() {
//
//			@Override
//			public void accept(String t) {
//				// TODO Auto-generated method stub
//				
//				
//			}
//			
//		};
	
		
		
		List<String> city = new ArrayList<>();
		city.add("jehanabad");
		city.add("patna");
		city.add("gaya");
		city.add("bihata");
		city.add("muzz");
		
		
		pt.display(city);

	}

}
