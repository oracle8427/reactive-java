package study.lambda.function_api;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.DoubleFunction;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.IntToDoubleFunction;
import java.util.function.IntToLongFunction;
import java.util.function.LongToDoubleFunction;
import java.util.function.LongToIntFunction;
import java.util.function.ToDoubleBiFunction;

import org.junit.jupiter.api.Test;

public class FunctionExample {

	interface Product {
		String getName();

		int getPrice();
	}

	class Vegetable implements Product {
		private String name;
		private int price;

		Vegetable(String name, int price) {
			this.name = name;
			this.price = price;
		}

		@Override
		public String toString() {
			return "Vegetable [name=" + name + ", price=" + price + "]";
		}

		@Override
		public String getName() {
			return this.name;
		}

		@Override
		public int getPrice() {
			return price;
		}

	}

	class Fruit implements Product {
		private String name;
		private int price;

		Fruit(String name, int price) {
			this.name = name;
			this.price = price;
		}

		@Override
		public String toString() {
			return "Fruit [name=" + name + ", price=" + price + "]";
		}

		@Override
		public String getName() {
			return this.name;
		}

		@Override
		public int getPrice() {
			return this.price;
		}

	}

	class Promotion {
		List<Product> list;

		public Promotion() {
			list = new ArrayList<>();
		}

		public void add(Product product) {
			list.add(product);
		}

		@Override
		public String toString() {
			return "Promotion [list=" + list + "]";
		}
	}

	@Test
	public void doTest() {
		Function<Integer, Long> f = (integer) -> {
			long l = integer;
			return l * l;
		};
		System.out.println("Function<Integer, Long> -> " + f.toString());
		System.out.println("Function<Integer, Long> -> " + f.apply(Integer.MAX_VALUE).longValue());
		System.out.println("Function<Integer, Long> ->.compose() " + f.compose((i) -> {
			return new Integer((int) i);
		}).apply(50));

		System.out.println("Function<Integer, Long>.andThen() -> " + f.andThen((integer) -> {
			long l = integer;
			return l + l;
		}).apply(100));

		BiFunction<Product, Product, Promotion> bf = (a, b) -> {
			Promotion promotion = new Promotion();
			promotion.add(a);
			promotion.add(b);
			return promotion;
		};

		bf.apply(new Fruit("Apple", 1000), new Vegetable("Carrot", 820));
		System.out.println("\nBiFunction<Product, Product, Promotion> -> "
				+ bf.apply(new Fruit("Apple", 1000), new Vegetable("Carrot", 820)));

		DoubleFunction<Double> df = (d) -> {
			return Double.valueOf(d);
		};
		Double d = df.apply(125.4D);
		System.out.println("\nDoubleFunction<Double> -> " + d.doubleValue());

		IntFunction<Integer> intFunction = (i) -> {
			return Integer.valueOf(i);
		};
		System.out.println("\nIntFunction<Integer> -> " + intFunction.apply(5).intValue());

		IntToDoubleFunction itdf = (i) -> {
			return (double) i;
		};
		System.out.println("\nIntToDoubleFunction -> " + itdf.applyAsDouble(50));

		IntToLongFunction itlf = (i) -> {
			return i;
		};
		System.out.println("\nIntToLongFunction -> " + itlf.applyAsLong(6));

		LongToDoubleFunction ltdf = (l) -> {
			return (double) l;
		};
		System.out.println("\nLongToDoubleFunction -> " + ltdf.applyAsDouble(600L));

		LongToIntFunction ltif = (l) -> {
			if (l >= Integer.MAX_VALUE) {
				return Integer.MAX_VALUE;
			}
			return (int) l;
		};
		System.out.println("\nLongToIntFunction -> " + ltif.applyAsInt(100000000000000000L));
		System.out.println("LongToIntFunction -> " + ltif.applyAsInt(10L));

		ToDoubleBiFunction<Product, Product> tdbf = (a, b) -> {
			return a.getPrice() + b.getPrice();
		};
		System.out.println("\nToDoubleBiFunction<Product, Product> -> "
				+ tdbf.applyAsDouble(new Fruit("Apple", 1000), new Vegetable("Carrot", 820)));
	}
}
