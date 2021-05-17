package study.lambda.function_api;

import java.util.function.BiPredicate;
import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;
import java.util.function.Predicate;

import org.junit.jupiter.api.Test;

public class PredicateExample {

	@Test
	public void doTest() {
		Predicate<String> isBlank = (str) -> (str == null || str.trim().length() == 0);
		System.out.println("Predicate<String> isBlank? " + isBlank.test(null));
		System.out.println("Predicate<String> isBlank? " + isBlank.test(""));
		System.out.println("Predicate<String> isBlank? " + isBlank.test("Hello"));

		Predicate<String> isEqual;
		isEqual = Predicate.isEqual(null);
		System.out.println("Predicate.isEqual -> " + isEqual.test(null));

		isEqual = Predicate.isEqual("test");
		System.out.println("Predicate.isEqual -> " + isEqual.test("test"));
		System.out.println("Predicate.isEqual -> " + isEqual.test("tes"));

		BiPredicate<String, String> equeals = (a, b) -> (a.equals(b));
		System.out.println("\nBiPredicate<String, String> equeals? " + equeals.test("a", "b"));
		System.out.println("BiPredicate<String, String> equeals? " + equeals.test("a", "a"));

		DoublePredicate dp = (d) -> (d < 10D);
		System.out.println("\nDoublePredicate -> " + dp.test(5D));

		IntPredicate ip = (i) -> (i < 10);
		System.out.println("\nIntPredicate -> " + ip.test(5));

		LongPredicate lp = (l) -> (l < 10L);
		System.out.println("\nLongPredicate -> " + lp.test(5L));
		System.out.println("LongPredicate.negate() -> " + lp.negate().test(5L));

		isBlank = (str) -> str == null;
		System.out.println(
				"\nPredicate<String>.and() -> " + isBlank.and((str) -> str.trim().length() == 0).test("Hello"));

		System.out.println("IntPredicate.or() -> " + ip.or((i) -> i < 20).test(15));
	}
}
