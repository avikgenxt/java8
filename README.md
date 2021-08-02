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
 </ul>
 
 ******IMP******
<p> Map and Filter stay within their swim lanes, reduce function cuts the swim lanes to reduce the stream
<p>     filter       map             reduce
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
