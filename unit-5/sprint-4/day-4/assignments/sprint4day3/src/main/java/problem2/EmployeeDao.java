package problem2;

import java.util.List;

import com.masaischool.sprint4day3.problem1.Employee;

public interface EmployeeDao
{
	public List<Employee> getAllEmployees() throws EmployeeException;
//getAllEmployees implement using NamedQuery

	public List<Employee> getEmployeesByAddress(String address) throws EmployeeException;

	public List<Employee> getAllEmployeeWithRangeSalary(int startSalary, int endSalary) throws EmployeeException;
	
	public Object[] getEmployeeNameAndSalary(int empId)throws EmployeeException;
//getEmployeeNameAndSalary implement using namedNativeQuery

	public int getEmployeeSalaryById(int empId)throws EmployeeException;
}