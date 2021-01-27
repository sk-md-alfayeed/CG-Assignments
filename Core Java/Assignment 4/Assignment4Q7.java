package Assignment4;

import java.util.*;
//import java.util.function.Consumer;
//import java.util.stream.Collectors;

public class Assignment4Q7 {
	public static void main(String[] args) {

		HashMap<String, Integer> hashMap = new HashMap<>();
		hashMap.put("Alpha", 1);
		hashMap.put("Bravo", 2);
		hashMap.put("Charlie", 3);
		hashMap.put("Delta", 4);

		Assignment4Q7 assign = new Assignment4Q7();

		System.out.println(assign.convertKeyValueToString(hashMap));

	}

	public String convertKeyValueToString(HashMap<String, Integer> map) {
		StringBuffer sb = new StringBuffer();
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			sb.append(entry.getKey());
			sb.append(entry.getValue());
		}
		return sb.toString();

//		//Using Stream
//		String result = map.entrySet().stream().map(entry -> entry.getKey() + entry.getValue())
//				.collect(Collectors.joining(""));
//		return result;

	}
}
