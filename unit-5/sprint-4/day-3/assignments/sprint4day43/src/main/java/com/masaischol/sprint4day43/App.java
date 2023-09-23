package com.masaischol.sprint4day43;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class App 

{
	
	
	static EntityManagerFactory emf;
	
	static {
		emf = Persistence.createEntityManagerFactory("asso");
	}
	

    
    public static void addEmployeeAndAccount() {
    	
    	Employee emp1 = new Employee();
    	emp1.setName("prem");
    	emp1.setEmail("abs@gmail.com");
    	
    	Account ac = new Account();
    	ac.setBalance(10000);
    	ac.setEmployee(emp1);
    	Account ac2 = new Account();
    	ac2.setBalance(20000);
    	ac2.setEmployee(emp1);
    	
    	
    	Set<Account> set = new HashSet<>();
    	set.add(ac);
    	set.add(ac2);
    	emp1.setAccounts(set);
    	
    	EntityManager em = emf.createEntityManager();
    	EntityTransaction et = em.getTransaction();
    	et.begin();
    	em.persist(emp1);   // insert employee table, it will save account also because CASCADETYPE.ALL
    	et.commit();
    	em.close();
    	
    }
    
    public static void showEmployeeAndACCOUNT() {
    	EntityManager em = emf.createEntityManager();
    	Employee emp = em.find(Employee.class, 1);
    	System.out.println(emp.getEmail()+" "+emp.getName()+" "+emp.getId());
    	Set<Account> acc = emp.getAccounts();
    	acc.forEach(i->System.out.println(i));
    	em.close();
    }
    
    public static void showAccountAndEmployee() {
    	EntityManager em = emf.createEntityManager();
    	Account acc = em.find(Account.class, 1);
    
//    	Employee emp = acc.getEmployee();
    	System.out.println(acc.getBalance()+" "+acc.getId());
    	em.close();
    }
    
    
    
 public static void addStudentAndCourse() {
    	
	 Student st1 = new Student();
	 st1.setName("prem");
	 
	 Student st2 = new Student();
	 st2.setName("premk");
	 
	 Set<Student> set = new HashSet<>();
	 set.add(st1);
	 set.add(st2);
	 
	 Course cr1 = new Course();
	 cr1.setName("java");
	 
	 Course cr2 = new Course();
	 cr2.setName("android");
	 
	 Set<Course> courses = new HashSet<>();
	 courses.add(cr1);
	 courses.add(cr2);
	 
	 st1.setCourses(courses);
	 st2.setCourses(courses);
	 
	 cr1.setStudents(set);
	 cr2.setStudents(set);
    	
    	
    	EntityManager em = emf.createEntityManager();
    	EntityTransaction et = em.getTransaction();
    	et.begin();
    	em.persist(st1);   // insert employee table, it will save account also because CASCADETYPE.ALL
    	em.persist(st2); 
    	et.commit();
    	em.close();
    	
    }
    
    
    
	public static void main( String[] args )
    {
        
//    	addEmployeeAndAccount();
//    	showEmployeeAndACCOUNT();
//		showAccountAndEmployee();
		
		addStudentAndCourse();
    }
}
