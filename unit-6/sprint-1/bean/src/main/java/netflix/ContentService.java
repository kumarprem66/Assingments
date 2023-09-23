package netflix;

public class ContentService {

	
	UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}




	public void getcontentInfo() {
		userService.giveUserDetails();
		System.out.println("this is content information");
	}
}
