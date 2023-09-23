package netflix;

public class UserService {

	RecommendationService recommendationService;

	
	public void setRecommendationService(RecommendationService recommendationService) {
		this.recommendationService = recommendationService;
	}
	
	
	public void userlogin(String name) {
		System.out.println("successfully login "+name);
	}
	
	public void getReccomendaedService() {
		recommendationService.giveReccomendation();
	}


	public void giveUserDetails() {

		System.out.println("this is user details");
		
	}
	
	
}
