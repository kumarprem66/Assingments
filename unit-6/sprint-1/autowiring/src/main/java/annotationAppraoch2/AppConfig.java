package annotationAppraoch2;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"annotationAppraoch2"})
public class AppConfig {

	@Bean
	public B getB() {
		B b1 = new B();
		return b1;
	}
	
	
	@Bean
	public String getName() {
		return "Prem";
	}
	
	@Bean
	public Integer getAge() {
		return 20;
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
