package Assignment3;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Assignment3Q8a {
	public static void failFast(Map<String, String> cityCode) {
		Iterator<Entry<String, String>> hmIterator = cityCode.entrySet().iterator();
		while (hmIterator.hasNext()) {
			System.out.println(hmIterator.next());
			cityCode.put("Neptune", "5"); // this line will through Exception because HashMap has fail-fast iterator. We can not do concurrent modification.
		}
	}

	public static void main(String[] args) {

		Map<String, String> map = new HashMap<>();
		map.put("Earth", "1");
		map.put("Mars", "2");
		map.put("Jupiter", "3");
		map.put("Pluto", "4");

		failFast(map);

	}
}
