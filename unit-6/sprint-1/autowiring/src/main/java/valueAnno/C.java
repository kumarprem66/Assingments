package valueAnno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class C {

	@Autowired
	private Environment env;
	
	
	public void funC() {
		System.out.println(env.getProperty("db.driverName"));
	}
	
}
