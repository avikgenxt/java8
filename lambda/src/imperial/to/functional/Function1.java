package imperial.to.functional;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Function1 {

	public static void main(String[] args) {
		
		/**
		 * 11111111111111111111111111
		 */
		
		 ExecutorService service = Executors.newFixedThreadPool(10);
		 
		 for(int i=0;i<10;i++) {
			 final int index =i;
			 service.submit(new Runnable() {
				
				@Override
				public void run() {
					System.out.println("service called "+index);
				}
			});
		 }
			 
		 /**
		  * ---------------------
		  */
		 
		 IntStream.range(0, 10)
		 .forEach( (final int  i) -> service.submit(()->System.out.println("service called functional "+i) ));
		 
		 
		 System.out.println("task done");
		 service.shutdown();
		 
		 
		 /**
		  * 2222222222222222222222222222222222222222
		  */
		 
		 List<Double> sqrtofFirst100Evens = new ArrayList<>();
		 int index =1;
		 while (sqrtofFirst100Evens.size()<100) {
			 if(isEven(index))
				 sqrtofFirst100Evens.add(Math.sqrt(index));
			index++;
		}
		 
		 System.out.println(String.format("Compounded %d values, first is %g, last is %g", sqrtofFirst100Evens.size(),sqrtofFirst100Evens.get(0),sqrtofFirst100Evens.get(sqrtofFirst100Evens.size()-1)));
		 
		 
		 sqrtofFirst100Evens = Stream.iterate(1, e->e+1)
		.filter(Function1::isEven)
		.limit(100)
		.map(Math::sqrt)
		.collect(Collectors.toList());
		 
		 System.out.println(String.format("Functional Compounded %d values, first is %g, last is %g", sqrtofFirst100Evens.size(),sqrtofFirst100Evens.get(0),sqrtofFirst100Evens.get(sqrtofFirst100Evens.size()-1)));
		
	}
	
	
	public  static boolean isEven(int number) {
		return number%2==0;
		
	}
}
