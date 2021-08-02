# java8

<h1>Lambda</h1>

Invoke Dynamic  -> Underline behined Lambda funtions.
You can attach or detach the function you want to call dynamically & re-attach at runtime. Similar to function pointer

internal iterator -> call function on the collection object using polymorphism
Type inference for lambda
Consumer - > function 

Method ref - parameter as argument and parameter as target
Method ref for multiple param is only applicable if the order is the same.
Method ref limitations - cant use if there is a method conflict one static one instance ex - toString on Integer ** and ** if there is data manupulation

parallel stream - Use with Caution

Stream - A bunch of funtion waiting to be evoluted. Only abstraction / non mutated pipeline

Function Composition --> Pipeline of transformation
No change in values of collection (no mutation in original collection)
filter -> number of elements in o/p <= no. of elements in i/p, takes Predicate<T> for Stream of type T
map -> no of output = number of input. no guarantee on type of o/p, Stream<T> map takes Function<T,R> to return Stream<R>
 

