package com.masaischol.sprint4eval2;



import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;



import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
    
    
    public static void addSubs() {
    	EntityManager em = DUtils.getManager();
    	
    	Subscription sub = new Subscription();
    	sub.setPlan_name("Gold24");
    	sub.setNumber_of_channel(275);
    	sub.setMonthly_charges(275.00);
    	sub.setStart_date(Date.valueOf("2022-01-01"));
    	sub.setEnd_date(Date.valueOf("2022-02-01"));
    	
    	em.getTransaction().begin();
    	em.persist(sub);
    	em.getTransaction().commit();
    	em.close();
    }
    
    public static void getSubsByID(){
    	
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Enter id");
    	int id = sc.nextInt();
    	

    	EntityManager em = DUtils.getManager();
    	Subscription sub = em.find(Subscription.class, id);
    	if(sub==null) {
    		System.out.println("No subscription for given id");
    		return;
    	}

    	System.out.println(sub);
    	em.close();
    	sc.close();
    	

	
    	
    }
    
    public static void findSubsForDateRange(LocalDate startdate,LocalDate endDate){
    	
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Enter start-date");
    	String s = sc.next();
    	System.out.println("Enter end-date");
    	String e = sc.next();
    	

    	EntityManager em = DUtils.getManager();
    	Query query = em.createNamedQuery("findSubsForDateRange");
    	
    	query.setParameter("start", s);
    	query.setParameter("end", e);
    	List<Subscription> list = query.getResultList();
  
    	list.forEach(i->System.out.println(i));
    	em.close();
    }
    
    
   public static void findSubscriptionbyplanName(){
    	
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Enter name");
    	String na = sc.next();
    	
    	

    	EntityManager em = DUtils.getManager();
    	Query query = em.createNativeQuery("findSubsByName");
    	
    	query.setParameter("name", na);
    
    	List<Subscription> list = query.getResultList();
  
    	list.forEach(i->System.out.println(i));
    	em.close();
    	
    }
   
   
   
  public static void updateSubscription(){
   	
   	Scanner sc = new Scanner(System.in);
   	System.out.println("Enter id");
   	int id = sc.nextInt();
//   	System.out.println("Enter planname");
//   	String na = sc.next();
   	
   	EntityManager em = DUtils.getManager();
   	
	Subscription sub = em.find(Subscription.class, id);
	if(sub==null) {
		System.out.println("Invalid subscription");
		return;
	}

	em.getTransaction().begin();
	
   
	sub.setPlan_name("Silver24");
	sub.setNumber_of_channel(375);
	em.getTransaction().commit();
   	em.close();
   	
   }
   
  
	public static void DeleteSubs() {
		Scanner sc = new Scanner(System.in);
	   	System.out.println("Enter id");
	   	int id = sc.nextInt();
	
	 	EntityManager em = DUtils.getManager();
		Subscription subs = em.find(Subscription.class, id);
		if(subs==null) {
			System.out.println("Invalid subscription");
			return;
		}
		
		EntityTransaction et = em.getTransaction();
	
		et.begin();
		em.remove(subs);
		et.commit();
		
		em.close();
		
		
	}
    
    
    
}
