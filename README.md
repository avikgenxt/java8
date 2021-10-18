# java8

<h1>Lambda</h1>

Invoke Dynamic  -> Underline behined Lambda funtions.
You can attach or detach the function you want to call dynamically & re-attach at runtime. Similar to function pointer

internal iterator -> call function on the collection object using polymorphism
Type inference for lambda
Consumer - > function 
<ul>
 <li>Method ref - parameter as argument and parameter as target</li>
<li>Method ref for multiple param is only applicable if the order is the same.</li>
<li>Method ref limitations - cant use if there is a method conflict one static one instance ex - toString on Integer ** and ** if there is data manupulation</li>
</ul>


<ul>
<li>parallel stream - Use with Caution</li>
<li>Stream - A bunch of funtion waiting to be evoluted. Only abstraction / non mutated pipeline</li>
<li>Function Composition --> Pipeline of transformation</li>
<li>No change in values of collection (no mutation in original collection)</li>
<li>filter -> number of elements in o/p <= no. of elements in i/p, takes Predicate<T> for Stream of type T</li>
<li>map -> no of output = number of input. no guarantee on type of o/p, Stream<T> map takes Function<T,R> to return Stream<R></li>
<li>reduce - Stream<t> reduce takes 2 parameters fist of type<T>, second param is BiFunction<R,T,R> to produce a result of R, T inputType, R input and result</li>
 <li> reduce can yeild both one element of collection of elements</li>
 
 </ul>
 
<pre>******IMP******
<p> Map and Filter stay within their swim lanes, reduce function cuts the swim lanes to reduce the stream
<p>     filter       map            reduce
<p>- - - - - - - - - - - - - - - - - - 0 - - - - - - - -
<p> x1   block                        \
<p>- - - - - - - - - - - - - - - - - - \- - - - - - - -
<p> x2   allow     transform            result = 0 +Transformed x2
<p>- - - - - - - - - - - - - - - - - - - -\ - - - - - -
<p> x3   block                             \
<p>- - - - - - - - - - - - - - - - - - - - -\ - - - - -
<p> x4   allow     transform                 result = result + transformed x4
<p>- - - - - - - - - - - - - - - - - - - - - - \- - - -
                                             final result
 
<p> result becomes the feedback in the next operation.
</pre>
 
 Special Reduce / Common Stram collections
 <ul>
  <li>
   Mutability is okay, sharing is nice, shared mutability is devils work
   **http://henrikeichenhardt.blogspot.com/2013/06/why-shared-mutable-state-is-root-of-all.html**
 </ul>

 Streams operation -
Intermediate operation - Postponed for evaluation and Terminal Operation - Triggers the evaluation
 
 Lazy feature - one element in tthe stream flows through all the intermediate operations and terminal operations so all of the elements are not processed at one go. If no terminal operation then no computation, the evalutation is posponted till terminal opperation is called.
 
 Lazy evolution is only possible if the function has no side effects, so no way the function is printing anything or logging anything.
Any function that returns a stream from a stream is lazy.
 
 The Reduce function takes the collection and reduces to single or multiple value where the length of result is less than / equal to the original collection
 
 Reduce can produce either one value - Reduce or collection(s) - Collect.. reduce converts a stream into something more concrete, so it may be single, may not be.

 Functional programing depends on Functional Composition - Filter.Map.Reduce and Laziness
 
 Lazy depends on purity of function, a function that returns the same result every time when we use the same input - idempotency. So no side effects.
 Pure functions do not change anything, and pure functions do not depend on anything that may possiblily change
 
 use unmodififiable list set and map to ensure no mutation after function evolution is complete
 
 Collector can take a funtion as first argument and another collector as second argument
 Collecting and then is opposite of collector, it will first collect and then run the function
 
 Map vs Mapping-  Use Map when we transforn in the stream use mapping when we map transformation in middle of reduce
 Filter vs Filtering Use filter in stream, in the middle of transform we can use filtering


FlatMap - Map is performed first then collection is flattened out flatMap(function <T>, Iterator<R>) will return Stream<R>, Stream is an Iterator, so FlatMap takes a funtion to map and then a Stream to perform the flatening
For one to one funtion use map to transform Stream<T> to Stream<R>
For one to many use map to transform Stream<t> to Stream<Collection<R>>
For One to many use flatMap tp transform Stream<T> to Stream<R> 

For a double loop use flat map

We can perform a flatmap while collecting