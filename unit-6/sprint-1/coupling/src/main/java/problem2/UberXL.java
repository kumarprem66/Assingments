package problem2;

public class UberXL implements UberInterface{

	public void startRide(){
		System.out.println("UberXL ride started");
	}

	public void endRide(){
		System.out.println("UberXL ride ended");
	}

	public void cancelRide(){
		System.out.println("UberXL ride cancelled");
	}
	
	@Override
	public void start() {
		// TODO Auto-generated method stub
		startRide();
	}

	@Override
	public void end() {
		// TODO Auto-generated method stub
		endRide();
	}

	@Override
	public void cancel() {
		// TODO Auto-generated method stub
		cancelRide();
	}
}
