package com.masaischool.sprint4day2;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

/**
 * Hello world!
 *
 */
public class App 
{
static EntityManagerFactory emf;
	
	static {
		
		emf = Persistence.createEntityManagerFactory("masaiUnit");
	}
	
	
	public static void main(String[] args) {
//		printNameInUpper();
//		minAge();
		ageRange(18,25);
		startWithName("p");
		
	}
	
	
	static void printNameInUpper() {
		EntityManager em = emf.createEntityManager();

		String upperQuery = "SELECT UPPER(p.name) FROM Player p";
		Query query = em.createQuery(upperQuery);
		List<String> list = query.getResultList();
		list.forEach(i->System.out.println(i));
		
		em.close();
	}
	
	static void minAge() {
		
		EntityManager em = emf.createEntityManager();

		String minQuery = "SELECT MIN(p.age) FROM Player p";
		Query query = em.createQuery(minQuery);
		Integer age = (Integer)query.getSingleResult();
		System.out.println(age);
		
		em.close();
	}
    
	static void ageRange(int minage,int maxAge) {
		EntityManager em = emf.createEntityManager();
		String rangeQuery = "SELECT p FROM Player p WHERE p.age BETWEEN :lowage AND :highage";
		
		Query query = em.createQuery(rangeQuery);
		query.setParameter("lowage", minage);
		query.setParameter("highage", maxAge);
		List<Player> list = query.getResultList();
		list.forEach(System.out::println);
		em.close();
	}
	
	
	private static void startWithName(String s) {
		
		EntityManager em = emf.createEntityManager();
		String rangeQuery = "SELECT p FROM Player p WHERE p.name like :name";
		
		Query query = em.createQuery(rangeQuery);
		query.setParameter("name","%"+s+"%");
	
		List<Player> list = query.getResultList();
		list.forEach(System.out::println);
		em.close();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
    
    
}
