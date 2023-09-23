package problem4;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


@Entity
public class Customers {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerid;
	private String name;
	private String email;
	private String address;
	private String phone;
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private List<Orders> orders;
	
	public Customers() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customers(int customerid, String name, String email, String address, String phone) {
		super();
		this.customerid = customerid;
		this.name = name;
		this.email = email;
		this.address = address;
		this.phone = phone;
	}

	public int getCustomerid() {
		return customerid;
	}

	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}
