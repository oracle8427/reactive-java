package study.lambda;

import org.junit.jupiter.api.Test;

public class UsingThis {

	@FunctionalInterface
	interface functionalInterface {
		public void method();
	}

	public int outterField = 10;

	class Inner {
		int innerField = 20;

		void method() {
			functionalInterface fi = () -> {
				System.out.println("outterField: " + outterField);
				System.out.println("outterField: " + UsingThis.this.outterField);

				System.out.println("innerField: " + innerField);
				// keyword "this" refers by "Inner".
				System.out.println("innerField: " + this.innerField);
			};
			fi.method();
		}
	}

	@Test
	public void test() {
		new Inner().method();
	}
}
