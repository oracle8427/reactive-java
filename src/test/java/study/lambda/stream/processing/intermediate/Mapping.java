package study.lambda.stream.processing.intermediate;

import org.junit.jupiter.api.Test;
import study.lambda.stream.Student;

import java.util.Arrays;
import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

/**
 * [ Return ]	|			[ Parameters ]			|   [ Mapping Type ]
 * Stream<R>	| map(Function<T,R>)				| T -> R
 * DoubleStream	| mapToDouble(ToDoubleFunction<T>)	| T -> double
 * IntStream	| mapToInt(ToIntFunction<T>)		| T -> int
 * LongStream	| mapToLong(ToLongFunction<T>)		| T -> long
 * <p>
 * DoubleStream | map(DoubleUnaryOperator)			| double -> double
 * IntStream	| mapToInt(DoubleToIntFunction)		| double -> int
 * LongStream	| mapToLong(DoubleToLongFunction)	| double -> long
 * Stream<U>	| mapToObj(DoubleFunction<U>)		| double -> U
 * <p>
 * IntStream	| map(IntUnaryOperator)				| int -> int
 * DoubleStream | mapToDouble(IntToDoubleFunction)	| int -> double
 * LongStream	| mapToLong(IntToLongFunction)		| int -> long
 * Stream<U>	| mapToObj(IntFunction<U>)			| int -> U
 * <p>
 * LongStream	| map(LongUnaryOperator)			| long -> long
 * DoubleStream	| mapToDouble(LongToDoubleFunction)	| long -> U
 * IntStream	| mapToInt(LongToIntFunction)		| long -> int
 * Stream<U>	| mapToObj(LongFunction<U>)			| long -> U
 */
public class Mapping {

	@Test
	public void doTest() {
		List<Student> students = Arrays.asList(
				new Student("hong", 10),
				new Student("shin", 20),
				new Student("kim", 30)
		);

		students.stream().mapToInt(Student::getScore).forEach(System.out::println);
		students.stream().mapToDouble(Student::getScore).forEach(System.out::println);
		students.stream().mapToLong(Student::getScore).forEach(System.out::println);

		IntStream intStream = students.stream().mapToInt(Student::getScore);
		DoubleStream doubleStream = intStream.asDoubleStream();
		doubleStream.boxed().forEach(d -> System.out.println(d.doubleValue())); // wrapper class : Double
	}
}
