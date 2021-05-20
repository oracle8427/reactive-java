package study.lambda.stream.processing.intermediate;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * [ Return ]	|			[ Parameters ]					|   [ Mapping Type ]
 * Stream<R>	| flatMap(Function<T, Stream<R>>)			| T 	-> Stream<R>
 * DoubleStream | flatMap(DoubleFunction<DoubleStream>)		| double-> DoubleStream
 * IntStream	| flatMap(IntFunction<IntStream>)			| int	-> IntStream
 * LongStream	| flatMap(LongFunction<LongStream>)			| long	-> LongStream
 * DoubleStream | flatMapToDouble(Function<T, DoubleStream>)| T 	-> DoubleStream
 * IntStream	| flatMapToInt	 (Function<T, IntStream>)	| T 	-> IntStream
 * LongStream	| flatMapToLong	 (Function<T, LongStream>)	| T 	-> LongStream
 */
public class FlatMapping {
	@Test
	public void doTest() {
		Stream<String> stream = Stream.of("red pig", "white pig", "black pig", "pink pig");
		stream.flatMap((pig) -> Arrays.stream(pig.split(" ")))
				.distinct()
				.forEach(System.out::println);

		Stream<String> stream2 = Stream.of("10, 20, 30", "40, 50, 60", "70, 80");
		stream2.flatMapToInt(data -> {
			String[] strArray = data.split(",");
			int[] intArray = new int[strArray.length];
			for (int i = 0; i < strArray.length; i++)
				intArray[i] = Integer.parseInt(strArray[i].trim());
			return Arrays.stream(intArray);
		}).forEach(System.out::println);
	}
}
