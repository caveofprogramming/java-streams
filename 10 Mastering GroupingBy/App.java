package jwp;

import java.util.List;

import static java.util.stream.Collectors.*;

public class App {
	
	record Person(String name, int age, int height) {}
	

	public static void main(String[] args) {
		
		var people = List.of(
				new Person("Bob", 52, 182),
				new Person("Bob", 24, 184),
				new Person("Claire", 46, 170),
				new Person("Claire", 46, 165)
		);	
		
		var results1 = people
						.stream()
						.collect(groupingBy(Person::name));
		
		System.out.println(results1);
		
		var results2 = people
				.stream()
				.collect(groupingBy(Person::name, counting()));

		System.out.println(results2);
		
		var results3 = people
				.stream()
				.collect(groupingBy(Person::name, averagingInt(Person::age)));

		System.out.println(results3);
		
		var results4= people
				.stream()
				.collect(
						groupingBy(
								Person::name, 
								groupingBy(Person::age)
						)
				);

		System.out.println(results4);
		
		var results5= people
				.stream()
				.collect(
						groupingBy(
								Person::name, 
								groupingBy(
										Person::age,
										counting()
								)
						)
				);

		System.out.println(results5);
		
		var results6 = people
				.stream()
				.collect(
					groupingBy(
						Person::name, 
						mapping(Person::age, toList())
					)
				);

		System.out.println(results6);
		
		var results7 = people
				.stream()
				.collect(
					groupingBy(
						Person::name, 
						filtering(p -> p.height() < 180, counting())
					)
				);

		System.out.println(results7);
	}

}
