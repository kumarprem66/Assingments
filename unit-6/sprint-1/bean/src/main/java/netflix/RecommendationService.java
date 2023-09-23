package netflix;

public class RecommendationService {

	ContentService contentService;
	


	public void setContentService(ContentService contentService) {
		this.contentService = contentService;
	}


	public void giveReccomendation() {
		contentService.getcontentInfo();
		System.out.println("reccommended content");
	}
	
}
