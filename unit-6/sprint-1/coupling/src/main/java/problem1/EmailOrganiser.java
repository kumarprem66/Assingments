package problem1;

public class EmailOrganiser implements GmailInterface{

	
	
	private void execute(){
		System.out.println("Organising email...");
	}

	private String getStatus(){
		return "Email organised";
	}

	private void stopOperation(){
		System.out.println("Email organising stopped");
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

