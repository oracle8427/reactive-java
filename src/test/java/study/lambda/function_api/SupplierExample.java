package study.lambda.function_api;

import java.util.Random;
import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;
import java.util.function.IntSupplier;
import java.util.function.LongSupplier;
import java.util.function.Supplier;

import org.junit.jupiter.api.Test;

public class SupplierExample {

	@Test
	public void doTest() {
		Supplier<String> supplier = () -> {
			return "Hello Supplier";
		};
		System.out.println(supplier.get());

		BooleanSupplier bolleanSupplier = () -> {
			return false;
		};
		System.out.println(bolleanSupplier.getAsBoolean());

		DoubleSupplier doubleSupplier = () -> {
			return 10.0D;
		};
		System.out.println(doubleSupplier.getAsDouble());

		IntSupplier intSupplier = () -> {
			return 50;
		};
		System.out.println(intSupplier.getAsInt());

		final Random r = new Random();
		LongSupplier longSupplier = () -> {
			return r.nextLong();
		};
		System.out.println(longSupplier.getAsLong());
	}
}
