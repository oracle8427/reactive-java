package study.lambda.stream.processing.intermediate;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Looping {

	@Test
	public void doTest() {
		int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

		int sum = Arrays.stream(array).filter(i -> i % 2 == 0).sum();
		System.out.println("Sum: " + sum);
		System.out.println();

		// Error: Arrays.stream(array).filter(i -> i % 2 == 0).forEach(System.out::println).sum();
		// forEach : Final Processing

		// Error: Arrays.stream(array).filter(i -> i % 2 == 0).peek(System.out::println);
		// peek : defer method

		sum = Arrays.stream(array).filter(i -> i % 2 == 0).peek(System.out::println).sum();
		System.out.println("Sum: " + sum);
	}
}
