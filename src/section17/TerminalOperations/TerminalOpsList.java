package section17.TerminalOperations;

import java.util.Arrays;

public class TerminalOpsList {
    

    
    //  Matching and Searching

    //  .ANYMATCH(predicate)
    //  returns true if any element in the stream matches the predicate condition;

    //  .ALLMATCH(predicate)
    //  returns true if all elements of the stream match the predicate condition;

    //  .NONEMATCH(predicate)
    //  returns true if no element in the stream matches the predicate condition;

    //  .FINDFIRST()
    //  returns an OPTIONAL describing the first element of the stream;
    //  returns an empty optional if the stream is empty;

    //  .FINDANY()
    //  returns an OPTIONAL describing a random element of the stream;
    //  returns an empty optional if the stream is empty;



    //  Transformations and Type Reductions

    //  .COLLECT()
    //  elements are accumulated into a CONTAINER;
    //  has two overloaded versions:
    //          .collect(Collector)
    //          .collect(Supplier, Accumulator, Combiner)  
    //                  Supplier: instantiates the container;       
    //                  Accumulator: adds elements to the container;
    //                  Combiner: ???? todo  joins multiple accumulated outputs into a single collection; 

    //  .REDUCE()
    //  elements are accumulated into a SINGLE TYPE;
    //          .reduce(identity, accumulator)      returns an identity type parameter;
    //          .reduce(acumulator)                 returns an Optional;  

    //  .TOARRAY()
    //  returns an Object[] containing the elements of this stream;
    //  .toArray(IntFunction) allows you to return an array of the same type as the stream elements;

    //  .TOLIST()
    //  accumulates elements into a List;
    //  elements are accumulated by the order they are encountered;
    //  returned list is UNMODIFIABLE!      
    //  (you can always pass it to a ArrayList constructor to make it modifiable);



    //  Statistical Reductions

    //  .COUNT()
    //  returns a long with the element count;    

    //  .SUM()
    //  Available only on PRIMITIVE Streams (IntStream, LongStream, DoubleStream);
    //  returns int, long or double, depending on the stream;

    //  .AVERAGE()
    //  Available only on PRIMITIVE Streams (IntStream, LongStream, DoubleStream);
    //  Returns OptionalDouble;

    //  .MAX(comparator)
    //  returns an OPTIONAL whith the maximum value specified by the comparator;
    //  returns an empty optional if the stream is empty;
    
    //  .MIN(comparator)
    //  returns an OPTIONAL whith the minimum value specified by the comparator;
    //  returns an empty optional if the stream is empty;

    //  .SUMMARYSTATISTICS()
    //  Available only on PRIMITIVE Streams (IntStream, LongStream, DoubleStream);
    //  returns a special IntSummaryStatistics (or Long or Double, depending on the Stream);
    //  special reduction that outputs key statistical figures about a stream;



    //  Processing

    //  .FOREACH(consumer)

    //  .FOREACHORDERED(consumer)
    //  encounter order, if defined;



    public static void main(String[] args) {
        
        Seat[] seats = new Seat[100];
        Arrays.setAll(seats, i -> new Seat((char) ('A' + i/10), i % 10 + 1));

        var stream = Arrays.stream(seats)
                // .findAny()
                // .findFirst()

                // .collect(null)
                // .reduce(null)
                // .toArray()
                // .toList()

                //  .average()
                //  .COUNT()
                //  .MAX()
                //  .MIN()
                //  .SUM()
                //  .SUMMARYSTATISTICS()

                //  .forEach()
                //  .forEachOrdered()
        ;
        System.out.println(stream);

    }

}
