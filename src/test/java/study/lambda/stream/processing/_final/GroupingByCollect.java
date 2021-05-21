package study.lambda.stream.processing._final;


import org.junit.jupiter.api.Test;
import study.lambda.stream.Student;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Collector<T, ?, Map<K, List<T>> 			 groupingBy			 (Function<T, K> classifier)
 * Collector<T, ?, ConcurrentMap<K, List<T>> groupingByConcurrent(Function<T, K> classifier)
 * <p>
 * Collector<T, ?, Map<K, D>>			groupingBy			(Function<T, K> classifier, Collector<T, A, D) collector)
 * Collector<T, ?, ConcurrentMap<K, D>>	groupingByConcurrent(Function<T, K> classifier, Collector<T, A, D) collector)
 * <p>
 * Collector<T, ?, Map<K, D>> groupingBy (
 * Function<T, K> classifier,
 * Supplier<Map<K, D>> mapFactory,
 * Collector<T, A, D) collector
 * )
 * Collector<T, ?, ConcurrentMap<K, D>> groupingBy (
 * Function<T, K> classifier,
 * Supplier<Map<K, D>> mapFactory,
 * Collector<T, A, D) collector
 * )
 */
public class GroupingByCollect {

	@Test
	public void doTest() {
		List<Student> studentList = Arrays.asList(
				new Student("tony", 50, Student.Sex.MAIL),
				new Student("aria", 40, Student.Sex.FEMAIL),
				new Student("boris", 50, Student.Sex.MAIL),
				new Student("any", 60, Student.Sex.FEMAIL),
				new Student("bey", 60, Student.Sex.MAIL),
				new Student("popo", 70, Student.Sex.MAIL)
		);

		Function<Student, Student.Sex> classifier = Student::getSex;
		Collector<Student, ?, Map<Student.Sex, List<Student>>> collector = Collectors.groupingBy(classifier);
		Map<Student.Sex, List<Student>> mapBySex = studentList.stream().collect(collector);
		mapBySex.forEach((key, value) -> {
			System.out.println("[" + key + "]");
			value.forEach(student -> System.out.println("\t" + student));
			System.out.println();
		});

		// more simply
		studentList.stream().collect(Collectors.groupingBy(Student::getSex)).forEach((key, value) -> {
			System.out.println("[" + key + "]");
			value.forEach(student -> System.out.println("\t" + student));
			System.out.println();
		});

		// grouping by Collectors.mapping()
		studentList.stream().collect(
				Collectors.groupingBy(
						Student::getSex,
						Collectors.mapping(Student::getScore, Collectors.toList()))
		).forEach((key, value) -> {
			System.out.println("[" + key + "]");
			value.forEach(student -> System.out.println("\t" + student));
			System.out.println();
		});


		// TreeMap::new
		studentList.stream().collect(
				Collectors.groupingBy(
						Student::getSex,
						TreeMap::new,
						Collectors.mapping(Student::getScore, Collectors.toList()))
		).forEach((key, value) -> {
			System.out.println("[" + key + "]");
			value.forEach(student -> System.out.println("\t" + student));
			System.out.println();
		});

	}

}
