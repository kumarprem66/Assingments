package valueAnno;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class B {

	@Value("${db.driverName}")
	private String dname;
	
	@Value("${db.url}")
	private String url;
	
	@Value("${db.username}")
	private String uname;
	
	@Value("${db.password}")
	private String pass;
	
	
	public void funb() {
		System.out.println("inside funA of A ");
		System.out.println(dname);
		System.out.println(url);
		System.out.println(uname);
		System.out.println(pass);
	}
	
}
