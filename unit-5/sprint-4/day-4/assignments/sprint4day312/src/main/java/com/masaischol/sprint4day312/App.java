package com.masaischol.sprint4day312;



import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
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
	
	
	static void saveBiryani() {
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
	
	static List<VegBiryani> getAllBiryani() {
		
		EntityManager em = emf.createEntityManager();
		String querydetails = "SELECT v FROM VegBiryani v";
		Query query = em.createQuery(querydetails);
		List<VegBiryani> list = query.getResultList();
		return list;
	}
	
	static VegBiryani getAllBiryanibyId(int id) {
		
		EntityManager em = emf.createEntityManager();
//		String getBirById = "SELECT v FROM VegBiryani v WHERE v.biryaniId = :id";
		Query query = em.createNamedQuery("getBirById");
		query.setParameter("id", id);
		VegBiryani vb = (VegBiryani) query.getSingleResult();
		return vb;
	}
	
	
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
//        saveBiryani();
//        getAllBiryani().forEach(i->System.out.println(i));
        System.out.println(getAllBiryanibyId(1));
    }
}
