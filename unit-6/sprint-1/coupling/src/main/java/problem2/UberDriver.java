package problem2;

public class UberDriver {

	
	private UberInterface ui;
	
	public UberDriver(UberInterface ui) {
		this.ui = ui;
	}
	
	public UberDriver() {
		
	}
	
	public void drive(){
		System.out.println("Driver is ready");
		//here it needs Dependencies
		ui.start();
		ui.cancel();
		ui.end();
		
	}
}
