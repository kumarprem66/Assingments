package practice;

public class Travel {

	Vehicle vehicle;
	
	public Travel() {
		
	}
	
//	setter injection
	public void setVehicle(Vehicle v) {
		this.vehicle = v;
	}
	
	
//	constructor injection
//	public Travel(Vehicle v) {
//		this.vehicle = v;
//	}
	
	public void journey() {
		vehicle.go();
	}
}
