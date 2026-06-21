package section17.IntermediateOperations;

import java.util.Comparator;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IntermediateOperations {
    
    //  .LIMIT()
    //  defines the exact size of the stream (n elements);
    
    //  .DISTINCT()
    //  removes duplicate values from the stream;
    
    //  .SKIP()
    //  will skip the first n elements;
    
    
    
    //  .MAP()
    //  will apply a function to all elements of a stream;
    //  return type may be different! this transforms the Stream<Type>;
    
    //  .PEEK()
    //  like map, it applies a function (Consumer) to all elements of a stream;
    //  unlike map, it cannot change the return type, i.e. it is not allowed to transform the stream!
    //  useful for debuging purposes;
    
    
    
    //  .SORTED()
    //  sorts elements by Natural Order;
    //  elements must implement Comparable!
    
    //  .SORTED() (comparator)
    //  sorts elements by Comparator;
    
    
    
    //  .FILTER()
    //  element kept IF predicate true;
    
    //  .TAKEWHILE()
    //  element kept WHILE predicate true;
    //  when predicate becomes false for the first time, 
    //  condition is no longer cheked and elements are no longer kept!
    
    //  .DROPWHILE()
    //  element removed WHILE predicate true;
    //  when predicate becomes false for the first time, 
    //  condition is no longer cheked and elements are no longer droped!
    
    //  .dropWhile() and .takeWhile() can be effectively paired to retrieve a specific range of elements!
    //  (this is true for ORDERED streams; in non-ordered streams result will be non-deterministic);



    //  .mapToInt(), .mapToLong() and .mapToDouble() return IntStream, LongStream and DoubleStream, respectively;
    //  .mapToObj():    returns Stream<Object>  (reference type is infered implicitly from Object);
    //  .boxed():       returns a WRAPPER reference type;


    
    public static void main(String[] args) {
        
        //  Java API developers designed Streams to allow the processing of data in a DECLARATIVE manner, like SQL;
        //  This let's programmer define what SHOULD happen, not exactly how it happens;

        IntStream.iterate((int) 'A', i -> i <= (int) 'z', i -> i+1)
                .filter(Character::isAlphabetic)
                .map(Character::toUpperCase)
                .distinct()
                // .filter(i -> Character.toUpperCase(i) > 'E')
                // .skip(5)
                // .dropWhile(i -> Character.toUpperCase(i) <= 'E')
                // .takeWhile(i -> i < 'a') 
                .forEach(d -> System.out.printf("%c ", d));
        ;
        System.out.println();
        
        Stream.generate(() -> new Random().nextInt((int) 'A', (int) 'Z'+1))
                .limit(50)
                .distinct()
                .sorted()
                .forEach(d -> System.out.printf("%c ", d));
        ;
        System.out.println();

        int maxSeats = 100;
        int seatsInRow = 10;
        var stream = Stream.iterate(0, i -> i<maxSeats, i -> i+1)
                .map(i -> new Seat((char) ('A'+i/seatsInRow), i%seatsInRow+1))
                .peek(System.out::println)
                // .sorted()                                        //  runtime ERROR!  (Seat does not implement Comparable)
                .sorted(Comparator.comparing(Seat::price).thenComparing(Seat::toString))
                // .map(Seat::price)                                //  returns Stream<Double>
                .mapToDouble(Seat::price)                        //  returns DoubleStream
                // .boxed()                                         //  returns Stream<Double>
                // .map("%.2f"::formatted)                          //  compiler ERROR!  (cannot convert from double to String)         
                .mapToObj("%.2f"::formatted)                     //  returns Stream<String>  (implicitly infers the return type)   
        ;
        stream.forEach(s -> System.out.println(s + "  "));

        //  .mapToInt(), .mapToLong() and .mapToDouble() are operations that return special stream types: 
        //  IntStream, LongStream and DoubleStream, respectively;
        //  These stream types are optimized for PRIMITIVES;
        //  They offer better PERFORMANCE when operating on a large number of primitive elements! 

        //  Once a stream is transformed to IntStream, LongStream, or DoubleStream; 
        //  They are not easily transformed back into reference types!
        //  Subsequent operations MUST return the SAME primitive type!

        //  Alternatively, streams can be transformed back into reference types, but only through:
        //          .mapToObj():    returns Stream<Object>  (reference type is infered implicitly from Object);
        //          .boxed():       returns a WRAPPER reference type;

    }

}
