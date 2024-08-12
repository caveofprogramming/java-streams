package jwp;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class App {

	public static void main(String[] args) {
		double[] doubles = {1.0, 2.0, 3.0};
		
		var result1 = DoubleStream.of(doubles).count();
		System.out.println(result1);
		
		var result2 = DoubleStream.of(doubles).sum();
		System.out.println(result2);
		
		var result3 = DoubleStream.of(doubles).average();
		System.out.println(result3.getAsDouble());
		
		var result4 = DoubleStream.of(doubles).min();
		System.out.println(result4.getAsDouble());
		
		var result5 = DoubleStream.of(doubles).max();
		System.out.println(result5.getAsDouble());
		
		var result6 = DoubleStream.of(doubles).reduce((a, b)->a*b);
		System.out.println(result6.getAsDouble());
		
		var result7 = DoubleStream.of(doubles).reduce(1, (a, b)->a*b);
		System.out.println(result7);
		
		var result8 = Stream.of("hello", "to", "you").reduce("", (a, b)->a + b);
		System.out.println(result8);

		var result9 = Stream.of(1, 2, 3, 4).map(List::of).reduce(new ArrayList<Integer>(), (a, b)->{ a.addAll(b); return a; });
		System.out.println(result9);
	}

}
