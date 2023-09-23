package com.masaischool.sprint4day2.problem2;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class Demo {

	static EntityManagerFactory emfactory;
	
	static {
		   emfactory = Persistence.createEntityManagerFactory("masaiUnit");
	     
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		getCustomerById(1);
		getAllCustomer();

	}
	
	
	static void getCustomerById(int cusid) {
		 EntityManager entitymanager = emfactory.createEntityManager();
	      Query query = entitymanager.createNamedQuery("FindCustomerById");
	      query.setParameter("id", cusid);
	      Customer cus = (Customer)query.getSingleResult();
	      System.out.println(cus);
	      entitymanager.close();
	}
	

	static void getAllCustomer() {
		 EntityManager entitymanager = emfactory.createEntityManager();
	      Query query = entitymanager.createNamedQuery("FindAllCustomer");
	      Customer cus = (Customer)query.getSingleResult();
	      System.out.println(cus);
	      entitymanager.close();
	}
	

}
