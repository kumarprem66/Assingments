package zomato;

public class OrderService {

	RestaurantService restaurantService;


	public void setRestaurantService(RestaurantService restaurantService) {
		this.restaurantService = restaurantService;
	}
	
	
	public void infoAboutOrder() {
		restaurantService.giveInfoAndMenu();
		System.out.println("info about order");
	}
	
	
	
	
	
}
