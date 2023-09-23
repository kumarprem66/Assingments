package com.masai.ui;

import java.time.LocalDate;
import java.util.Scanner;

import com.masai.dao.BookDao;
import com.masai.dao.BookDaoImpl;
import com.masai.dto.Book;
import com.masai.exception.NoRecordFoundException;
import com.masai.exception.SomethingWentWrongException;

public class BookMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		do {
			System.out.println("1. Add Book");
			System.out.println("2. Update Book");
			System.out.println("3. Delete Book");
			System.out.println("4. Search Book By id ");
			System.out.println("5. Serch book by pages number and date");
			System.out.println("0. Exit");
			System.out.print("Enter selection ");
			choice = sc.nextInt();
			switch(choice) {
				case 1:
					add(sc);
					break;
				case 2:
					update(sc);
					break;
				case 3:
					delete(sc);
					break;
				case 4:
					searchbyid(sc);
					break;
				case 5:
					searchbypages(sc);
					break;
				
				case 0:
					System.out.println("Thank you, visit again");
					break;
				default:
					System.out.println("Invalid selection, please try again");
			}
		}while(choice != 0);
		
		sc.close();
		
		
		
		

	}
	
	
	private static void searchbypages(Scanner sc) {
		// TODO Auto-generated method stub
		
	}


	private static void searchbyid(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.println("Enter book code");
		String code = sc.next();
		
		BookDao bo = new BookDaoImpl();
		try {
			
			System.out.println(bo.findBook(code));
		} catch (SomethingWentWrongException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (NoRecordFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	private static void delete(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.println("Enter book code");
		String code = sc.next();
		
		BookDao bo = new BookDaoImpl();
		try {
			
			bo.deleteBook(code);
			System.out.println("deleted successfully");
		} catch (SomethingWentWrongException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (NoRecordFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	private static void update(Scanner sc) {
		// TODO Auto-generated method stub
		
		System.out.println("Enter book code");
		String code = sc.next();
		System.out.println("Enter book name");
		String name = sc.next();
		System.out.println("Enter book price");
		double price = sc.nextDouble();
		System.out.println("Enter book publish date");
		String date = sc.next();
		System.out.println("Enter book pages");
		int pages = sc.nextInt();
		System.out.println("Enter book writer name");
		String wname = sc.next();
		
		Book book = new Book(code,name,price,LocalDate.parse(date),pages,wname);
		BookDao bo = new BookDaoImpl();
		try {
			bo.updateBook(book);
			System.out.println("Book updated successfully");
		} catch (SomethingWentWrongException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (NoRecordFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	public static void add(Scanner sc) {
		
		
		System.out.println("Enter book code");
		String code = sc.next();
		System.out.println("Enter book name");
		String name = sc.next();
		System.out.println("Enter book price");
		double price = sc.nextDouble();
		System.out.println("Enter book publish date");
		String date = sc.next();
		System.out.println("Enter book pages");
		int pages = sc.nextInt();
		System.out.println("Enter book writer name");
		String wname = sc.next();
		
		Book book = new Book(code,name,price,LocalDate.parse(date),pages,wname);
		BookDao bo = new BookDaoImpl();
		try {
			bo.addBook(book);
			System.out.println("Book added successfully");
		} catch (SomethingWentWrongException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	
		
		
	}

}
