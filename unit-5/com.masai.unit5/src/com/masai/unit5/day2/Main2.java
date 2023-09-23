package com.masai.unit5.day2;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Function;

public class Main2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		

		List<Student> list = new ArrayList<>();
		
		Scanner sc = new Scanner(System.in);
		
		
		
		try {
			int i = 10;
			do {
				System.out.println("Enter roll no");
				int roll = sc.nextInt();
				System.out.println("Enter name");
				String name = sc.next();
				System.out.println("Enter marks");
				int marks = sc.nextInt();
				list.add(new Student(roll,name,marks));
				i--;
			}while(i >0);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
//		list.add(new Student(1,"prem",100));
//		list.add(new Student(1,"prem",140));
//		list.add(new Student(1,"prem",240));
//		list.add(new Student(1,"prem",250));
//		list.add(new Student(1,"prem",270));
//		list.add(new Student(1,"prem",350));
//		list.add(new Student(1,"prem",290));
//		list.add(new Student(1,"prem",400));
//		list.add(new Student(1,"prem",450));
//		list.add(new Student(1,"prem",500));
//		
		
		Function<List<Student>,Map<String,List<Student>>> students = new Function<>() {

			@Override
			public Map<String, List<Student>> apply(List<Student> list) {
				// TODO Auto-generated method stub
				Map<String, List<Student>> map = new LinkedHashMap<>();
				List<Student> f = new ArrayList<>();
				List<Student> p = new ArrayList<>();
				List<Student> t = new ArrayList<>();
				for(Student s : list) {
					if(s.getMarks()<165) {
						f.add(s);
						map.put("Fail", f);
					}else if(s.getMarks()<400 && s.getMarks()>=165) {
						p.add(s);
						map.put("Pass", p);
					}else {
						t.add(s);
						map.put("Topper", t);
					}
				}
				
				return map;
			}

		
			
		};
		
		
		Map<String, List<Student>> map = students.apply(list);
		map.forEach(new BiConsumer<String, List<Student>>() {

			@Override
			public void accept(String t, List<Student> u) {
				// TODO Auto-generated method stub
				System.out.println(u + "  "+ t);
				
			}
		});
		
	
		
		
		
	}

}
