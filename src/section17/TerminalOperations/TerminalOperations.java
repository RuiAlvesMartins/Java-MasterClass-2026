package section17.TerminalOperations;

import java.util.Arrays;
import java.util.stream.IntStream;

public class TerminalOperations {
    
    //todo:  intro to video 257

    public static void main(String[] args) {
        
        var result = IntStream.iterate(0, i-> i<=1000, i-> i+10)
                .summaryStatistics()
        ;
        System.out.println("Result = " + result);

        var leapYearData = IntStream.iterate(2000, i-> i<=2025, i-> i+1)
                .filter(i -> i % 4 == 0)
                .peek(System.out::println)
                .summaryStatistics()
        ;
        System.out.println("Leap Year Data = " + leapYearData);

        Seat[] seats = new Seat[100];
        Arrays.setAll(seats, i -> new Seat((char) ('A' + i/10), i % 10 + 1));
        // Arrays.asList(seats).forEach(System.out::println);

        long reservationCount = Arrays.stream(seats)
                .filter(Seat::isReserved)
                .count()
        ;
        System.out.println("reservationCount = " + reservationCount);

        boolean hasBookings = Arrays.stream(seats)
                .anyMatch(Seat::isReserved)
        ;
        System.out.println("hasBookings = " + hasBookings);

        boolean fullyBooked = Arrays.stream(seats)
                .allMatch(Seat::isReserved)
        ;
        System.out.println("fullyBooked = " + fullyBooked);

        boolean eventWashedOut = Arrays.stream(seats)
                .noneMatch(Seat::isReserved)
        ;
        System.out.println("eventWashedOut = " + eventWashedOut);



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

        //  .REDUCE()

        //  .TOARRAY()
        //  returns an array containing the elements of this stream;

        //  .TOLIST()
        //  accumulates elements into a List;
        //  elements are accumulated by the order they are encountered;



        //  Statistical Reductions

        //  .AVERAGE()

        //  .COUNT()

        //  .MAX()

        //  .MIN()

        //  .SUM()

        //  .SUMMARYSTATISTICS()




        //  Processing

        //  .FOREACH(consumer)

        //  .FOREACHORDERED(consumer)
        //  encounter order, if defined;





        //  reduction operations
        //  Optional
        //  Collectior Interface
    }

}
