package jwp;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
		
		// @formatter:off
		var list1 = IntStream
				.range(0, 10)
				.boxed()
				.map(n -> (double)n)
				.collect(Collectors.toList());
		// @formatter:on
		
		System.out.println(list1);
		
		// @formatter:off
		var list2 = IntStream
				.range(0, 10)
				.boxed()
				.map(n -> String.format("Option number: %d", n))
				.collect(Collectors.toList());
		// @formatter:on
			
		System.out.println(list2);
		
		Map<String, Integer> peopleMap = Map.of("Pip", 23, "Estella", 23, "Miss Haversham", 56, "Magwitch", 60);
		
		// @formatter:off
		peopleMap
			.entrySet()
			.stream()
			.map(e -> new Person(e.getKey(), e.getValue()))
			.forEach(System.out::println);
		// @formatter:on
		
		System.out.println();

		// @formatter:off
		peopleMap
			.keySet()
			.stream()
			.map(Person::new)
			.forEach(System.out::println);
		// @formatter:on
}

}
