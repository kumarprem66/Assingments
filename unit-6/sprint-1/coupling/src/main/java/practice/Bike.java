package practice;

public class Bike  implements Vehicle{

	
	public void ride() {
		System.out.println("riding a bike");
	}

	@Override
	public void go() {
		// TODO Auto-generated method stub
		ride();
		
	}
}
