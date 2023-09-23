package com.masaischool.sprint3day1.dao;

import com.masaischool.sprint3day1.entity.Student;
import com.masaischool.sprint3day1.exception.NoSuchDataFoundException;
import com.masaischool.sprint3day1.exception.SomethingWentWrongException;

public interface masaiDao {

	
	Student findStudentById(int id) throws SomethingWentWrongException,NoSuchDataFoundException;
	void saveStudent(Student student) throws SomethingWentWrongException,NoSuchDataFoundException;
	void deleteStudentById(int id) throws SomethingWentWrongException,NoSuchDataFoundException;
	void updateStudentLevel(int id,int lavel) throws SomethingWentWrongException,NoSuchDataFoundException;
	
	
}
