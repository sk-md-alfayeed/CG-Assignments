package Assigment2;

// • If any class has any of its method abstract then you must declare entire class abstract.
//abstract class
 abstract class AbstractClass {
	
	//abstract method
	public abstract int checkAdd();

	//non-abstract method
	public int CheckAdd2() {
		return 0;
	}
}

//• Abstract class cannot be private.
//private abstract class AbstractClassPrivate {
//
//	}

//• Abstract class cannot be final.
//final abstract class AbstractClassFinal {
//
//	}

 
//• You can declare a class abstract without having any abstract method.
abstract class AbstractClassWithoutAnyMethod {

}




//• When we extend an abstract class, we must either override all the abstract methods in sub class or declare subclass as abstract.
class NonAbstractClass extends AbstractClass {

	public int checkAdd() {
		return 0;
	}

	public int CheckAdd2() {
		return 1;
	}

}

public class Assignment2Q4 {
	public static void main(String[] arg) {
		
		//• Abstract class cannot be instantiated.
		//AbstractClass myAbs = new AbstractClass();
	}
	
	
}
