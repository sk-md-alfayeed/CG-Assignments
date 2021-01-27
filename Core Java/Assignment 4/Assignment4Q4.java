package Assignment4;

import java.util.ArrayList;

public class Assignment4Q4 {
	
    public ArrayList<String> removeOddLength(ArrayList<String> employeeList){
    	employeeList.removeIf(a -> a.length()%2 !=0);
    	return employeeList;
    }
    public static void main(String[] args) {
    	Assignment4Q4 assign = new Assignment4Q4();
    	ArrayList<String> eList = new ArrayList<>();
    	
    	eList.add("One");
    	eList.add("Three");
    	eList.add("Four");
    	eList.add("Five");
    	eList.add("Six");
    	System.out.println(assign.removeOddLength(eList));
    }
}