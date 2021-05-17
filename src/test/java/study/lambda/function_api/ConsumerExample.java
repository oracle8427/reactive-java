package study.lambda.function_api;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;
import java.util.function.ObjDoubleConsumer;
import java.util.function.ObjIntConsumer;
import java.util.function.ObjLongConsumer;

import org.junit.jupiter.api.Test;

public class ConsumerExample {

	@Test
	public void doTest() {
		Consumer<String> consumer = t -> System.out.println("Hello " + t);
		consumer.accept("World");
		consumer.andThen(t -> System.out.println("Bye " + t)).accept("world");

		BiConsumer<String, String> biConsumer = (t, u) -> System.out.println(t + u);
		biConsumer.accept("Hello", " World");

		DoubleConsumer doubleConsumer = d -> System.out.println(d);
		doubleConsumer.accept(10.0D);

		IntConsumer intConsumer = i -> System.out.println(i);
		intConsumer.accept(10);

		LongConsumer longConsumer = l -> System.out.println(l);
		longConsumer.accept(100L);

		ObjDoubleConsumer<String> objDoubleConsumer = (str, d) -> System.out.println(str + d);
		objDoubleConsumer.accept("ObjDoubleConsumer -> ", 100.0D);

		ObjIntConsumer<String> objIntConsumer = (str, i) -> System.out.println(str + i);
		objIntConsumer.accept("ObjIntConsumer -> ", 3);

		ObjLongConsumer<String> objLongConsumer = (str, l) -> System.out.println(str + l);
		objLongConsumer.accept("ObjLongConuser -> ", 1000000000000000L);
	}
}
