package problem1;

public class EmailSender implements GmailInterface{

	private void execute(){
		System.out.println("Sending email...");
	}

	private String getStatus(){
		return "Email sent";
	}

	private void stopOperation(){
		System.out.println("Email sending stopped");
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
