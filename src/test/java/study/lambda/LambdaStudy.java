package study.lambda;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class LambdaStudy {

	// @FunctionalInterface -> Compiler check to prevent more than one abstract
	// method from being declared
	@FunctionalInterface
	private interface VoidFunctionalInterface {
		public void method();
	}

	@FunctionalInterface
	private interface ConsumerFunctionalInterface {
		public void method(String str);
	}

	@FunctionalInterface
	private interface SupplierFunctionalInterface {
		public int method();
	}

	@FunctionalInterface
	private interface _FunctionalInterface {
		public String method(int age);
	}

	@FunctionalInterface
	private interface OperatorFunctionalInterface {
		public long sum(int... a);
	}

	@FunctionalInterface
	private interface PredicateFunctionalInterface {
		public boolean isBlank(String str);
	}

	@Test
	public void voidTest() {
		System.out.println("voidTest()");
		VoidFunctionalInterface vfi;
		vfi = () -> {
			System.out.println("Void");
			System.out.println("Void");
		};
		vfi.method();

		vfi = () -> {
			System.out.println("Void2");
		};
		vfi.method();

		vfi = () -> System.out.println("Void3");
		vfi.method();
	}

	@Test
	public void consumerTest() {
		System.out.println("consumerTest()");
		ConsumerFunctionalInterface cfi;
		cfi = (s) -> {
			System.out.println("Hello " + s);
		};
		cfi.method("World");
	}

	@Test
	public void supplierTest() {
		System.out.println("supplierTest()");
		SupplierFunctionalInterface sfi;
		sfi = () -> {
			return 600;
		};
		System.out.println(sfi.method());
	}

	@Test
	public void functionTest() {
		System.out.println("functionTest()");
		_FunctionalInterface fi;
		fi = (age) -> {
			return "age of " + age;
		};
		System.out.println(fi.method(30));
	}

	@Test
	public void operatorTest() {
		System.out.println("operatorTest()");
		OperatorFunctionalInterface ofi;
		ofi = (nums) -> {
			if (nums.length == 1)
				return nums[0];

			long sum = 0L;
			for (int num : nums)
				sum += num;
			return sum;
		};
		System.out.println(ofi.sum(6));
		System.out.println(ofi.sum(1, 2, 3, 4, 5));
	}

	@Test
	public void predicateTest() {
		System.out.println("predicateTest()");
		PredicateFunctionalInterface pfi;
		pfi = (str) -> (str == null || str.trim().length() == 0);
		System.out.println(pfi.isBlank(null));
		System.out.println(pfi.isBlank(""));
		System.out.println(pfi.isBlank("Hello World"));
	}

	@AfterEach
	public void printLine() {
		System.out.println("=============================================");
	}
}
