package problem3;

public class WorkoutProgram {

	
	private String programId;
	private String name;
	private int programDuration;
	
	
	
	public WorkoutProgram(String programId, String name, int programDuration) {
		super();
		this.programId = programId;
		this.name = name;
		this.programDuration = programDuration;
	}

	


	@Override
	public String toString() {
		return "WorkoutProgram [programId=" + programId + ", name=" + name + ", programDuration=" + programDuration
				+ "]";
	}
	
	
}
