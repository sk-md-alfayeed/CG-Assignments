package Assignment3;

import java.util.Comparator;
import java.util.TreeSet;

class Person {
	private String name;
	private int height;
	private double weight;

	public Person(String name, int height, double weight) {
		this.name = name;
		this.height = height;
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public int getHeight() {
		return height;
	}

	public double getWeight() {
		return weight;
	}

}

class Sort implements Comparator<Person> {

	@Override
	public int compare(Person p1, Person p2) {
		if (p1.getWeight() > p2.getWeight()) {
			return 1;
		} else if (p1.getWeight() == p2.getWeight()) {
			if (p1.getHeight() > p2.getHeight()) {
				return 1;
			} else {
				return -1;
			}
		}

		return -1;

	}
}

public class Assignment3Q1 {
	public static void main(String[] args) {

		Person per1 = new Person("Alpha", 180, 75);
		Person per2 = new Person("Bravo", 181, 74);
		Person per3 = new Person("Charlie", 170, 70);
		Person per4 = new Person("Delta", 165, 60);
		Person per5 = new Person("Echo", 169, 65);
		Person per6 = new Person("Foxtrot", 165, 59);

		TreeSet<Person> person = new TreeSet<>(new Sort());
		person.add(per1);
		person.add(per2);
		person.add(per3);
		person.add(per4);
		person.add(per5);
		person.add(per6);

		for (Person e : person) {
			System.out.println(e.getName() +", "+ e.getHeight() +", "+ e.getWeight());
		}
	}
}