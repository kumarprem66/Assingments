package conceptexplainer;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		List<Integer> list = new LinkedList<>();
		list.add(23);
		list.add(34);
		list.add(45);
		list.add(67);
		
		Comparator<Integer> c = (a,b)->b-a;
		Collections.sort(list,c);
		
		System.out.println(list);
			
		
		
	}

}
