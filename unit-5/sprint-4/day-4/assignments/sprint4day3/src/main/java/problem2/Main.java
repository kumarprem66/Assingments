package problem2;

import java.util.List;

import com.masaischool.sprint4day3.problem1.Address;
import com.masaischool.sprint4day3.problem1.Employee;

import jakarta.persistence.EntityManager;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EmployeeDao dao = new EmployeeImp();
		try {
			dao.getEmployeesByAddress("jaipur");

		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
    
    

}
