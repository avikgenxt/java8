package lambda.basic.function;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class JavaFunctional2 {

	public static void main(String args[]) {
		
		List<Integer> listI = Arrays.asList(1,2,3,4,5,6,7,8,9);
		
		/**
		 * java 7
		 */
		for(int e:listI) {
			System.out.println(e);
		}
		
		System.out.println("---**************************---");		
		/**
		 * java 8 full function
		 */
		listI.forEach(new Consumer<Integer>() {
			public void accept(Integer v) {
				System.out.println(v);
			}
		});
		
		System.out.println("---**************************---");		
		/**
		 * java 8 lambda
		 */
		listI.forEach((Integer value)->{System.out.println(value);});
		
		System.out.println("---**************************---");		
		/**
		 * Java 8 method reference
		 */
		listI.forEach(System.out::println);
		
		System.out.println("---**************************---");		
		/**
		 * method ref parameter as arguments
		 * String.valueOf(parameter)
		 */
		listI.stream()
		.map(String::valueOf)
		.forEach(System.out::println);
		
		System.out.println("---**************************---");	
		/**
		 * method ref parameter as target
		 * String::toString -> e.toString
		 * 
		 */
		listI.stream()
		.map(String::valueOf)	
		.map(String::toString)
		.forEach(System.out::println);
		
		System.out.println("---**************************---");	
	
		/**
		 * Multi argument method reference
		 */
		System.out.println(listI.stream()
		.reduce(0,(e,total)->Integer.sum(total, e)));
		
		System.out.println(listI.stream().reduce(0,Integer::sum));
				
		//given the values, double the even values and then total
		listI.stream()
		//filter double values
		.filter(e->e%2==0)
		.map(e->e*2)
		.reduce(0,Integer::sum);
	}
	
}
