package employeeproblem2;

import java.util.Map;

public class Demo {

	private Map<Department,Employee> theMap;
	
	
	
	public void setTheMap(Map<Department, Employee> theMap) {
		this.theMap = theMap;
	}

	public void myinit() {
		System.out.println("inside myinit method");
	}
	
	public void cleanUp() {
		System.out.println("inside cleanup method");
	}
	
	public void showDetails() {
		for(Map.Entry<Department,Employee> kv : theMap.entrySet()) {
			System.out.println("Department - "+ kv.getKey().getDeptName() + " employee - "+kv.getValue());
		}
	}
}
