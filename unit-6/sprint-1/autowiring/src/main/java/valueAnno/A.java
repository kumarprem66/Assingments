package valueAnno;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class A {

	
	@Value("100")
	int roll = 100;
	
	@Value("Ram")
	String name;
	 
	@Value("780")
	int marks;
	
	
	
	public void funA() {
		System.out.println("inside funA of A");
		System.out.println("roll is "+roll);
		System.out.println("Name is "+name);
		System.out.println("Marks is "+marks);
	}
	
	
	
}
