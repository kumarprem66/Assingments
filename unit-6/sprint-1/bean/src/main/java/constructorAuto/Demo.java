package constructorAuto;

public class Demo {

	private A a1;
	private A a2;
	private B b1;
	
	
	public Demo() {

		System.out.println("inside zero argument constructor...");
	
	}
	
	public Demo(B b1, A a1) {
		super();
		this.a1 = a1;
		this.b1 = b1;
		
		System.out.println("inside 2 argument constructor...");
	}
	
	public Demo(A a1, A a2, B b1) {
		super();
		this.a1 = a1;
		this.a2 = a2;
		this.b1 = b1;
		
		System.out.println("inside 3 argument constructor...");
	}
	
	public void showDetails() {
		System.out.println("inside showdetails....");
		System.out.println("b1 is "+b1);
		System.out.println("a1 is "+a1);
		System.out.println("a2 is "+a2);
	}
	
	
	public void mysetup() {
		System.out.println("prem kumar init method called");
	}
	
	public void destroy() {
		System.out.println("all the resources released");
	}
}
