package problem1;

public class EmailReader implements GmailInterface{

	private void execute(){
		System.out.println("Reading email...");
	}

	private String getStatus(){
		return "Email read";
	}

	private void stopOperation(){
		System.out.println("Email reading stopped");
	}
	

	@Override
	public void read() {
		// TODO Auto-generated method stub
		execute();
		
	}

	@Override
	public void organise() {
		// TODO Auto-generated method stub
		getStatus();
	}

	@Override
	public void send() {
		// TODO Auto-generated method stub
		stopOperation();
	}
}
