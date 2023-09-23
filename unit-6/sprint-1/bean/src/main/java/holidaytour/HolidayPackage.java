package holidaytour;

public class HolidayPackage {

	private String package_name;
	private Tourist tourist;
	private int package_expiry;
	
	
	
	public void setPackage_name(String package_name) {
		this.package_name = package_name;
	}


	public void setTourist(Tourist tourist) {
		this.tourist = tourist;
	}


	public void setPackage_expiry(int package_expiry) {
		this.package_expiry = package_expiry;
	}


	public void showDetails() {
		System.out.println(toString());
	}


	@Override
	public String toString() {
		return "HolidayPackage [package_name=" + package_name + ", tourist=" + tourist + ", package_expiry="
				+ package_expiry + "]";
	}
	
	
	
}
