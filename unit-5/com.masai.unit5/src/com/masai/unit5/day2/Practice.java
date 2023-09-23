package com.masai.unit5.day2;

import java.util.*;
import java.util.function.*;
//import java.util.function.Predicate;
public class Practice {

	
	
	public static void main(String[] args) {
		
		
//===============		predicate ///////////////////////////
		
//		list.removeIf(student -> student.getMarks()<400);
		
//		List<Student> list = new ArrayList<>();
//		
//		list.add(new Student(1,"prem",200));
//		list.add(new Student(1,"prem",300));
//		list.add(new Student(1,"prem",240));
//		list.add(new Student(1,"prem",250));
//		list.add(new Student(1,"prem",270));
//		list.add(new Student(1,"prem",350));
//		list.add(new Student(1,"prem",290));
//		list.add(new Student(1,"prem",400));
//		list.add(new Student(1,"prem",450));
//		list.add(new Student(1,"prem",500));
		

		
//		Consumer<Student> c = s -> System.out.println(s.getName() + " : " + (s.getMarks()>= 400?"Pass":"Fail"));
		
//		list.forEach(c);
		
		
//		System.out.println(list);
		
		
//		BiConsumer<Integer,String> bic = new BiConsumer<Integer, String>() {
//			
//			@Override
//			public void accept(Integer t, String u) {
//				// TODO Auto-generated method stub
//				System.out.println(t+" "+u);
//				
//			}
//		};
//		Map<Integer,String> map = new LinkedHashMap<>();
//		map.put(1, "Monday");
//		map.put(2, "Tuesday");
//		map.put(3, "Wednesday");
//		map.put(4, "Thrusday");
//		map.put(5, "friday");
//		map.put(6, "saturday");
//		
//		map.forEach((k,v)->{
//			System.out.println(k+" "+v);
//		});
//		map.forEach(bic);
		
		
//		Supplier<String> e = new Supplier<String>() {
//			
//			@Override
//			public String get() {
//				// TODO Auto-generated method stub
//				return "i love you";
//			}
//		};
		
//		Supplier<String> ex = () -> "All is well";
//		System.out.println(e.get());
		
		
		
//		Function<String, Integer> f1 = new Function<String, Integer>() {
//			
//			@Override
//			public Integer apply(String t) {
//				// TODO Auto-generated method stub
//				
//				return t.length();
//			}
//		};
		
//		Function<String, Set<Character>> f2 = new Function<String, Set<Character>>() {
//			
//			@Override
//			public Set<Character> apply(String name) {
//				// TODO Auto-generated method stub
//				 
//				Set<Character> set = new TreeSet<>();
//				for(char ch : name.toCharArray()) {
//					set.add(ch);
//				}
//				return set;
//			}
//		};
//		
		
		
		
//		
//		
//		Map<Integer,String> map = new LinkedHashMap<>();
//		map.put(1, "Monday");
//		map.put(2, "Tuesday");
//		map.put(3, "Wednesday");
//		
//		map.put(5, "friday");
//		map.put(6, "saturday");
//		
//		Function<Integer,String> f3 = dayNum -> {
//			
//			String dayName = null;
//			switch(dayNum) {
//			case 1:
//				dayName = "Mon";
//				break;
//			case 2:
//				dayName = "Tue";
//				break;
//			case 3:
//				dayName = "Wed";
//				break;
//			case 4:
//				dayName = "Thr";
//				break;
//			case 5:
//				dayName = "Fri";
//				break;
//			case 6:
//				dayName = "Sat";
//				break;
//			case 7:
//				dayName = "Sun";
//				break;
//			}
//			
//			return dayName;
//		};
//		
//		
//		System.out.println(map.computeIfAbsent(4, f3));
//		System.out.println(map);
//		
//		System.out.println(map.computeIfAbsent(1, f3));
//		System.out.println(map);
//		
//		System.out.println(map.computeIfAbsent(7, f3));
//		System.out.println(map);
//		
//		System.out.println(map.computeIfAbsent(8, f3));
//		System.out.println(map);
		
		
		

		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
