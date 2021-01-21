class ArmstrongOrNot {
	public boolean armstrongCheck(int num) {

		String s = String.valueOf(num);
		int size = s.length();
		int total = 0;
		int myNum = num;

		for (int i = 0; i < size; i++) {
			if (myNum > 0) {
				int temp = myNum % 10;
				total += Math.pow(temp, size);
				myNum = myNum / 10;
			}
		}
		if (num == total) {
			return true;
		} else {
			return false;
		}
	}
}

public class Assignment1Q1 {
	public static void main(String[] args) {
		ArmstrongOrNot myClass = new ArmstrongOrNot();
		System.out.println(myClass.armstrongCheck(371));
	}
}