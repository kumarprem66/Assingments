import java.util.*;

public class Main {
    
    public static void main(String[] args) {
		MyStack<String> st = new MyStack<>();
		Scanner sc = new Scanner(System.in);
		int start = 4;
		while(start>0) {
			System.out.println("Enter string");
			String s = sc.next();
			st.push(s);
			start--;
		}
		System.out.println(st.toString());
		
	}
}
