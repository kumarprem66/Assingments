package annotationAppraoch2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service(value="amar")
public class A {

	@Autowired
	private B b1;
	
	@Autowired
	private String name;
	
	@Autowired
	private Integer age;
	

	private List<String> cities;
	
	public void funA() {
		System.out.println("B object is "+b1);
		System.out.println("Name object is "+name);
		System.out.println("Age object is "+age);
		
	}

	
	public List<String> getCities() {
		return cities;
	}

	@Autowired
	public void setCities(List<String> cities) {
		this.cities = cities;
	}
	
	
	
}
