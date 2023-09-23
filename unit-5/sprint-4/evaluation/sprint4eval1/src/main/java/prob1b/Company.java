package prob1b;

import java.util.Set;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Company {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private int estdYear;
	
	@OneToMany(mappedBy = "company",cascade = CascadeType.ALL)
	private Set<Mobile> mobiles;

	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Company(String name, int estdYear, Set<Mobile> mobiles) {
		super();
	
		this.name = name;
		this.estdYear = estdYear;
		this.mobiles = mobiles;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getEstdYear() {
		return estdYear;
	}

	public void setEstdYear(int estdYear) {
		this.estdYear = estdYear;
	}

	public Set<Mobile> getMobiles() {
		return mobiles;
	}

	public void setMobiles(Set<Mobile> mobiles) {
		this.mobiles = mobiles;
	}
	
	
	
	
}
