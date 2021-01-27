package Assignment4;

public class Assignment4Q1 {
	
	MyFun myAdd = (a, b) -> a + b;
	MyFun mySub = (a, b) -> a - b;
	MyFun myMul = (a, b) -> a * b;
	MyFun myDiv = (a, b) -> a / b;
	
	public double addition(int num1, int num2) {
		return myAdd.cal(13, 5);
	}

	public double subtraction(int num1, int num2) {
		return mySub.cal(13, 5);
	}

	public double multiplication(int num1, int num2) {
		return myMul.cal(13, 5);
	}

	public double division(double num1, double num2) {
		return myDiv.cal(13, 5);
	}

	public static void main(String[] args) {

	}
}

interface MyFun {
	double cal(double x, double y);
}
