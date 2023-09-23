package com.masaischol.sprint4eval3;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DUtils {

	static EntityManagerFactory emf;
	
	static {
		emf = Persistence.createEntityManagerFactory("eval3");
	}
	
	static EntityManager getManager() {
		
		return emf.createEntityManager();
	}
}
