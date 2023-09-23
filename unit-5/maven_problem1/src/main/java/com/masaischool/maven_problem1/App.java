package com.masaischool.maven_problem1;

import java.util.Scanner;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceException;

/**
 * Hello world!
 *
 */
public class App 
{
	
	
	static EntityManagerFactory emf;
	
	static {
		emf = Persistence.createEntityManagerFactory("evaluation");
	}
	
	
	
	
	public static void addAuthor(Author author) {
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		
		
		try {
			et.begin();
			em.persist(author);
			et.commit();
		}catch(PersistenceException ex) {
			System.out.println("Unable to add Student");
		}
		em.close();
		
	}
	
	public static void DisplayAuthor(int id) {
		EntityManager em = emf.createEntityManager();
		Author author = em.find(Author.class, id);
		if(author==null) {
			System.out.println("No author for given id");
			return;
		}
		
		System.out.println(author);
		em.close();
		
	}
	
	
	
	public static void UpdateAuthor(int id,double rating) {
		EntityManager em = emf.createEntityManager();
		Author author = em.find(Author.class, id);
		if(author==null) {
			System.out.println("No author for given id");
			return;
		}
		
		EntityTransaction et = em.getTransaction();
	
		et.begin();
		author.setRating(rating);
		et.commit();
		
		em.close();
		
		
	}
	
	public static void DeleteAuthor(int id) {
		EntityManager em = emf.createEntityManager();
		Author author = em.find(Author.class, id);
		if(author==null) {
			System.out.println("No author for given id");
			return;
		}
		
		EntityTransaction et = em.getTransaction();
	
		et.begin();
		em.remove(author);
		et.commit();
		
		em.close();
		
		
	}
	
	
	
	public static void add(Scanner sc) {
		
		System.out.println("ENTER author id");
		int id = sc.nextInt();
		System.out.println("ENTER author name");
		String name = sc.next();
		System.out.println("ENTER author rating");
		double rating = sc.nextDouble();
		
		addAuthor(new Author(id,name,rating));
		
	}
	
	public static void update(Scanner sc) {
		
		System.out.println("ENTER author id");
		int id = sc.nextInt();
		
		System.out.println("ENTER author rating");
		double rating = sc.nextDouble();
		
		UpdateAuthor(id, rating);
		
	}
	
	public static void show(Scanner sc) {
		
		System.out.println("ENTER author id");
		int id = sc.nextInt();
		
		
		DisplayAuthor(id);
		
	}
	public static void remove(Scanner sc) {
		
		System.out.println("ENTER author id");
		int id = sc.nextInt();
	
		
		DeleteAuthor(id);
		
	}
	
	
	

	
    public static void main( String[] args )
    {
      
    	Scanner sc = new Scanner(System.in);
    	
    	int choice = 0;
    	
    	do {
    		
    		System.out.println(" 1 - Add Athor");
    		System.out.println(" 2 - Update Athor");
    		System.out.println(" 3 - remove Athor");
    		System.out.println(" 4 - show Athor");

    		System.out.println(" 0 - exit");
    		System.out.println("choose selection");
    		choice = sc.nextInt();
    		switch(choice) {
    		case 1:
    			add(sc);
    			break;
    		case 2:
    			update(sc);
    			break;
    		case 3:
    			remove(sc);
    			break;
    		case 4:
    			show(sc);
    			break;
    		case 0:
    			System.out.println("Exited successfully");
    			break;
			default:
				System.out.println("Select valid input");
    			break;
    		}
    		
    	}while(choice !=0 );
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    }
}
