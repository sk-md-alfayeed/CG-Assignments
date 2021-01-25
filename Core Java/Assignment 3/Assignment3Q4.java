package Assignment3;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

class DateClass {
	private int date;
	private int month;
	private int year;

	public DateClass(int date, int month, int year) {
		this.date = date;
		this.month = month;
		this.year = year;
	}

	public DateClass() {
		// TODO Auto-generated constructor stub
	}

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public int hashCode() {
		return Objects.hash(date, month);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DateClass other = (DateClass) obj;
		return date == other.date && month == other.month;
	}
}

public class Assignment3Q4 {

	public String getEmployee(HashMap<DateClass, String> dob, String employeeName) {
		Set<Map.Entry<DateClass, String>> empEntry = dob.entrySet();
		for (Map.Entry<DateClass, String> emp : empEntry) {
			if (emp.getValue().equals(employeeName)) {
				return employeeName;
			}
		}
		return "get method fails";
	}

	public static void main(String[] args) {

		HashMap<DateClass, String> hashMap = new HashMap<>();

//		DateClass d1 = new DateClass(10, 10, 2002);
//		DateClass d2 = new DateClass(11, 12, 2001);
//		DateClass d3 = new DateClass(11, 9, 2000);
//		DateClass d4 = new DateClass(10, 10, 2003);
//		DateClass d5 = new DateClass(16, 8, 2002);
//
//		hashMap.put(d1, "Alpha");
//		hashMap.put(d2, "Bravo");
//		hashMap.put(d3, "Charlie");
//		hashMap.put(d4, "Delta");
//		hashMap.put(d5, "Echo");

		DateClass d1 = new DateClass(10, 10, 2002);
		DateClass d2 = new DateClass(10, 10, 2001);

		hashMap.put(d1, "Ajay2");
		hashMap.put(d2, "Ajay");

//same test case working on local machine, but not working on online compiler.
		
		Assignment3Q4 assign = new Assignment3Q4();
		System.out.println(assign.getEmployee(hashMap, "Ajay2"));
		System.out.println(assign.getEmployee(hashMap, "Ajay"));

	}
}