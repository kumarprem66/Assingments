package problem4;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;


@Entity
public class OrderDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderDetailId;
	private int orderId;
	private int productId;
	private int quantity;
	
	@OneToOne
	private Orders order;
	
	@OneToMany
	private Products products;

	
	public OrderDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderDetails(int orderDetailId, int productId, int quantity, Orders order, Products products) {
		super();
		this.orderDetailId = orderDetailId;
		this.productId = productId;
		this.quantity = quantity;
		this.order = order;
		this.products = products;
	}
	
	
}
