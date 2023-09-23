package com.masai.unit5.day2;
import java.util.*;
import java.util.function.Predicate;

public class Main3 {


	public static void main(String args[]){
		List<Country> countryList = new ArrayList<>();
		//Add countries from Asia
		countryList.add(new Country("China", "Asia", 9596961));
		countryList.add(new Country("Japan", "Asia", 377975));
		countryList.add(new Country("India", "Asia", 3287263));
		countryList.add(new Country("Russia", "Asia", 17098246));
		
		//Add countries from Europe
		countryList.add(new Country("Belgium", "Europe", 30528));
		countryList.add(new Country("Denmark", "Europe", 43094));
		countryList.add(new Country("Germany", "Europe", 357168));
		countryList.add(new Country("Norway", "Europe", 385203));
		
		//Add countries from Africa
		countryList.add(new Country("Egypt", "Africa", 1010408));
		countryList.add(new Country("Morocco", "Africa", 446300));
		countryList.add(new Country("South Africa", "Africa", 1221037));
		countryList.add(new Country("Kenya", "Africa", 580367));
		
		List<Country> countryList2 = new ArrayList<>(countryList);
		
		Scanner sc = new Scanner(System.in);
		int choice = -1;
		do {
			System.out.println("1. By Area Range");
			System.out.println("2. By content in country name");
			System.out.println("3. By continent name");
			System.out.println("4. Clear Filter ");	
			System.out.println("5. Print Country List");
			System.out.println("0. Exit");
			System.out.print("Enter selection ");
			choice = sc.nextInt();
			//write code here as per the instructions given below
			switch(choice) {
			case 1:
				sortByAreaRange(sc,countryList2);
				break;
			case 2:
				sortByCountryName(sc,countryList2);

				break;
			case 3:
				sortContinent(sc,countryList2);

				break;
			case 4:
				countryList2 = new ArrayList<>(countryList);
//				clearFilter(countryList);
			
				break;
			case 5:
				printCountryList(countryList2);
				break;
			case 0:
				System.out.println("EXITED");
				break;
			}
		}while(choice != 0);
		sc.close();
	}



	private static void printCountryList(List<Country> countryList) {
		
		PredicateConsumerDemo.displayCountryList(countryList);
		
	}

	

	private static void sortContinent(Scanner sc,List<Country> countryList) {
		// TODO Auto-generated method stub
		
		List<Country> list = countryList;
		
		System.out.println("Enter continent name");
		String name = sc.next();
		
		Predicate<Country> pr = new Predicate<Country>() {

			@Override
			public boolean test(Country t) {
				// TODO Auto-generated method stub
				if(t.getContinentName().equalsIgnoreCase(name)) {
					return false;
				}
				return true;
			}
		};
		
		list.removeIf(pr);
		PredicateConsumerDemo.displayCountryList(list);
		
		
	}

	private static void sortByCountryName(Scanner sc,List<Country> countryList) {
		// TODO Auto-generated method stub
		List<Country> list = countryList;

		System.out.println("Enter a letter or word of country");
		String s = sc.next();
		Predicate<Country> p = new Predicate<Country>() {

			@Override
			public boolean test(Country t) {
				// TODO Auto-generated method stub
				if(t.getCountryName().toLowerCase().contains(s.toLowerCase())) {
					return false;
				}
				return true;
			}
			
		};
		list.removeIf(p);
		PredicateConsumerDemo.displayCountryList(list);

		
	}

	private static void sortByAreaRange(Scanner sc,List<Country> countryList) {
		// TODO Auto-generated method stub
		List<Country> list = countryList;
		
		System.out.println("Enter minimum area");
		double min = sc.nextDouble();
		System.out.println("Enter maximum area");
		double max = sc.nextDouble();
		
		Predicate<Country> pr = new Predicate<Country>() {

			@Override
			public boolean test(Country t) {
				// TODO Auto-generated method stub
				if(t.getArea()>=min  && t.getArea()<=max){
					return false;
				}
				return true;
			}
		};
		

		PredicateConsumerDemo.filterCountry(list, pr);
		
		PredicateConsumerDemo.displayCountryList(list);
		
	}

}
