package jwp;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

class Person {
	private String name;
	private int age;
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public Person(String name) {
		this.name = name;
		this.age = -1;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}	
}


public class App {

	public static void main(String[] args) {
		
		Consumer<Object> print = System.out::print;
		Consumer<Object> println = System.out::println;
		
		String[][] strings = {
				{"cat", "dog"},
				{"mouse", "fox", "horse"},
		};

		// Arrays.stream
		// Stream.of
		
		Arrays
			.stream(strings)
			.flatMap(Arrays::stream)
			.forEach(println);
		
		System.out.println();
		
		String lines = """
				one, two, three
				four, five, six,
				seven, eight
				""";
		
		Stream
			.of(lines.split("\n"))
			.flatMap(s -> Stream.of(s.split(",")))
			.map(String::trim)
			.map(s -> "'" + s + "'")
			.forEach(println);
		
		System.out.println();
		
		Stream
			.of("Jill", "Joe", "Jack")
			.flatMap(s -> Stream.of(new Person(s), new Person(s)))
			.forEach(println);
		
		System.out.println();
		
		double[][] numbers = {{1, 2, 3}, {4, 5}, {6, 7, 8}};
		
		Stream
			.of(numbers)
			.flatMapToDouble(DoubleStream::of)
			.forEach(System.out::println);
	}

}
