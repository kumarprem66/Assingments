package com.masaischool.sprint4day3;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.masaischool.sprint4day3.problem1.Address;
import com.masaischool.sprint4day3.problem1.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class App 
{
	
	static EntityManagerFactory emf;
	static {
		
		emf = Persistence.createEntityManagerFactory("masaiUnit");
	}
    public static void main( String[] args )
    {
//    	insertemp();
        printEmp();
    	
    	
    }
    
    public static void insertemp() {
    	EntityManager em = emf.createEntityManager();
    	Employee emp1 = new Employee();
    	emp1.setName("Ramesh");
    	emp1.setSalary(13000);
    	emp1.setGender("male");
    	emp1.getEmpAddress().add(new Address("rajstan","jaipur","3493","rural"));
    	emp1.getEmpAddress().add(new Address("bengaluru","hydrabad","3493","rural"));
    	
    	Employee emp2 = new Employee();
    	emp2.setName("Ramesh");
    	emp2.setSalary(13000);
    	emp2.setGender("male");
    	emp2.getEmpAddress().add(new Address("rajstan","jaipur","3493","rural"));
    	emp2.getEmpAddress().add(new Address("bengaluru","hydrabad","3493","rural"));
    	
    	
    	Employee emp3 = new Employee();
    	emp3.setName("Ramesh");
    	emp3.setSalary(13000);
    	emp3.setGender("male");
    	emp3.getEmpAddress().add(new Address("rajstan","jaipur","3493","rural"));
    	emp3.getEmpAddress().add(new Address("bengaluru","hydrabad","3493","rural"));
    	
    	Employee emp4 = new Employee();
    	emp4.setName("Ramesh");
    	emp4.setSalary(13000);
    	emp4.setGender("male");
    	emp4.getEmpAddress().add(new Address("rajstan","jaipur","3493","rural"));
    	emp4.getEmpAddress().add(new Address("bengaluru","hydrabad","3493","rural"));
    	
    	
    	em.getTransaction().begin();
    	em.persist(emp1);
    	em.persist(emp2);
    	em.persist(emp3);
    	em.persist(emp4);
    	em.getTransaction().commit();
    	em.close();
    	System.out.println("done");
    }
    
    
    public static void printEmp() {
    	EntityManager em = emf.createEntityManager();
 
    	
    
    	String selectQuery = "SELECT e from Employee e";
    	Query query = em.createQuery(selectQuery);
    	List<Employee> list = query.getResultList();
    	for(Employee e : list) {
    		System.out.println(e+" "+e.getEmpAddress());
    		
    	}
    	
    	em.close();
    
    	
    	
    
    
    
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
