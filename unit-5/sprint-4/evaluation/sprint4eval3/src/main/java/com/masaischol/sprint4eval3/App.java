package com.masaischol.sprint4eval3;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        
//    	part -1 
    	
//    	1.false
//    	2.false
//    	3.false
//    	4.true
//    	5.false
    	
    	
    	
//    	part -2
    	
//    	addPizza();
//    	display();
//    	display2();
    	display3();
    }
    
    
    
    public static void addPizza() {
    	
    	EntityManager em = DUtils.getManager();
    	
    	SupremePizza s1 = new SupremePizza(199,4.5,6,"non-veg",2,1);
    	SupremePizza s2 = new SupremePizza(199,4.5,6,"non-veg",2,1);
    	SupremePizza s3 = new SupremePizza(199,4.5,6,"non-veg",2,1);
    	
    	
    	VeggiesPizza v1 = new VeggiesPizza(99, 4.8,6,"veg",3,240);
    	VeggiesPizza v2 = new VeggiesPizza(199, 4.8,6,"veg",4,270);
    	VeggiesPizza v3 = new VeggiesPizza(39, 4.8,6,"veg",3,270);
    	
    	em.getTransaction().begin();
    	em.persist(v1);
    	em.persist(v2);
    	em.persist(v3);
    	em.persist(s1);
    	em.persist(s2);
    	em.persist(s3);
    	em.getTransaction().commit();
    	em.close();
    	
    }
    
    static void display() {
    	
    		EntityManager em = DUtils.getManager();
    	
	    	String detailsQuery = "SELECT p FROM Pizza p WHERE p.totalCalories < 400 and p.forNumberOfPeople > 1";
	    	Query query = em.createQuery(detailsQuery);
    	
 
	    	List<Pizza> desc =  query.getResultList();
	    	desc.forEach(i->System.out.println(i.getDiameter() + " "+i.getRating() + " "+i.getPrice()+ " "+i.getType()));
        	System.out.println(desc);
    	
    	
        	em.close();
    }
    
    
    static void display2() {
    	
		EntityManager em = DUtils.getManager();
	
    	String detailsQuery = "SELECT p FROM Pizza p WHERE p.totalVeggies >= 4 and p.rating <=3.5";
    	Query query = em.createQuery(detailsQuery);
	

    	List<VeggiesPizza> desc =  query.getResultList();
    	desc.forEach(i->System.out.println(i.getId() + " "+i.getTotalVeggies() + " "+i.getTotalCalories()));
    	System.out.println(desc);
	
	
    	em.close();
    }
    
    
    static void display3() {
    	
    	EntityManager em = DUtils.getManager();
    	
    	String detailsQuery = "SELECT p FROM Pizza p WHERE p.price between 149 and 249 ";
    	Query query = em.createQuery(detailsQuery);
	

    	
    	List<Pizza> list =  query.getResultList();
    	for(Pizza p : list) {
    		if(p instanceof VeggiesPizza) {
    			
    			VeggiesPizza v = (VeggiesPizza)p;
    			System.out.println(v.getTotalCalories()+" "+ v.getTotalVeggies());
    			
    		}else {
    			SupremePizza s = (SupremePizza)p;
    			System.out.println(s.getPrice()+" "+ s.getForNumberOfPeople() + " "+ s.getTotalSauces());
    		}
    	}
    	
    
	
	
    	em.close();
    }
    
    
}
