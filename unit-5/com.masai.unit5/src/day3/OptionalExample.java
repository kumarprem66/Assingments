 package day3;

import java.util.Optional;

public class OptionalExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		String str = "prem";
		Optional<String> optional = Optional.ofNullable(str);
		System.out.println(optional.isPresent());
		System.out.println(optional.get());
		System.out.println(optional.orElse("null"));
	}

}
