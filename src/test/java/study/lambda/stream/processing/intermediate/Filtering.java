package study.lambda.stream.processing.intermediate;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class Filtering {

	@Test
	public void doTest() {
		List<String> list = Arrays.asList("a", "b", "c", "d", "a", "b");

		System.out.println("distinct()");
		list.stream().distinct().forEach(System.out::println);

		System.out.println("\nfilter()");
		list.stream().filter((s) -> s.equals("a"))
				.forEach(System.out::println);

	}
}
