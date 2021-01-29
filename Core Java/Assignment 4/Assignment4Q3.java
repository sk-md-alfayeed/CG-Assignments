package Assignment4;

import java.util.function.*;

public class Assignment4Q3 {

	static int modifyValue(int value, Function<Integer, Integer> function) {
		int output = function.apply(value);
		System.out.println(output);
		return output;
	}

	static class Product {

		private double price = 0.0;

		public void setPrice(double price) {
			this.price = price;
		}

		public void printPrice() {
			System.out.println(price);
		}
	}

	static void display() {
		// Consumer
		Consumer<Integer> display = a -> System.out.println(a);
		display.accept(100);

		// Functional
		Function<Integer, Double> half = a -> a / 10.0;
		System.out.println(half.apply(100));

		// Predicate
		Predicate<Integer> pr = a -> (a > 10);
		System.out.println(pr.test(12));
		
		//Supplier
		Supplier<Integer> arg = ()-> 10;
		System.out.println(arg.get());
	}

	public static void main(String[] args) {
		// All
		display();

		// Functional Interface
		modifyValue(5, v -> v + 10);

		// Consumer Interface
		Consumer<Product> getPrice = p -> p.setPrice(92.1);
		Product p = new Product();
		getPrice.accept(p);
		p.printPrice();

	}

}