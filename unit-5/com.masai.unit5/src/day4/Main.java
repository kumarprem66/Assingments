package day4;

import java.util.*;

public class Main {

	
	public static void main(String[] args) {
		
		List<Product> list = new ArrayList<>();
		list.add(new Product(1,"mango",90,20));
		list.add(new Product(2,"apple",34,10));
		list.add(new Product(3,"orange",35,40));
		list.add(new Product(4,"grapes",23,30));
		list.add(new Product(5,"lichi",34,20));
		 
		List<Product> fillist = list.stream().filter(p->p.getQuantity()>10).toList();
		
		fillist = fillist.stream().sorted(new Comparator<Product>() {

			@Override
			public int compare(Product o1, Product o2) {
				// TODO Auto-generated method stub
				return (int) (o1.getPrice()-o2.getPrice());
			}
			 
		}).toList();
		
		System.out.println(fillist);
	}
}
