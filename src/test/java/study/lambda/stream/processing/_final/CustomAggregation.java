package study.lambda.stream.processing._final;

import org.junit.jupiter.api.Test;
import study.lambda.stream.Student;

import java.util.Arrays;
import java.util.List;

public class CustomAggregation {
	@Test
	public void doTest() {
		List<Student> studentList = Arrays.asList(
				new Student("amy", 60),
				new Student("mark", 20),
				new Student("rin", 75)
		);

		// studentList.clear();
		// NoSuchElementException
		int sum = studentList.stream().map(Student::getScore).reduce(Integer::sum).get();
		System.out.println("reduce(Integer::sum): " + sum);

		// return identity: 0
		sum = studentList.stream().map(Student::getScore).reduce(0, Integer::sum);
		System.out.println("reduce(0, Integer::sum): " + sum);

	}

}
