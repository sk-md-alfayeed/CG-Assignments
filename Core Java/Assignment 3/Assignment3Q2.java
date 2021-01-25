package Assignment3;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class Assignment3Q2 {
    public static void main(String[] args) {
    	LinkedHashSet<Integer> lHSet = new LinkedHashSet<>();
    	lHSet.add(10);
    	lHSet.add(12);
    	lHSet.add(20);
    	lHSet.add(11);
    	lHSet.add(19);
    	if(lHSet == ordered(lHSet)) {
    		System.out.println("ordered");
    	}
    	else {
    	System.out.println("unordered");}
    	System.out.println(ordered(lHSet));
    	
    	HashSet<Integer> hSet = new HashSet<>();
    	hSet.add(10);
    	hSet.add(12);
    	hSet.add(20);
    	hSet.add(11);
    	hSet.add(19);
    	if(lHSet == unordered(hSet)) {
    		System.out.println("ordered");
    	}
    	else {
        	System.out.println("unordered");}
    	System.out.println(unordered(hSet));
    	
    	
    	
    }
    public static LinkedHashSet<?> ordered(LinkedHashSet<?> linkedHashSet){ 
    	return linkedHashSet;
    }
    public static HashSet<?> unordered(HashSet<?> hashSet){
    	return hashSet;
    }
}