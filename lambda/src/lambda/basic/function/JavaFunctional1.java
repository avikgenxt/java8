 package lambda.basic.function;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaFunctional1 {

	public static void main(String args[]) {
		
		List<Integer> listI = Arrays.asList(1,2,3,4,5,6,7,8,9);
		List<Integer> doubleOfEven = new ArrayList<>();
		
		/**
		 * Shared mutability 
		 * Since the for each is adding in the list
		 * parallel stream will run into problems
		 */
		listI.stream()
	       .filter(e -> e % 2 == 0)
	       .map(e -> e * 2)
	       .forEach(doubleOfEven::add);
		
		/**
		 * proper way of collecting
		 */
		List<Integer> doubleOfEven2 =
				listI.stream()
			             .filter(e -> e % 2 == 0)
			             .map(e -> e * 2)
			             .collect(Collectors.toList());
		
		System.out.println(doubleOfEven2);
		/**
		 * toMap collect
		 */
		Map<Integer, Integer> map = listI.stream()
									.collect(Collectors.toMap(e->e, e->e));
		
		System.out.println(map);
	
		final List<Person> persons = Arrays.asList(new Person("AVI", Gender.MALE,"36")
				,new Person("AAD", Gender.MALE,"2")
				,new Person("ANU", Gender.FEMALE,"34")
				,new Person("ANJAN", Gender.MALE,"68")
				,new Person("ARINDAM", Gender.MALE,"29")
				,new Person("DIPU", Gender.FEMALE,"60")
				,new Person("AVIK", Gender.MALE,"38"));
		
		Map<String,Person> map2 = persons.stream()
			.collect(Collectors.toMap( p-> p.getName(),p->p));
		
		System.out.println(map2);
		
		Map<String, List<Person>> map3 = persons.stream()
				.collect(Collectors.groupingBy(Person::getName));
				
				
		System.out.println(map3);
		
		
		Map<String, List<String>> map4 = persons.stream()
				.collect(Collectors.groupingBy(Person::getName, 
						Collectors.mapping(Person::getAge, Collectors.toList())));
		
		System.out.println(map4);
		
		int result = Stream.iterate(1, e->e+1) //unbound , lazy
		.filter(e -> e%2==0)//unbound , lazy
		.filter(e -> Math.sqrt(e)>20)//unbound , lazy
		.mapToInt(e->e*2)//unbound , lazy
		.limit(20) //sized, lazy
		.sum(); //terminal operation;
		
		System.out.println(result);
		
		//Any function that returns a stream from a stream is lazy.
		System.out.println(Stream.iterate(1, e->e+1) //unbound , lazy
				.filter(e -> e%2==0)//unbound , lazy
				.filter(e -> Math.sqrt(e)>20)//unbound , lazy
				.mapToInt(e->e*2)//unbound , lazy
				.limit(20));
	}
	
}


