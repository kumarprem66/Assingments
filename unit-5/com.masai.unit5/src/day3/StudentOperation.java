package day3;
import java.util.*;
import java.util.function.Supplier;

public class StudentOperation {

	static Optional<List<Student>> findStudent(List<Student> studentList){
		
		List<Student> stud = new ArrayList<>();
		
		for(int i=0;i<studentList.size();i++) {
			
			if(studentList.get(i).getMarks()>55) {
				stud.add(studentList.get(i));
			}
			
		}
		
		Optional<List<Student>> ols = Optional.ofNullable(stud);
		return ols;
	}
	
	static int getOutStandingStudentCount(List<Student> studentList) throws NoStudentPassedException{
		
		Optional<List<Student>> ols = findStudent(studentList);
		Supplier<NoStudentPassedException> s = new Supplier<NoStudentPassedException>() {

			@Override
			public NoStudentPassedException get() {
				// TODO Auto-generated method stub
				return new NoStudentPassedException("No Student is Passed");
			}
			
		};
		
		ols.orElseThrow(s);
		
		
		return ols.get().size();

	}
}
