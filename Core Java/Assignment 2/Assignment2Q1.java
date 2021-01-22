package Assigment2;

class SingletonInheritanceCheck{
	static SingletonInheritanceCheck obj = new SingletonInheritanceCheck();
	
	private SingletonInheritanceCheck(){
	}
	
	public static SingletonInheritanceCheck getInstance() {
		return obj;
	}
}


public class Assignment2Q1 {
	public static void main(String[] args) {
		
		SingletonInheritanceCheck myObject = SingletonInheritanceCheck.getInstance();
	}
}