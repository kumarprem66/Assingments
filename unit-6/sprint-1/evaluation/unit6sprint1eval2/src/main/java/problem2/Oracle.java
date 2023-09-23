package problem2;

public class Oracle {

	Service service;


	public void setService(Service service) {
		this.service = service;
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
