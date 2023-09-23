package day3;
import java.util.*;

public class EmployeeOperations {

	
	static String getEmployeeWithMinimumSalary(List<Employee> employeeList) {
		
		
		double min = Double.MAX_VALUE;
		String name = "";
		for(Employee e : employeeList) {
			if(e.getSalary()<min) {
				min = e.getSalary();
				name = e.getName();
			}
		}
		return name;
		
	}
}

interface CreateEmployeeObject{
	Employee getObject(int employeeId,String name,double salary);
}


interface ShowDetails{
	String getEmployeeDetailsInString(int employeeId);
}


interface FindMin{
	Employee getMinSalariedEmployee(List<Employee> employeeList);
}