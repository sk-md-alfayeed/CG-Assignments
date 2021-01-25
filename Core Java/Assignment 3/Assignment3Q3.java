package Assignment3;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Assignment3Q3 {
	public static List traverseReverse(ArrayList aList) {
		List list = new ArrayList();

		ListIterator listIterator = aList.listIterator(aList.size());
		while (listIterator.hasPrevious()) {
			list.add(listIterator.previous());
		}
		return list;
	}

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();

		list.add(10);
		list.add(20);
		list.add(40);
		list.add(60);
		list.add(30);
		list.add(50);

		traverseReverse(list);
		System.out.println(traverseReverse(list));

	}
}
