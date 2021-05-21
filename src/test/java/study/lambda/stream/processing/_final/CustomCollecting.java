package study.lambda.stream.processing._final;

import org.junit.jupiter.api.Test;
import study.lambda.stream.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CustomCollecting {

	class MailStudent {
		private final List<Student> list;

		public MailStudent() {
			list = new ArrayList<>();
			System.out.println("[" + Thread.currentThread().getName() + "] " + "MailStudent()");
		}

		public void accumulate(Student student) {
			list.add(student);
			System.out.println("[" + Thread.currentThread().getName() + "] " + "accumulate(Student)");
		}

		public void combine(MailStudent other) {
			list.addAll(other.getList());
			System.out.println("[" + Thread.currentThread().getName() + "] " + "combine(MailStudent)");
		}

		public List<Student> getList() {
			return list;
		}
	}

	@Test
	public void doTest() {
		List<Student> students = Arrays.asList(
				new Student("tony", 50, Student.Sex.MAIL),
				new Student("aria", 40, Student.Sex.FEMAIL),
				new Student("boris", 50, Student.Sex.MAIL),
				new Student("any", 60, Student.Sex.FEMAIL),
				new Student("bey", 60, Student.Sex.MAIL),
				new Student("popo", 70, Student.Sex.MAIL)
		);

		Stream<Student> mailStream = students.stream().filter(s -> s.getSex() == Student.Sex.MAIL);
		Supplier<MailStudent> supplier = MailStudent::new;
		BiConsumer<MailStudent, Student> accumulator = (mailStudent, student) -> mailStudent.accumulate(student);
		BiConsumer<MailStudent, MailStudent> combiner = (mailStudent1, mailStudent2) -> mailStudent1.combine(mailStudent2);
		MailStudent mailStudent = mailStream.collect(supplier, accumulator, combiner);
		for (Student student : mailStudent.getList())
			System.out.println(student);

		// more simply
		mailStudent = students.stream()
				.filter(s -> s.getSex() == Student.Sex.MAIL)
				.collect(MailStudent::new,
						MailStudent::accumulate,
						MailStudent::combine);
		for (Student student : mailStudent.getList())
			System.out.println(student);

		mailStudent = students.parallelStream()
				.filter(s -> s.getSex() == Student.Sex.MAIL)
				.collect(MailStudent::new,
						MailStudent::accumulate,
						MailStudent::combine);
		for (Student student : mailStudent.getList())
			System.out.println(student);

	}
}
