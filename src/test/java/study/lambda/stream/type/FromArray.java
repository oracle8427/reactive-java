package study.lambda.stream.type;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Stream;

public class FromArray {
    @Test
    public void doTest() {
        Stream<String> stream = Arrays.stream(new String[]{"a", "b", "c"});
        stream.forEach(System.out::println);
    }
}
