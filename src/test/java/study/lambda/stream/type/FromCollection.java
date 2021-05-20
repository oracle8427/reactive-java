package study.lambda.stream.type;

import org.junit.jupiter.api.Test;
import study.lambda.stream.Student;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class FromCollection {
    @Test
    public void doTest() {
        List<Student> students = Arrays.asList(new Student("bey", 50), new Student("tony", 60));
        Stream<Student> stream = students.stream();
        stream.forEach(System.out::println);
    }
}
