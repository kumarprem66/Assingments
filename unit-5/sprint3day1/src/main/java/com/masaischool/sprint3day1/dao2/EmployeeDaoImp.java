package com.masaischool.sprint3day1.dao2;

import com.masaischool.sprint3day1.dao.DaoUtils;
import com.masaischool.sprint3day1.entity.Employee;
import com.masaischool.sprint3day1.exception.NoSuchDataFoundException;
import com.masaischool.sprint3day1.exception.SomethingWentWrongException;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class EmployeeDaoImp implements EmployeeDao{

	@Override
	public void save(Employee employee) throws SomethingWentWrongException {
		EntityManager em = DaoUtils.getEntityManager();
		EntityTransaction et = em.getTransaction();
		try {
			
			et.begin();
			em.persist(employee);
		}catch(IllegalArgumentException e) {
			throw new SomethingWentWrongException(e.getMessage());
		}finally {
			et.commit();
			em.close();
		}
		
		
	}

	@Override
	public String getAddressOfEmployee(int empid) throws SomethingWentWrongException, NoSuchDataFoundException {
		EntityManager em = DaoUtils.getEntityManager();
		Employee employee  = null;
		try {
			
			employee= em.find(Employee.class, empid);
			if(employee==null) {
				throw new NoSuchDataFoundException("No employee found for this id");
			}
			
		}catch(IllegalArgumentException e) {
			throw new SomethingWentWrongException(e.getMessage());
		}finally {
		
			em.close();
		}
		return employee.getAddress();
	}

	@Override
	public String giveBonusToEmployee(int empid, int bonus)
			throws SomethingWentWrongException, NoSuchDataFoundException {
		EntityManager em = DaoUtils.getEntityManager();
		EntityTransaction et = em.getTransaction();
		Employee employee  = null;
		try {
			
			employee= em.find(Employee.class, empid);
			
			
	
			if(employee==null) {
				throw new NoSuchDataFoundException("No employee found for this id");
			}
			et.begin();
			employee.setSalary(employee.getSalary()+bonus);
			
			
		}catch(IllegalArgumentException e) {
			throw new SomethingWentWrongException(e.getMessage());
		}finally {
			et.commit();
			em.close();
		}
		return employee.getAddress();
		
	}

	@Override
	public boolean deleteEmployee(int empid) throws SomethingWentWrongException, NoSuchDataFoundException {
		// TODO Auto-generated method stub
		EntityManager em = DaoUtils.getEntityManager();
		EntityTransaction et = em.getTransaction();
		Employee employee  = null;
		try {
			
			employee= em.find(Employee.class, empid);
			
			if(employee==null) {
				throw new NoSuchDataFoundException("No employee found for this id");
			
			}
			et.begin();
			em.remove(employee);
			
		}catch(IllegalArgumentException e) {
			throw new SomethingWentWrongException(e.getMessage());
		}finally {
			et.commit();
			em.close();
		}
		return true;
	}

}
