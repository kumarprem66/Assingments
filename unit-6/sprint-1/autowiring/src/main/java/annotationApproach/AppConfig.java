package annotationApproach;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan(basePackages = {"annotationApproach"})
public class AppConfig {

	
	
	@Bean
	@Primary
	public B getB() {
		B b1 = new B();
		return b1;
	}
	
	@Bean
	public List<String> getCities(){
		
		List<String> cities = new ArrayList<>();
		cities.add("delhi");
		cities.add("chennai");
		cities.add("mumbai");
		cities.add("kolkata");
		return cities;
	}
}
