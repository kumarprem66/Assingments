package com.masaischool.sprint3day1.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DaoUtils {

	
	static EntityManagerFactory emf = null;
	
	static {
		emf = Persistence.createEntityManagerFactory("masaiUnit");
	}
	
	public static EntityManager getEntityManager() {
		
		return emf.createEntityManager();
	}
}
