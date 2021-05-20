package study.lambda.stream.processing._final;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

public class OptionalExample {

	@Test
	public void doTest() {
		List<Integer> list = new ArrayList<>();
		OptionalDouble optionalDouble = list.stream().mapToInt(Integer::intValue).average();
		if (optionalDouble.isPresent()) {
			System.out.println("Average: " + optionalDouble.getAsDouble());
		} else {
			System.out.println("Average: None");
		}

		double avg = list.stream().mapToInt(Integer::intValue).average().orElse(0.0);
		System.out.println("Average: " + avg);

		list.stream().mapToInt(Integer::intValue).average().ifPresent(d -> System.out.println("Average: " + d));
	}
}
