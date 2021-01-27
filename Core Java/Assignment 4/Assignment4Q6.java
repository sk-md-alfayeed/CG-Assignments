package Assignment4;

import java.util.*;
import java.util.function.UnaryOperator;

public class Assignment4Q6 {
	public static void main(String[] args) {
		
		List<String> list = new ArrayList<String>();
		list.add("Alpha");
		list.add("Bravo");
		list.add("Charlie");
		list.add("Delta");
		
		Assignment4Q6 assign = new Assignment4Q6();
		
		System.out.println(assign.convertToUpperCase(list));
	}

	public List<String> convertToUpperCase(List<String> list) {

		UnaryOperator<String> toUpper = str -> str.toUpperCase();

		list.replaceAll(toUpper);

		return list;
	}

}
