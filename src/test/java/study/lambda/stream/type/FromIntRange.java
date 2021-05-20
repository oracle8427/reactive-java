package study.lambda.stream.type;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

public class FromIntRange {
    private int sum = 0;

    @Test
    public void doTest() {
        IntStream stream = IntStream.rangeClosed(1, 100);
        stream.forEach((i) -> sum += i);
        System.out.println("Sum: " + sum);
    }
}
