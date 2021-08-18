package lambda.basic.function;

import java.util.List;

public class CollectorsBasic {

	public static void main(String[] args) {

		createPeople().stream()
		.filter(person->Integer.valueOf(person.getAge())>30)
		.forEach(System.out::println);
		
	}
	
	public static List<Person> createPeople(){
		return List.of(new Person("S",Gender.MALE,"20"),new Person("S", Gender.MALE, "22"), new Person("Bob",Gender.MALE, "20"),new Person("Paula",Gender.FEMALE, "32"),
				new Person("Paul",Gender.MALE,"33"),new Person("Zack", Gender.MALE, "72"), new Person("Jill",Gender.MALE, "3"),new Person("Jack",Gender.MALE, "11"));
	}

}
