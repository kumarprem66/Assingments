package com.masaischol.sprint4eval1;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.masaischol.sprint4eval1.prob1a.Employee;
import com.masaischol.sprint4eval1.prob1a.Insurance;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import prob1b.Company;
import prob1b.Mobile;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
     
//    	part -1
    	
//    	addEmp();
//    	selectINupper("LIC");
    	
//    	c -ans   1. true 2. true
    	
    	
    	
//    	part - 2
    	
//    	addMobileAndCom();
//    	displayMobile();
    	
    }
    
    public static void addMobileAndCom() {
    	EntityManager em = DUtils.getManager();
    	
    	Mobile m1 = new Mobile();
    	m1.setPrice(1000);
    	m1.setModelNumber("m21");
    
    	
    	Mobile m2 = new Mobile();
    	m2.setPrice(2000);
    	m2.setModelNumber("m22");
    	
    	Mobile m3 = new Mobile();
    	m3.setPrice(3000);
    	m3.setModelNumber("m23");
    	
    	Mobile m4 = new Mobile();
    	m4.setPrice(4000);
    	m4.setModelNumber("m24");
    	
    	
    	Set<Mobile> set1 = new HashSet<>();
    	set1.add(m1);
    	set1.add(m2);
    	
    	
    	Set<Mobile> set2 = new HashSet<>();
    	set2.add(m3);
    	set2.add(m4);
    	
    	Company c1 = new Company();
    	c1.setName("Samsung");
    	c1.setEstdYear(1938);
    	c1.setMobiles(set1);
    	
    	Company c2 = new Company();
    	c2.setName("Nokia");
    	c2.setEstdYear(1865);
    	c2.setMobiles(set2);
    	
    	
    	m1.setCompany(c1);
    	m2.setCompany(c1);
    	
    	m3.setCompany(c2);
    	m4.setCompany(c2);
    	
    	em.getTransaction().begin();
    	em.persist(c1);
    	em.persist(c2);
    	em.getTransaction().commit();
    	em.close();
    }
    
    
    
    public static void displayMobile() {
    	
    	EntityManager em = DUtils.getManager();
    	String q = "SELECT c from Company c";
     	Query query = em.createQuery(q);
     	List<Company> list = query.getResultList();
     	for(Company com : list) {
     		Set<Mobile> set = com.getMobiles();
     		set.forEach(i->{
     			System.out.println(i.getModelNumber() +" of price "+i.getPrice() + " made by "+com.getName());
     		});
     	
     	}
    }
    
    public static void addEmp() {
    	EntityManager em = DUtils.getManager();
    	
    	Employee emp = new Employee();
    	emp.setName("anuj");
    	emp.setAge(24);
    	
    	Insurance inc = new Insurance("Term plan","LIC",145000);
    	emp.setSelfInsurance(inc);
    	emp.setEmployerInsurance(new Insurance("Health policy","Max Life",16525));
    	
    	
    	Employee emp1 = new Employee();
    	emp1.setName("akshay");
    	emp1.setAge(32);
    	emp1.setSelfInsurance(new Insurance("Term plan","HDFC Ergo",20700));
    	emp1.setEmployerInsurance(new Insurance("Health policy","LIC",15875));
    	
    	em.getTransaction().begin();
    	em.persist(emp);
    	em.persist(emp1);
    	em.getTransaction().commit();
    	em.close();
    	
    }
    
 
    public static void selectINupper(String pname) {
    	
    	EntityManager em = DUtils.getManager();
    	String qe = "SELECT e.name from Employee e WHERE e.selfInsurance a a.self_policyName = :pname ";
    	
    	Query query = em.createQuery(qe);
    	query.setParameter("pname", pname);
    	List<Employee> list = query.getResultList();
    	list.forEach(i->System.out.println(i.getSelfInsurance()));
    }
    
    
    
    
    
    
}
