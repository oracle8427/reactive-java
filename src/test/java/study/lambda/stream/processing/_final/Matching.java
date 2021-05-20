package study.lambda.stream.processing._final;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * [ Parameters ]				  		[ Mapping Type ]
 * allMatch (Predicate<T> predicate)	| Stream
 * anyMatch (Predicate<T> predicate)
 * noneMatch(Predicate<T> predicate)
 * <p>
 * allMatch (IntPredicate predicate)	| IntStream
 * anyMatch (IntPredicate predicate)
 * noneMatch(IntPredicate predicate)
 * <p>
 * allMatch (LongPredicate predicate)	| LongStream
 * anyMatch (LongPredicate predicate)
 * noneMatch(LongPredicate predicate)
 * <p>
 * allMatch (DoublePredicate predicate) | DoubleStream
 * anyMatch (DoublePredicate predicate)
 * noneMatch(DoublePredicate predicate)
 */
public class Matching {

	@Test
	public void doTest() {
		int[] array = {2, 4, 6, 8, 10};
		boolean allMatch = Arrays.stream(array).allMatch(i -> i % 2 == 0);
		System.out.println("allMatch( i % 2 == 0) -> " + allMatch);

		boolean anyMatch = Arrays.stream(array).anyMatch(i -> i % 3 == 0);
		System.out.println("anyMatch( i % 3 == 0) -> " + anyMatch);

		boolean noneMatch = Arrays.stream(array).noneMatch(i -> i % 3 == 0);
		System.out.println("noneMatch( i % 3 == 0) -> " + noneMatch);
	}

}
