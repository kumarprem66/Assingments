package problem2;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EUtils {

	static EntityManagerFactory emf;
	
	
	static {
		emf = Persistence.createEntityManagerFactory("masaiUnit");
	}
	
	public static EntityManager getManager() {
		return emf.createEntityManager();
	}
	
	
}
