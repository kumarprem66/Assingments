package com.masai.unit5.day2;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class PredicateConsumerDemo {

	public static void displayCountryList(List<Country> list) {

		
		Consumer<Country> c = new Consumer<>() {

			@Override
			public void accept(Country t) {
				// TODO Auto-generated method stub
				
				System.out.println(t.getCountryName()+" from the "+t.getContinentName()+ " is of "+t.getArea()+" square KM");
				
				
			}
			
		};
		
		list.forEach(c);
	}
	
	public static List<Country> filterCountry(List<Country> list, Predicate<Country> filterByArea){
		
		List<Country> countryList = list;
		countryList.removeIf(filterByArea);
		
	
		return countryList;
		
		
	}
}
