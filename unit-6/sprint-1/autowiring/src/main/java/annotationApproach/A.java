package annotationApproach;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class A {

	
	private B b1;
	
	@Autowired
	private List<String> city;
	

//	@Qualifier("b3")
	@Autowired
	public void setB1(B b1) {
		this.b1 = b1;
	}
	
	
	

//
//
//	public List<String> getCity() {
//		return city;
//	}
//

//
//	public void setCity(List<String> city) {
//		this.city = city;
//	}


	public B getB1() {
		return b1;
	}


	@PostConstruct
	public void setup() {
		System.out.println("init");
	}
	
	
	@PreDestroy
	public void cleanup() {
		
		System.out.println("clean up method");
	}
	public void fun1() {
		System.out.println("inside fun a");
		b1.funb();
		System.out.println(city);
	}
	
	
}
