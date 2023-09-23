package day4;
import java.util.*;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collectors;


public class FruitMain {

	
	public static void main(String[] args) {
		List<Fruit> list = Arrays.asList(
				new Fruit("orange",10,28),
				new Fruit("mango",13,90),
				new Fruit("pomegrannate",18,72),
				new Fruit("lichi",15,90),
				new Fruit("grapes",16,87),
				new Fruit("banana",13,89));
				
		
		
		list = list.stream().sorted((a,b)->(int)(a.getPrice()-b.getPrice())).toList();	
		System.out.println(list);
		
		Map<String,Double> kv = list.stream().collect(Collectors.toMap(new Function<Fruit,String>(){

			@Override
			public String apply(Fruit t) {
				// TODO Auto-generated method stub
				return t.getName();
			}
			
		}, new Function<Fruit,Double>(){

			@Override
			public Double apply(Fruit t) {
				// TODO Auto-generated method stub
				return t.getPrice()*t.getQuantity();
			}
			
		}));
		
		System.out.println(kv);
		
		List<Double> fruitprice = list.stream().map(new Function<Fruit,Double>(){

			@Override
			public Double apply(Fruit t) {
				// TODO Auto-generated method stub
				return t.getPrice()*t.getQuantity();
			}
			
		}).toList();
		
		System.out.println(fruitprice);
		
		double totalsum = list.stream().collect(Collectors.summingDouble(new ToDoubleFunction<Fruit>() {

			@Override
			public double applyAsDouble(Fruit value) {
				// TODO Auto-generated method stub
				return value.getPrice()*value.getQuantity();
			}
			
		}));
		
		System.out.println(totalsum);

		List<Fruit> onlytwofruit = list.stream().filter(f->f.getPrice()>=50).sorted((a,b)->a.getName().compareTo(b.getName())).skip(2).toList();
		System.out.println(onlytwofruit);
	}
}

