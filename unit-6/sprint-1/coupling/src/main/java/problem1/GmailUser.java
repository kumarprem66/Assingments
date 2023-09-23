package problem1;

public class GmailUser {
	
	
	GmailInterface gi;
	
	public GmailUser(GmailInterface gi) {
		this.gi = gi;
	}

	public GmailUser() {

	}

	public void readEmails() {
		
		gi.read();
		
	}
	
	public void sendEmails() {
			
		gi.send();
	}

	public void organiseEmails() {
		
		gi.organise();
	}
}
