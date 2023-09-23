package day1;
import java.util.*;

public class Demo {

	
	public static void main(String[] arr) {
//	 sorting using lambda expression
		
		

		
///////////////////////////////////////		 PROBLEM -2 ////////////////////////////////////////////////
		
		List<SchoolStudent> schList = new ArrayList<>();
		
		schList.add(new SchoolStudent(12,"prem","bihar","bseb"));
		schList.add(new SchoolStudent(13,"kumar","mumbai","cbse"));
		schList.add(new SchoolStudent(14,"genius","mp","inte"));
		schList.add(new SchoolStudent(15,"gaurav","punjab","bseb"));
		schList.add(new SchoolStudent(16,"naushad","orrisa","cbse"));
		
		
		List<CollegeStudent> collList = new ArrayList<>();
		
		collList.add(new CollegeStudent(12,"prem","bihar","magadh"));
		collList.add(new CollegeStudent(13,"kumar","patna","delhi"));
		collList.add(new CollegeStudent(15,"genius","mp","chnadigarh"));
		collList.add(new CollegeStudent(16,"developer","up","patliputra"));
		collList.add(new CollegeStudent(17,"engineer","rajsthan","patna"));
		
		List<Student> students = new ArrayList<>();
		
		findStudentWithSameState(students, schList, collList, "bihar");
		
		
		
		
		
		
		
		
		
		
		
		
///////////////////////////////////////		 PROBLEM -2            ////////////////////////////////////////////////
		
		
		List<Product> productList = new ArrayList<>();
		productList.add(new Product(1,"Mango",30,100));
		productList.add(new Product(2,"Grapes",20,400));
		productList.add(new Product(3,"Grpaes",33,400));
		productList.add(new Product(4,"Banana",20,300));
		productList.add(new Product(5,"pomegrannate",50,50));
		
		Collections.sort(productList,new Comparator<Product>() {

			@Override
			public int compare(Product p1, Product p2) {
				
				if(p1.getPrice()>p2.getPrice()) {
					return -1;
				}else if(p1.getPrice()<p2.getPrice()) {
					return 1;
				}else{
					if(p1.getProductName().compareTo(p2.getProductName()) == 0){
						if(p1.getProductId()>p2.getProductId()) {
							return -1;
						}else if(p1.getProductId()<p2.getProductId()) {
							return 1;
						}else {
							return 0;
						}
					}else {
						return p1.getProductName().compareTo(p2.getProductName());
					}
				}
			
			}
		});
		
		System.out.println(productList);		
		
	}
	
	static void findStudentWithSameState(List<Student> studentwithSameState,List<SchoolStudent> schoolStudent,
			List<CollegeStudent> collegeStudent,String state) {
		
		
		for(int i=0;i<schoolStudent.size();i++) {
			if(schoolStudent.get(i).state.equalsIgnoreCase(state)) {
				studentwithSameState.add(schoolStudent.get(i));
			}
			if(collegeStudent.get(i).state.equalsIgnoreCase(state)) {
				studentwithSameState.add(collegeStudent.get(i));
			}
		}
		
		
		System.out.println(studentwithSameState);
		
		
	}
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
}
