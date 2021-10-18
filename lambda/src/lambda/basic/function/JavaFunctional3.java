package lambda.basic.function;

import static java.util.stream.Collectors.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class JavaFunctional3 {

	public static void main(String args[]) {
		System.out.println("************************REDUCE AND SUM**********************************");
		Integer i =  listPerson().stream()
		.map((Person::getAge))
		.map(Integer::valueOf)
		.reduce(0,Integer::sum);
		
		System.out.println(i);
		System.out.println("**********************************************************");
		System.out.println("**********************COLLECTORS TO LIST************************************");
		//Get list of names where age is greater than 30		
		List<String> ss =  listPerson().stream()
		.filter(e->Integer.valueOf(e.getAge())>30)
		.map(Person::getName)
		.map(String::toUpperCase)
		.collect(toList());
		/**
		 * A Collector is specified by four functions that work together to accumulate entries into a mutable result container, and optionally perform a final transform on the result. They are:
		 * creation of a new result container (supplier())
		 * incorporating a new data element into a result container (accumulator())
		 * combining two result containers into one (combiner())
		 * performing an optional final transform on the container (finisher())
		 */
		
		/* toList () ====
		 * start with an empty list implementation 1
		 * create a list of objects and add one element 2
		 * Add the lists created in step 2
		 *.reduce(
				new ArrayList<String>(), //Step 1
				(names,name)->{names.add(name); return names;}, //Step2
				(names1, names2)->{ //step3
					names1.addAll(names2);
					return names1;
				} 
			  );*/
		
		System.out.println(ss);
		System.out.println("**********************************************************");
		System.out.println("*********************COLLECTORS TO MAP*************************************");
		
		//Create a map with name as key and age as value
		System.out.println(
				listPerson()
				.stream().
				collect(toMap(Person::getName, Person::getAge)));
		System.out.println("**********************************************************");
		System.out.println("***********************PARTITION BY***********************************");
		System.out.println(
				listPerson()
				.stream()
				.collect(partitioningBy(person->Integer.valueOf(person.getAge())%2==0)));
		System.out.println("**********************************************************");
		System.out.println("********************GROUPING BY MAPPING**************************************");
		System.out.println(
				listPerson()
				.stream()
				.collect(
						groupingBy(person->person.getName(), mapping(Person::getAge, toList())))
				);
		
		//.collect(groupingBy(person->person.getName(), mapping(Person::getAge, toList()))));
		//means
		//Collectors(function, collectors(function, collectors))
		System.out.println("**********************************************************");
		System.out.println("**************************GROUPING BY ********************************");
		System.out.println(
				listPerson2()
				.stream()
				.collect(
						groupingBy(person->person.getName(), counting()))
				);

		System.out.println("**********************************************************");
		System.out.println("*************************GROUP BY COLLECTING AND THEN*********************************");
		System.out.println(
				listPerson2()
				.stream()
				.collect(
						groupingBy(person->person.getName(),collectingAndThen(counting(), Long::intValue)))
				);

		
		System.out.println("**********************************************************");
		System.out.println(
				listPerson2()
				.stream()
				.collect(
						groupingBy(person->person.getName(),collectingAndThen(counting(), Long::intValue)))
				);
		
		System.out.println("**********************************************************");
		System.out.println("**************************SUM********************************");
		System.out.println(listPerson2().stream()
				.map(Person::getAge)
				.filter(Objects::nonNull)
				.mapToInt(Integer::valueOf)
				.sum());
		
		
		System.out.println("**********************************************************");
		System.out.println("**************************MAX********************************");
		System.out.println(listPerson2().stream()
				.map(Person::getAge)
				.filter(Objects::nonNull)
				.mapToInt(Integer::valueOf)
				.max());
		
		
		System.out.println("**********************************************************");
		System.out.println("**************************MIN********************************");
		System.out.println(listPerson2().stream()
				.map(Person::getAge)
				.filter(Objects::nonNull)
				.mapToInt(Integer::valueOf)
				.min());

		System.out.println("**********************************************************");
		System.out.println("**************************MAX BY MIN BY********************************");

		System.out.println(listPerson2().stream().
				collect(maxBy(Comparator.comparing(Person::getAge))));
		
		System.out.println(listPerson2().stream().
				collect(minBy(Comparator.comparing(Person::getAge))));

		
		String name =  listPerson2().stream().
				collect(collectingAndThen(
						maxBy(Comparator.comparing(Person::getAge)), 
						person->person.map(Person::getName).orElse("")));
		
		System.out.println(name);		

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
