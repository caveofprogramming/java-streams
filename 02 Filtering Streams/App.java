package jwp;

import java.util.ArrayList;
import java.util.List;
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
	
	public static boolean filterPeople(Person p) {
		return p.getName().length() < 5 && p.getAge() > 30;
	}

	public static void main(String[] args) {

		// @formatter:off
		
		IntStream.range(0, 20)
			.filter(a -> a % 2 == 0)
			.forEach(System.out::println);
		
		// @formatter:on
		
		var list1 = List.of("hello", "to", "you", "how", "are", "you", "today");
		
		list1.stream().filter(s -> s.length() == 3).forEach(System.out::println);
		
		List<Person> people = new ArrayList<>();
		people.add(new Person("Bob", 32));
		people.add(new Person("Sue", 63));
		people.add(new Person("Claire", 19));
		people.add(new Person("Rog", 28));
		
		people.stream().filter(p -> p.getAge() < 32).forEach(System.out::println);
		System.out.println();
		
		// @formatter:off
		people.stream()
			.filter(p -> p.getAge() > 19)
			.filter(p -> p.getAge() < 60)
			.forEach(System.out::println);
		
		System.out.println();
		
		List<Person> people2 = people.stream()
			.filter(App::filterPeople)
			.collect(Collectors.toList());
		// @formatter:on
		
		people2.add(new Person("Gary", 26));
		
		System.out.println(people2);
		
		System.out.println();
		Map<String, Integer> map1 = Map.of("Simon", 25, "Gary", 30, "Raj", 24);
		
		map1.entrySet().stream().forEach(e -> System.out.println(e.getKey() + ", " + e.getValue()));
		System.out.println();
		map1.entrySet().stream().forEach(System.out::println);
		
	}

}
