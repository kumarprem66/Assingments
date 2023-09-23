package problem3;

public class Member {

	private String memberId;
	private String memberName;
	private int age;
	private String memberShipType;
	
	
	
	public Member(String memberId, String memberName, int age, String memberShipType) {
		super();
		this.memberId = memberId;
		this.memberName = memberName;
		this.age = age;
		this.memberShipType = memberShipType;
	}



	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", memberName=" + memberName + ", age=" + age + ", memberShipType="
				+ memberShipType + "]";
	}
	
	
}
