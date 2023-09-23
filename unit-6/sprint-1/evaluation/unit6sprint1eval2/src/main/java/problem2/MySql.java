package problem2;

public class MySql{
	
	

	Service service;


	public void setService(Service service) {
		this.service = service;
	}
	
	
	public void getconnForMsql() {
		service.getConnection();
	}
	
	public void insertData() {
		service.create();
	}
	public void updateData() {
		service.update();
	}
	public void deleteData() {
		service.delete();
	}
	public void getData() {
		service.read();
	}

	
}
