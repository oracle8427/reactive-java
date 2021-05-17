package study.lambda.function_api;

import java.util.function.BinaryOperator;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleUnaryOperator;
import java.util.function.IntBinaryOperator;
import java.util.function.IntUnaryOperator;
import java.util.function.LongBinaryOperator;
import java.util.function.LongUnaryOperator;
import java.util.function.UnaryOperator;

import org.junit.jupiter.api.Test;

public class OperatorExample {

	class Fruit {

		private String name;
		private int price;

		public Fruit(String name, int price) {
			this.name = name;
			this.price = price;
		}

		public String getName() {
			return name;
		}

		public int getPrice() {
			return price;
		}

		@Override
		public String toString() {
			return "Fruit [name=" + name + ", price=" + price + "]";
		}

	}

	@Test
	public void doTest() {
		BinaryOperator<Integer> bo = (a, b) -> {
			long r = a * b;
			if (r >= Integer.MAX_VALUE)
				return Integer.MAX_VALUE;
			return (int) r;
		};
		System.out.println("BinaryOperator<Integer> -> " + bo.apply(10, 10));

		BinaryOperator<Fruit> binaryOperator;
		binaryOperator = BinaryOperator.minBy((a, b) -> {
			return Integer.compare(a.getPrice(), b.getPrice());
		});
		System.out.println("BinaryOperator<Fruit>.minBy -> "
				+ binaryOperator.apply(new Fruit("apple", 100), new Fruit("mango", 500)));

		binaryOperator = BinaryOperator.maxBy((a, b) -> {
			return Integer.compare(a.getPrice(), b.getPrice());
		});
		System.out.println("BinaryOperator<Fruit>.maxBy -> "
				+ binaryOperator.apply(new Fruit("apple", 100), new Fruit("mango", 500)));

		UnaryOperator<Integer> uo = (t) -> {
			return t + 1;
		};
		System.out.println("\nUnaryOperator<Integer> -> " + uo.apply(5));

		DoubleBinaryOperator dbo = (a, b) -> {
			return a + b;
		};
		System.out.println("\nDoubleBinaryOperator -> " + dbo.applyAsDouble(10D, 20D));

		DoubleUnaryOperator duo = (d) -> {
			return d * 10;
		};
		System.out.println("\nDoubleUnaryOperator -> " + duo.applyAsDouble(5D));

		IntBinaryOperator ibo = (a, b) -> {
			return a + b;
		};
		System.out.println("\nIntBinaryOperator -> " + ibo.applyAsInt(10, 5));

		IntUnaryOperator iuo = (i) -> {
			return i * 20;
		};
		System.out.println("\nIntUnaryOperator -> " + iuo.applyAsInt(50));

		LongBinaryOperator lbo = (a, b) -> {
			return a * b;
		};
		System.out.println("\nLongBinaryOperator -> " + lbo.applyAsLong(10L, 5L));
		LongUnaryOperator luo = (l) -> {
			return l * 10;
		};
		System.out.println("\nLongUnaryOperator -> " + luo.applyAsLong(5L));
	}
}
