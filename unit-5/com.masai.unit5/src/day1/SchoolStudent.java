package day1;

public class SchoolStudent extends Student{

	
	private String boardName;

	public SchoolStudent(int roll, String name, String state,String boardName) {
		super(roll, name, state);
		this.boardName = boardName;
		
	}





	@Override
	public String toString() {
		return "SchoolStudent [boardName=" + boardName + ", roll=" + roll + ", name=" + name + ", state=" + state + "]";
	}





	public String getBoardName() {
		return boardName;
	}

	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}

	
	
	
	
}
