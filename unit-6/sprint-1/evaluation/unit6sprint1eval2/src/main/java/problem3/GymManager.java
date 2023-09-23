package problem3;

import java.util.Map;
import java.util.function.BiConsumer;

public class GymManager {

	private Map<WorkoutProgram,GymManager> gymPrograms;
	



	public void setGymPrograms(Map<WorkoutProgram, GymManager> gymPrograms) {
		this.gymPrograms = gymPrograms;
	}


	public void initialize() {
		
		System.out.println("inside initialize method");
	}
	
	public void shutdown() {
		
		System.out.println("inside shutdown method");
	}
	
	
	public void displayDetail() {
		
		gymPrograms.forEach(new BiConsumer<WorkoutProgram, GymManager>() {

			@Override
			public void accept(WorkoutProgram t, GymManager u) {
				
				
				System.out.println(t+" --  "+u);
				
			}
			
		});
	}
}
