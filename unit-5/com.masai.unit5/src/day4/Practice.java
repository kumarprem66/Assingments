package day4;

import java.text.DecimalFormat;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import day3.Student;
public class Practice {

	public static void main(String[] args) {
		
		
//		List<Integer> list = Arrays.asList(1,1,2,3,4,5,6,7,8,4,5);
//		System.out.println(list.stream().allMatch(t->t%2==0));
//		System.out.println(list.stream().anyMatch(t->t%2==0));
//		System.out.println(list.stream().noneMatch(t->t<0));
//		System.out.println(list.stream().count());
		
//		double s = list.stream().collect(Collectors.averagingDouble(new ToDoubleFunction<Integer>() {
//
//			@Override
//			public double applyAsDouble(Integer value) {
//				// TODO Auto-generated method stub
//				
//				return value;
//			}
//			
//		}));
//		
//		DecimalFormat df = new DecimalFormat("#.##");
//		s = Double.valueOf(df.format(s));
//		System.out.println(s);
		
		
		
//		System.out.println(s);
//		System.out.println(list.stream().collect(Collectors.averagingDouble(i->i))); 
//		System.out.println(list.stream().collect(Collectors.summingInt(i->i))); 
		
//		BinaryOperator<Integer> bi = new BinaryOperator<Integer>() {
//
//			@Override
//			public Integer apply(Integer t, Integer u) {
//				// TODO Auto-generated method stub
//				return t+u;
//			}
//		};
//		list.stream().forEach(t->System.out.println(t));
//		list.stream().distinct().forEach(System.out::println);
//		list.stream().distinct().filter(i->i%2==0).forEach(System.out::println);
		
//		System.out.println(list.stream().reduce(0, bi));
		
		
//		List<Double> d = list.stream().map(new Function<Integer,Double>() {
//
//			@Override
//			public Double apply(Integer t) {
//				// TODO Auto-generated method stub
//				return Double.valueOf(t);
//			}
//			
//		}).toList();
//		
//		System.out.println(d);
//		
//		
//		List<Integer> sor = list.stream().sorted().toList();
//		System.out.println(sor);
//		
//		List<Integer> sor1 = list.stream().sorted((a,b)->a>b?-1:1).toList();
//		sor1 = sor1.stream().skip(3).toList();
//		System.out.println(sor1);
		
		
		
		List<Student> list = new ArrayList<>();
		list.add(new Student(1,"prem",34));
		list.add(new Student(2,"amar",45));
		list.add(new Student(3,"kumar",34));
		list.add(new Student(4,"kunal",10));
		list.add(new Student(5,"naushad",16));
		list.add(new Student(6,"gaurav",37));
		
		
		List<Student> stu = list.stream().filter(s->s.getMarks()>20).toList();
		System.out.println(stu);
		
		
		
		List<String> s2 = list.stream().map(s->s.getName().toUpperCase()).collect(Collectors.toList());
		
		System.out.println(s2);
		
		
		
		
	}
}
