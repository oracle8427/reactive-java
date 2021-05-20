package study.lambda.stream.processing._final;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.IntStream;

/**
 * [ Return ]		|	[ Parameters ]
 * long				| count()
 * OptionalXXX		| findFirst()
 * Optional<T>		| max(), max(Comparator<T>)
 * OptionalXXX		| max(), max(Comparator<T>)
 * Optional<T>		| min(), min(Comparator<T>)
 * OptionalXXX		| min(), min(Comparator<T>)
 * OptionalDouble	| average()
 * int,long,double	| sum()
 */
public class Aggregation {

	@Test
	public void doTest() {
		int[] array = {1, 2, 3, 4, 5, 6};
		long evenCnt = Arrays.stream(array).filter(i -> i % 2 == 0).count();
		System.out.println("Count of Even Numbers: " + evenCnt);

		int sum = Arrays.stream(array).filter(i -> i % 2 == 0).sum();
		System.out.println("Sum of Even Numbers: " + sum);

		OptionalDouble average = Arrays.stream(array).filter(i -> i % 2 == 0).average();
		average.ifPresent((d) -> System.out.println("Average of Even Numbers : " + d));

		OptionalInt max = Arrays.stream(array).filter(i -> i % 2 == 0).max();
		max.ifPresent((i) -> System.out.println("Maximum of Even Numbers: " + i));

		OptionalInt min = Arrays.stream(array).filter(i -> i % 2 == 0).min();
		min.ifPresent((i) -> System.out.println("Minimum of Even Numbers: " + i));

		OptionalInt first =  Arrays.stream(array).filter(i -> i % 2 == 0).findFirst();
		first.ifPresent((i) -> System.out.println("First: " + i));

	}
}
