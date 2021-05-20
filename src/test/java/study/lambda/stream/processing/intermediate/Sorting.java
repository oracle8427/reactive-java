package study.lambda.stream.processing.intermediate;

import org.junit.jupiter.api.Test;
import study.lambda.stream.Student;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class Sorting {

	@Test
	public void doTest() {
		List<Student> studentList = Arrays.asList(
				new Student("amy", 60),
				new Student("mark", 20),
				new Student("rin", 75)
		);

		// "(s1, s2) -> return Integer.compare(s1.getScore(), s2.getScore()"-> Comparator.comparingInt(Student::getScore)
		studentList.stream().sorted(Comparator.comparingInt(Student::getScore))
				.forEach(System.out::println);


		IntStream intStream = Arrays.stream(new int[]{1, 5, 4, 3, 6, 10});
		intStream.sorted().forEach(System.out::println);
	}
}
