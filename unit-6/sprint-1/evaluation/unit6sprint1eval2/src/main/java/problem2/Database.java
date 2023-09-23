package problem2;

import java.sql.Connection;

public interface Database {

	
	public void getConnection();
	

	
	public void create();
	public void read();
	public void update();
	public void delete();
}
