package com.masaischool.first_orm_project;

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
		emf = Persistence.createEntityManagerFactory("employeeConnect");
		
	
	
	}
	
	static void addEmployee(Employee employee) {
		EntityManager em = emf.createEntityManager();
		
//		transaction is required for DML operation
		
		EntityTransaction et = em.getTransaction();
		try {
			et.begin();
			em.persist(employee);
			et.commit();
		}catch(PersistenceException ex) {
			System.out.println("Unable to add Student");
		}
		
		em.close();
	}
	
	static void removeEmployee(int empid) {
		EntityManager em = emf.createEntityManager();
		Employee employee = em.find(Employee.class, empid);
		
		if(employee == null) {
			System.out.println("Invalid emp id");
			return;
		}
		
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(employee);
		et.commit();
		em.clear();
				
				
				
		
				
	}
	
	static void updateEmployee(int empid,int salary) {
		EntityManager em = emf.createEntityManager();
		Employee emp = em.find(Employee.class, empid);
		if(emp == null) {
			System.out.println("Invalid empid");
			return;
		}
		//you are here means student is in the database
				//transaction is required for DML operation
		
		EntityTransaction et = em.getTransaction();
		et.begin();
		emp.setSalary(salary);
		et.commit();
		em.close();
	}
	
	static void printEmployeeDetails(int empid) {
		EntityManager em = emf.createEntityManager();
		Employee emp = em.find(Employee.class, empid);
		if(emp == null) {
			System.out.println("Invalid empid");
			return;
		}
		System.out.println(emp);
		em.close();
		
	}
	
    public static void main( String[] args )
    {
    	
    	Scanner sc = new Scanner(System.in);
    	int choose = 0;
    	do {
    		
    	
    		System.out.println(" 1 - Add employee");
    		System.out.println(" 2 - Update employee");
    		System.out.println(" 3 - Delete employee");
    		System.out.println(" 4 - Show Detials employee");
    		System.out.println(" 0 - to exit");
    		System.out.println("Select Your choice");
    		choose  = sc.nextInt();
    		switch(choose) {
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
    			show(sc);
    			break;
    		case 0:
				System.out.println("Thank you, visit again");
				break;
			default:
				System.out.println("Invalid selection, please try again");
    				
    		}
    		
    	}while(choose !=0);
    	
       sc.close();
    }

	private static void show(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.println("Enter empid");
		int id = sc.nextInt();
		printEmployeeDetails(id);
		
	}

	private static void delete(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.println("Enter empid");
		int id = sc.nextInt();
		removeEmployee(id);
		
	}

	private static void update(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.println("Enter empid");
		int id = sc.nextInt();
		System.out.println("Enter salary");
		int salary = sc.nextInt();
		updateEmployee(id,salary);
		
	}

	private static void add(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.println("Enter empid");
		int id = sc.nextInt();
		System.out.println("Enter name");
		String name = sc.next();
		System.out.println("Enter salary");
		int salary = sc.nextInt();
		
		Employee e = new Employee(id,name,salary);
		addEmployee(e);
		
		
	}
    
    
}
