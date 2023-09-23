package problem2;

public class UberX implements UberInterface{

	private void startRide(){
		System.out.println("UberX ride started");
	}

	private void endRide(){
		System.out.println("UberX ride ended");
	}

	private void cancelRide(){
		System.out.println("UberX ride cancelled");
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
