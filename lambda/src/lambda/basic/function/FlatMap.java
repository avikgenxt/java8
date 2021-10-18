package lambda.basic.function;

import static java.util.stream.Collectors.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMap {
	
	public static void main(String args[]) {
		
		List<Integer> numbers  = List.of(1,2,3);
		/**
		 * 
		 * FlatMap - Map is performed first then collection is flattened out flatMap(function <T>, Iterator<R>) will return Stream<R>, Stream is an Iterator, so FlatMap takes a funtion to map and then a Stream to perform the flatening
		 * For one to one funtion use map to transform Stream<T> to Stream<R>
		 * For one to many use map to transform Stream<t> to Stream<Collection<R>>
		 * For One to many use flatMap tp transform Stream<T> to Stream<R> 
		 * For a double loop use flat map
		 */
		
		System.out.println(numbers.stream().map(e->List.of(e-1, e+1)).collect(toList()));
		System.out.println(numbers.stream().flatMap(e->List.of(e-1, e+1).stream()).collect(toList()));
		
		System.out.println(listPerson2().stream()
		.map(Person::getName)
		.flatMap(name->Stream.of(name.split("")))
		.collect(toList()));
		
		System.out.println(listPerson2().stream().
				collect(
						groupingBy(Person::getAge,
						flatMapping(person ->Stream.of(person.getName().split("")), toSet()))));
		
		
		/**
		 * The below one is using the recursive nature of collector
		 * 
		 * collect(function, collector(function, collector(function, collector)))
		 * collect(groupingBy, mapping(map, flatMapping(map, Collectors.toSet())))
		 */
		System.out.println(listPerson2().stream().
				collect(
						groupingBy(Person::getAge,
						mapping(person->person.getName().toLowerCase(), 
						flatMapping(name ->Stream.of(name.split("")), toSet())))));
		
	}
	
	
	public static List<Person> listPerson2(){
		return Arrays.asList(new Person("AVIK", Gender.MALE,"36")
				,new Person("AAD", Gender.MALE,"2")
				,new Person("ANU", Gender.FEMALE,"34")
				,new Person("ANJAN", Gender.MALE,"68")
				,new Person("ARINDAM", Gender.MALE,"29")
				,new Person("DIPU", Gender.FEMALE,"60")
				,new Person("AVIK", Gender.MALE,"38")
				,new Person("AVIK", Gender.MALE,"37"));
	}

}
