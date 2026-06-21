package section17.TerminalOperations;

import java.util.Arrays;
import java.util.stream.IntStream;

public class TerminalOpsPart1 {
    
    //  Terminal Operations Part 1
    //  Basic Terminal Operations    

    //  .COUNT()
    //  returns a long with the element count;   

    //  .SUMMARYSTATISTICS()
    //  Available only on PRIMITIVE Streams (IntStream, LongStream, DoubleStream);
    //  returns a special IntSummaryStatistics (or Long or Double, depending on the Stream);
    //  special reduction that outputs key statistical figures about a stream;

    //  .ANYMATCH(predicate)
    //  returns true if any element in the stream matches the predicate condition;

    //  .ALLMATCH(predicate)
    //  returns true if all elements of the stream match the predicate condition;

    //  .NONEMATCH(predicate)
    //  returns true if no element in the stream matches the predicate condition;



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


    }

}
