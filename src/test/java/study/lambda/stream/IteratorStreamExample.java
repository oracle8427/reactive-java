package study.lambda.stream;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

public class IteratorStreamExample {

	@Test
	public void doTest() {
		System.out.println("Java8 ▼");
		List<String> list = Arrays.asList("a", "b", "c", "d");
		Iterator<String> iter = list.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}

		System.out.println("\nJava8 ▲");
		Stream<String> stream = list.stream();
		stream.forEach((s) -> System.out.println(s));

		System.out.println("\nObject");
		List<Student> students = Arrays.asList(
				new Student("alex", 80), 
				new Student("tony", 90), 
				new Student("bey", 80));

		students.forEach((student) -> System.out.println(student));
	}
}
