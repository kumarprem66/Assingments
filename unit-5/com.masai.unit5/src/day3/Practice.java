package day3;

import java.util.Arrays;
import java.util.Collections;
import java.util.*;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class Practice {

	public static void main(String[] args) {

/////////////		==================  STATIC METHOD REFERENCE     =================================== ////////////////////////////////
		
//		ParseNumbers p =  Integer::parseInt;
//		int si = p.convertToNumber("34");
//		System.out.println(si);
//			
//		
//		SmallestElement s =  ArrayOperation::getSmallest;
//					
//		int arr[] = {1,2,3,4,5,6};
//		System.out.println(s.getMinimum(arr));
//		
//		
//		ArrayEquals a = Arrays::equals;
//		System.out.println(a.isEquals(new int[] {10, 20,30},new int[] {10,20,30}));
		
		
/////////////		================== NON STATIC METHOD REFERENCE   for special object  =================================== ////////////////////////////////
		
		
//		InterestCalculator in = new InterestCalculator();
//		Relational rel = in::getabsi;
//		System.out.println(rel.getAmount(1000, 5, 10));
//		
//		
//		rel  = in::getabci;
//		System.out.println(rel.getAmount(1000, 5, 10));
		
		
/////////////		================== NON STATIC METHOD REFERENCE  for arbitrary object   =================================== ////////////////////////////////
		
		
		Function<String,String> f = String::toUpperCase;
		List<Integer> numbers = Arrays.asList(12,12,23,34,556,6,90);
		
		Comparator<Integer> c = new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o1.compareTo(o2);
				
			}
			
		};
		
		Collections.sort(numbers,Integer::compareTo);
		System.out.println(numbers);
		
		
	}
	
/////////////		================== NON STATIC METHOD REFERENCE  for arbitrary object   =================================== //////////////////
	
		
	MyConstructoInterfac mc = Person::new;
	Person p = mc.getPerson("prem");
	
	
	MyConstructoInterfac2 mc2 = Person::new;
	Person p2 = mc.getPerson("prem");
	 

}

class Person {
	private String name;
	
	public Person(String name) {
		this.name = name;
	}
	
	public String toString() {
		return "Name = "+name;
	}
	
}

interface MyConstructoInterfac{
	Person getPerson(String name);
}

interface MyConstructoInterfac2{
	void getPerson(String name);
}


interface MyFunctionalInterface{
	Person getPerson(String name);
}


class InterestCalculator{
	double getabsi(double pa,double tp,double ir) {
		double amount = pa + (pa*tp*ir)/100;
		return Math.round(amount*100)/100.0;
	}
	
	double getabci(double pa,double tp,double ir) {
		double amount = pa + Math.pow((1+ir/100),tp);
		return Math.round(amount*100)/100.0;
	}
}

interface Relational{
	double getAmount(double pa,double tp,double ir);
}

interface ParseNumbers{
	
	int convertToNumber(String number);
	
	
}

interface SmallestElement{
	
	int getMinimum(int arr[]);
}

interface ArrayEquals{
	boolean isEquals(int arr[],int brr[]);
}

class ArrayOperation{
	
	 static int getSmallest(int arr[]) {
		    int smallest = arr[0];
		    for(int i = 1; i < arr.length; i++) {
		      if(smallest > arr[i])
		        smallest = arr[i];
		    }
		    return smallest;
	  }
}

