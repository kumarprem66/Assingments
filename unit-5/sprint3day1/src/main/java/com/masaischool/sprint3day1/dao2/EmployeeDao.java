package com.masaischool.sprint3day1.dao2;

import com.masaischool.sprint3day1.entity.Employee;
import com.masaischool.sprint3day1.exception.NoSuchDataFoundException;
import com.masaischool.sprint3day1.exception.SomethingWentWrongException;

public interface EmployeeDao {

	
	public void save(Employee e) throws SomethingWentWrongException;
	
	public String getAddressOfEmployee(int empid) throws SomethingWentWrongException,NoSuchDataFoundException;
	
	public String giveBonusToEmployee(int empid,int bonus) throws SomethingWentWrongException,NoSuchDataFoundException;
	
	public boolean deleteEmployee(int empid) throws SomethingWentWrongException,NoSuchDataFoundException;
	
}
