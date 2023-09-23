package problem2;

import java.util.List;

import com.masaischool.sprint4day3.problem1.Address;
import com.masaischool.sprint4day3.problem1.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class EmployeeImp implements EmployeeDao{

	@Override
	public List<Employee> getAllEmployees() throws EmployeeException {
		
		EntityManager em = EUtils.getManager();
		String selectQuery = "SELECT e FROM Employee e";
		Query query = em.createQuery(selectQuery);
		List<Employee> list = query.getResultList();
		em.close();
		return list;
	}

	@Override
	public List<Employee> getEmployeesByAddress(String address) throws EmployeeException {
	
		EntityManager em = EUtils.getManager();
		String findQuery = "from Address where city = :addre";
		Query query = em.createQuery(findQuery);
		query.setParameter("addre", address);
		List<Address> list = query.getResultList();
		
		list.forEach(i->System.out.println(i));
		return null;
		
	}

	@Override
	public List<Employee> getAllEmployeeWithRangeSalary(int startSalary, int endSalary) throws EmployeeException {
		EntityManager em = EUtils.getManager();
		String selectQuery = "SELECT e FROM Employee e WHERE e.salary BETWEEN :startSal AND :endSal";
		
		Query query = em.createQuery(selectQuery);
		query.setParameter("startSal", startSalary);
		query.setParameter("endSal", endSalary);
		List<Employee> list = query.getResultList();
	
		
		return list;
	}

	@Override
	public Object[] getEmployeeNameAndSalary(int empId) throws EmployeeException {
		EntityManager em = EUtils.getManager();
		String selectQuery = "SELECT e FROM Employee e WHERE empID = :id";
		
		Query query = em.createQuery(selectQuery);
		query.setParameter("id", empId);
		Employee emp = (Employee)query.getSingleResult();
	
		em.close();
		Object[] arr = {emp.getName(),emp.getSalary()};
		
		return arr;
	} 

	@Override
	public int getEmployeeSalaryById(int empId) throws EmployeeException {
		EntityManager em = EUtils.getManager();
		String selectQuery = "SELECT e FROM Employee e";
		Query query = em.createQuery(selectQuery);
		Employee emp = (Employee)query.getSingleResult();
		em.close();
		return emp.getSalary();
	}

}
