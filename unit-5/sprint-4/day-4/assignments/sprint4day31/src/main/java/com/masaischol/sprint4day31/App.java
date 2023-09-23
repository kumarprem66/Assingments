package com.masaischol.sprint4day31;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
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
		
		emf = Persistence.createEntityManagerFactory("labourday");
	}
    public static void main( String[] args )
    {
        
//    	saveBiryani();
    	try {
			getchickenBiryaibyId(3);
			getchickenBiryaibyPrice();
		} catch (EmptyException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
    	
  
    	
    }
    
    public static void saveBiryani()
    {
    	EntityManager em = emf.createEntityManager();
    	
    	VegBiryani vb1 = new VegBiryani(4,100,"tasty");
    	VegBiryani vb2 = new VegBiryani(5,100,"super");
    	
    	ChickenBiryani cb1 = new ChickenBiryani(5,400,"delicious");
    	ChickenBiryani cb2 = new ChickenBiryani(3,500,"spicy");
    	
    	EntityTransaction et = em.getTransaction();
    	et.begin();
    	em.persist(vb1);
    	em.persist(vb2);
    	em.persist(cb1);
    	em.persist(cb2);
    	et.commit();
    	
    	em.close();
    	
    }
    
    
    public static void getchickenBiryaibyId(int id) throws EmptyException {
    	EntityManager em = emf.createEntityManager();
    	
    	String detailsQuery = "SELECT b FROM ChickenBiryani b WHERE b.biryaniId = :id";
    	Query query = em.createQuery(detailsQuery);
    	query.setParameter("id", id);
    	
    	try {
    		Biryani desc = (Biryani) query.getSingleResult();
        	System.out.println(desc);
    	}catch(NoResultException e) {
    		throw new EmptyException("No biryani is avalable with this id");
    	}
    	
    	em.close();
    	
    }
    
    public static void getchickenBiryaibyPrice() throws EmptyException {
    	EntityManager em = emf.createEntityManager();
    	
    	String detailsQuery = "SELECT b FROM ChickenBiryani b WHERE b.price <= 500 ";
    	Query query = em.createQuery(detailsQuery);
    	try {
    		List<ChickenBiryani> desc = query.getResultList();
    		if(desc.isEmpty()) {
    			System.out.println("Empty");
    		}else {
    			desc.forEach(i->System.out.println(i));
    		}
        
    	}catch(NoResultException e) {
    		throw new EmptyException("No biryani is avalable with this this range");
    	}
    	
    	em.close();
    	
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
