package jwp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.IntStream;

public class App {

	public static void main(String[] args) {
		
		var supplier = new Supplier<List<Integer>>() {
			
			private static int instances;
			
			public List<Integer> get() {
				instances++;
				System.out.println("supplier " + instances);
				return new ArrayList<Integer>();
			}
			
			public void reset() {
				instances = 0;
			}
		};
		
		var accumulator = new BiConsumer<List<Integer>, Integer>() {
			public void accept(List<Integer> t, Integer u) {
				System.out.println("accumulate");
				t.add(u);
			}
		};
		
		var combiner = new BiConsumer<List<Integer>, List<Integer>>() {
			public void accept(List<Integer> t, List<Integer> u) {
				System.out.println("combiner");
				t.addAll(u);
			}
		};

		var result1 = IntStream
			.range(0, 5)
			.boxed()
			.collect(supplier, accumulator, combiner);
		
		System.out.println(result1);
		
		System.out.println();
		
		supplier.reset();
		
		var result2 = IntStream
				.range(0, 100)
				.boxed()
				.parallel()
				.collect(supplier, accumulator, combiner);
			
		System.out.println(result2);
		
		System.out.println();
		
		var collector = new Collector<Integer, List<Integer>, Set<Integer>>() {
			public Supplier<List<Integer>> supplier() {
				return supplier;
			}
			public BiConsumer<List<Integer>, Integer> accumulator() {
				return accumulator;
			}

			public BinaryOperator<List<Integer>> combiner() {
				return (s, t)->{s.addAll(t); return s;};
			}

			public Function<List<Integer>, Set<Integer>> finisher() {
				return u->new HashSet<Integer>(u);
			}

			public Set<Characteristics> characteristics() {
				return Set.of(Characteristics.UNORDERED);
			}
			
		};
		
		supplier.reset();
		
		var result3 = IntStream
				.range(0, 100)
				.boxed()
				.parallel()
				.collect(collector);
			
		System.out.println(result3);
		System.out.println(result3.getClass().getName());
	}

}
