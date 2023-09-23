package day3;
import java.util.*;
public class MethodRefDemo {

	public static void main(String[] args) {
		
		
		
		CreateEmployeeObject cio = Employee::new;
		Employee em = cio.getObject(10, "prem", 33323);
		

		
		ShowDetails sd = new ShowDetails() {
			
			@Override
			public String getEmployeeDetailsInString(int employeeId) {
				// TODO Auto-generated method stub
				return em.toString();
			} 
		};
		
		System.out.println(sd.getEmployeeDetailsInString(10));;
		
		Employee em1 = cio.getObject(10, "prem", 33323);
		Employee em2 = cio.getObject(11, "kumar", 3433);
		Employee em3 = cio.getObject(13, "kunal", 98989);
		
		List<Employee> emps = new ArrayList<>();
		emps.add(em);
		emps.add(em1);
		emps.add(em2);
		emps.add(em3);
		
		 

		
		
//		Collections.sort(emps,Employee::compare);  // error
		

		
		System.out.println(emps);
		FindMin fin = new FindMin() {
			
			@Override
			public Employee getMinSalariedEmployee(List<Employee> employeeList) {
				// TODO Auto-generated method stub
				
				return null;
			}
		};
		
		
	}
}
