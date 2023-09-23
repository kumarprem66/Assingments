package com.masaischool.sprint3day1.dao;

import com.masaischool.sprint3day1.entity.Student;
import com.masaischool.sprint3day1.exception.NoSuchDataFoundException;
import com.masaischool.sprint3day1.exception.SomethingWentWrongException;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceException;

public class StudentDaoImpl implements masaiDao{

	@Override
	public Student findStudentById(int id) throws SomethingWentWrongException, NoSuchDataFoundException {
		
		
		EntityManager em = DaoUtils.getEntityManager();
		Student st = null;
		
		try {
			st = em.find(Student.class, id);
			if(st==null) {
				throw new NoSuchDataFoundException("No student is available with this ID");
				
			}
		}catch(IllegalArgumentException e) {
			throw new SomethingWentWrongException(e.getMessage());
		}finally {
			em.close();
		}
		
		
		return st;
	}

	@Override
	public void saveStudent(Student student) throws SomethingWentWrongException, NoSuchDataFoundException {

		
		EntityManager em = DaoUtils.getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		try {
			em.persist(student);
		}catch(PersistenceException e) {
			throw new SomethingWentWrongException(e.getMessage());
		}finally {
			et.commit();
			em.close();
		}
		
	}

	@Override
	public void deleteStudentById(int id) throws SomethingWentWrongException, NoSuchDataFoundException {
	
		EntityManager em = DaoUtils.getEntityManager();
		EntityTransaction et = em.getTransaction();
		Student st = null;
		
		try {
			st = em.find(Student.class, id);
			if(st==null) {
				throw new NoSuchDataFoundException("No student is available with this ID");
				
			}
			et.begin();
			em.remove(st);
			
		}catch(IllegalArgumentException e) {
			throw new SomethingWentWrongException(e.getMessage());
		}finally {
			et.commit();
			em.close();
		}
		
		
	}

	@Override
	public void updateStudentLevel(int id, int lavel) throws SomethingWentWrongException, NoSuchDataFoundException {
		
		
		Student st = findStudentById(id);   // detached book
		st.setLevel(lavel);
		
		EntityManager em = DaoUtils.getEntityManager();
		EntityTransaction et = em.getTransaction();
		try {
			et.begin();
			em.merge(st);
		}catch(IllegalArgumentException e) {
			throw new SomethingWentWrongException(e.getMessage());
		}finally {
			et.commit();
			em.close();
		}
		
		
	}

	
	
	
}
