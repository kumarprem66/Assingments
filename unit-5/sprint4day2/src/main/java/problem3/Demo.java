package problem3;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class Demo {

	static EntityManagerFactory emf;
	
	static {
		emf = Persistence.createEntityManagerFactory("masaiUnit");
		
	}
	
	
	public static void main(String[] args) {
//		getEmployeeByname("prem");
		getAllEmployee();
	}
	
	static void getEmployeeByname(String name) {
		EntityManager em = emf.createEntityManager();
		Query query = em.createNamedQuery("getEMployeeByName");
		query.setParameter("name", "%"+name+"%");
		List<Employee>  list = query.getResultList();
		list.forEach(System.out::println);
		em.close();
	}
	
	static void getAllEmployee() {
		EntityManager em = emf.createEntityManager();
		Query query = em.createNamedQuery("getEMployeeList");
		
		List<Employee>  list = query.getResultList();
		list.forEach(System.out::println);
		em.close();
	}
}
