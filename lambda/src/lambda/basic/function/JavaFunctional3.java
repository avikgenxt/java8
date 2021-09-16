package lambda.basic.function;

import static java.util.stream.Collectors.*;

import java.util.Arrays;
import java.util.List;

public class JavaFunctional3 {

	public static void main(String args[]) {
		Integer i =  listPerson().stream()
		.map((Person::getAge))
		.map(Integer::valueOf)
		.reduce(0,Integer::sum);
		
		System.out.println(i);
		System.out.println("**********************************************************");
				
		List<String> ss =  listPerson().stream()
		.filter(e->Integer.valueOf(e.getAge())>30)
		.map(Person::getName)
		.map(String::toUpperCase)
		.collect(toList());
		/*.reduce(
				new ArrayList<String>(),
				(names,name)->{names.add(name); return names;},
				(names1, names2)->{
					names1.addAll(names2);
					return names1;
				} 
			  );*/
		
		System.out.println(ss);
		System.out.println("**********************************************************");
		
		System.out.println(
				listPerson()
				.stream().
				collect(toMap(Person::getName, Person::getAge)));
		
		System.out.println("**********************************************************");
		System.out.println(
				listPerson()
				.stream()
				.collect(partitioningBy(person->Integer.valueOf(person.getAge())%2==0)));
		
		System.out.println("**********************************************************");
		System.out.println(
				listPerson()
				.stream()
				.collect(groupingBy(person->person.getName(), mapping(Person::getAge, toList()))));

	}
	
	
	public static List<Person> listPerson(){
		return Arrays.asList(new Person("AVI", Gender.MALE,"36")
				,new Person("AAD", Gender.MALE,"2")
				,new Person("ANU", Gender.FEMALE,"34")
				,new Person("ANJAN", Gender.MALE,"68")
				,new Person("ARINDAM", Gender.MALE,"29")
				,new Person("DIPU", Gender.FEMALE,"60")
				,new Person("AVIK", Gender.MALE,"38"));
	}
}
