package study.lambda.stream.processing._final;

import org.junit.jupiter.api.Test;
import study.lambda.stream.Student;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * T : Element
 * A : Accumulator
 * R : Collection
 * <p>
 * Collector<T, ?, List<T>>				| toList()
 * Collector<T, ?, SET<T>>				| toSet()
 * Collector<T, ?, Collection<T>>		| toCollection( Supplier<Collection<T>> )
 * Collector<T, ?, Map<K,U>>			| toMap(Function<T, K> keyMapper, Function<T, U> valueMapper )
 * Collector<T, ?, ConcurrentMap<K, U>> | toConcurrentMap(Function<T, K> keyMapper, Function<T, U> valueMapper )
 */
public class Collect {

	@Test
	public void doTest() {
		List<Student> studentList = Arrays.asList(
				new Student("amy", 60),
				new Student("mark", 20),
				new Student("rin", 75),
				new Student("ming", 90),
				new Student("hog", 40),
				new Student("bey", 40)
		);

		List<Student> toList = studentList.stream().filter((s) -> s.getScore() <= 60).collect(Collectors.toList());
		System.out.println("toList: " + toList.size());

		// default -> HashSet
		Set<Student> toSet = studentList.stream().filter((s) -> s.getScore() <= 60).collect(Collectors.toSet());
		System.out.println("toSet: " + toSet.size());

		Supplier<TreeSet<Integer>> supplier = TreeSet::new;
		TreeSet<Integer> t = studentList.stream().map(Student::getScore).filter(score -> score <= 60).collect(Collectors.toCollection(supplier));
		System.out.println("Supplier<TreeSet<Integer>>: " + t.size());

		Map<String, Student> map = studentList.stream().filter((s) -> s.getScore() <= 60).collect(Collectors.toMap(Student::getName, student -> student));
		for (String key : map.keySet())
			System.out.println(key + " : " + map.get(key));
	}
}
