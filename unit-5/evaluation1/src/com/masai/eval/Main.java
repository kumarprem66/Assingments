

package com.masai.eval;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		
//		problem 1 /////////////////
		
		List<Integer> inlist = Arrays.asList(1,-2,3,4,-5,6);
		List<Double> dlist = Arrays.asList(1.1,-2.3,-3.4,4.2,-5.0,6.0);
		
		List<? super Number> list = new ArrayList<>();
		findNegativeOnly(inlist,dlist,list);
		System.out.println();
		
		
		
		
//		///////preobem 2 /////
		
		StuInter st = (detail)->{
			
			String[] s = detail.split(",");
			Student stu = new Student(Integer.valueOf(s[0]),s[1],s[2],Double.valueOf(s[3]));
			return stu;
		};
		
	
		Student s1 = st.givedetail("1,prem,math,64");
		Student s2 = st.givedetail("2,kumar,math,54");
		Student s3 = st.givedetail("3,kunal,science,74");
		Student s4 = st.givedetail("4,naushed,math,94");
		Student s5 = st.givedetail("5,amar,py=hysics,34");
		List<Student> students = new ArrayList<>();
		students.add(s1);
		students.add(s2);
		students.add(s3);
		students.add(s4);
		students.add(s5);
		
		Consumer<Student> c = t -> {
				
				System.out.println(t.getName() +" has scored "+t.getMarks() +" in "+t.getSubject());
				
			};
			
		students.forEach(c);
		
		
		Predicate<Student> p = t-> t.getMarks()>90;
		Consumer<Student> c2 = t -> {
			
			
			System.out.println(p.test(t));
			
		};
		students.forEach(c2);
		
		
		Supplier<Integer> supplier = ()->(int) Math.random()*5;
		
		int index = supplier.get();
		System.out.println(students.get(index));
		
		
		
//		 map is not working in ste /////////////////////////////////////////////////////////////
		
		
	
		
		
//		Function<List<Student>,HashMap<String,String>> fun = new Function<List<Student>,HashMap<String,String>>(){
//
//			@Override
//			public HashMap<String, String> apply(List<Student> t) {
//				// TODO Auto-generated method stub
//				HashMap<String,String> map = new HashMap<>();
//				
//				for(int i=0;i<t.size();i++) {
//					map.put(t.get(i).getSubject(), t.get(i).getName());
//				}
//				return map;
//			}
//			
//		};
//			
//		
//		HashMap<String, String> map = fun.apply(students);
			
	
		
		StudentInter stuInter = new StudentInter() {
			
			@Override
			public void isAvail(List<Student> list, int roll) {
				// TODO Auto-generated method stub
				
				
				boolean b = list.stream().anyMatch(p->p.getRollNo()==roll);
				if(b) {
					System.out.println("Student found");
				}else {
					System.out.println("Student not found");
				}
				
			}
			
			@Override
			public void giveSorted(List<Student> list) {
				// TODO Auto-generated method stub
				
				Collections.sort(list,new Comparator<Student>() {

					@Override
					public int compare(Student a, Student b) {
						// TODO Auto-generated method stub
						if(a.getMarks()>b.getMarks()) {
							return -1;
						}else if(a.getMarks()>b.getMarks()) {
							return 1;
						}else {
							if(b.getName().compareTo(a.getName()) == 0) {
								return b.getRollNo()-a.getRollNo();
							}else {
								return b.getName().compareTo(a.getName());
							}
						}
						
					}
					
				});
				System.out.println(list);
			}
		};
		
		
		stuInter.giveSorted(students);
		stuInter.isAvail(students, 3);
		
		
//		///////////////////////////////  problem 3 ///////////////////////////////////////
		
		
		firstin fi = Student::new;
		Student sut = fi.getObj(23, "prem", "math", 343);
		
		secondin se = sut::toString;
		System.out.println(se.getDetail());
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
		
//		///////////////////////////////  problem 4 ///////////////////////////////////////
		
		List<Data> dataList = new ArrayList<>();
		dataList.add(new Data(1,1.2f,"prem"));
		dataList.add(new Data(2,1.2f,"prem"));
		dataList.add(new Data(1,4.2f,"kumar"));
		dataList.add(new Data(3,3.2f,"prem"));
		dataList.add(new Data(1,2.2f,"ajay"));
		dataList.add(new Data(4,5.2f,"prem"));
		dataList.add(new Data(1,6.2f,"rinku"));
		dataList.add(new Data(5,7.2f,"prem"));
		dataList.add(new Data(5,8.2f,"ranjan"));
		dataList.add(new Data(6,9.2f,"prem"));
		
		
		boolean isprime = dataList.stream().anyMatch(new Predicate<Data>() {

			@Override
			public boolean test(Data t) {
				// TODO Auto-generated method stub
				int count = 0;
				for(int i=2;i<Math.sqrt(t.getIntVar());i++) {
					if(t.getIntVar()%i==0) {
						count++;
					}
				}
				if(count==0) {
					return true;
				}
				return false;
			}
			
		});
			
		if(isprime) {
			System.out.println("One or more elements is prime");
		}else {
			System.out.println("No elements is prime");
		}
		
		List<String> dis = dataList.stream().map(t->t.getStringVar()).toList();
		
		
		List<String> distinct = dis.stream().distinct().toList();
		distinct.forEach(d->{
			System.out.println(d);
		});
		
			
		dataList.stream().sorted((a,b)->(int)(a.getFloatVar()-b.getFloatVar())).skip(2);
		
		double avg = dataList.stream().collect(Collectors.averagingDouble(v->v.getFloatVar()));
		System.out.println(avg);
		
		int sum = dataList.stream().collect(Collectors.summingInt(v->v.getIntVar()));
		System.out.println(sum);
		
		
		
		
		
		
		
//		////////////////////// problem 5 //////////////
		
		
		List<Applicant> applicants = new ArrayList<>();
		applicants.add(new Applicant("12", "prem", 34));
		applicants.add(new Applicant("13", "kumar", 24));
		applicants.add(new Applicant("14", "junakk", 434));
		applicants.add(new Applicant("15", "kunal", 54));
		applicants.add(new Applicant("16", "amar", 74));
		
		
//		List<Applicant> app85 = applicants.stream().filter(p1->p1.getInterviewMarks()>=85).toList();
		
		List<Employee> manager = applicants.stream().filter(p1->p1.getInterviewMarks()>=85).map(new Function<Applicant,Employee>(){

			@Override
			public Employee apply(Applicant t) {
				// TODO Auto-generated method stub
				return new Employee(t.getApplicantid(),t.getName(),"manager",60000+50*t.getInterviewMarks());
			}
			
		}).toList();
		
		List<Employee> clerk = applicants.stream().filter(p1->(p1.getInterviewMarks()>=50 && p1.getInterviewMarks()<85)).map(new Function<Applicant,Employee>(){

			@Override
			public Employee apply(Applicant t) {
				// TODO Auto-generated method stub
				return new Employee(t.getApplicantid(),t.getName(),"clerk",20000+20*t.getInterviewMarks());
			}
			
		}).toList();
		
		
		List<Employee> emplist = new ArrayList<>();
		emplist.addAll(clerk);
		emplist.addAll(manager);
		emplist.forEach(e->{System.out.println(e);});
		
		
		
		Employee maxManager = manager.stream().max((a,b)->(int)(a.getSalary()-b.getSalary())).get();
		
		Employee maxclerk = clerk.stream().max((a,b)->(int)(a.getSalary()-b.getSalary())).get();
		
		List<Employee> maxsal = new ArrayList<>();
		maxsal.add(maxclerk);
		maxsal.add(maxManager);
		
		maxsal.forEach(em->{
			System.out.println(em.getName());
		});
		
	
		
		
		
		
		List<String> idnotselect = applicants.stream().filter(p2->p2.getInterviewMarks()<50).map((e)->e.getApplicantid()).toList();
		
		idnotselect.forEach(con->{
			System.out.println(con);
		});

	}
	
	public static void findNegativeOnly(List<Integer> inlist,List<Double> dlist,List<? super Number> list) {
		
		List<? super Number> flist = list;
		for(int i=0;i<inlist.size();i++) {
			if(inlist.get(i)<0) {
				flist.add(inlist.get(i));
			}
		}
		for(int i=0;i<inlist.size();i++) {
			if(dlist.get(i)<0) {
				flist.add(dlist.get(i));
			}
		}
		

			
	System.out.print("The Negative elements are : "+flist);
			

		
		
	}

}
