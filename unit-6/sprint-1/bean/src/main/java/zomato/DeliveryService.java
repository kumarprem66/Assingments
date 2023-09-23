package zomato;

public class DeliveryService {

	OrderService orderService;

	

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	
	
	public void deliveryMade() {
		orderService.infoAboutOrder();
		System.out.println("delivered");
	}
	
}
