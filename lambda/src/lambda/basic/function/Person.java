package lambda.basic.function;

import java.io.Serializable;

public class Person implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5753506828666492309L;
	
	String name;
	Gender gender;
	String age;
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", gender=" + gender + ", age=" + age
				+ "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public Person(String name, Gender gender, String age) {
		super();
		this.name = name;
		this.gender = gender;
		this.age = age;
	}
	public Person() {
		
	}
	
	
}
