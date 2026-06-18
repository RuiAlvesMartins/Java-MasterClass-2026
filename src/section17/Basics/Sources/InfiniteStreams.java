package section17.Basics.Sources;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class InfiniteStreams {
    
    public static void main(String[] args) {
        
        //  INFINITE STREAMS
        //  No end to the number of elements!
        //  Can very easily make you computer run out of memory!
        //  Usually stopped by an intermediate operation like .limit()

        //  Stream.generate()
        Random random = new Random();
        Stream.generate(() -> random.nextInt(2))
                .limit(10)
                .forEach(s -> System.out.print(s + " "));
        ;
        System.out.println();

        //  IntStream.iterate()
        IntStream.iterate(1, n -> n + 1)
                .filter(InfiniteStreams::isPrime)
                .limit(20)
                .forEach(s -> System.out.print(s + " "));
        ;
        //  this will print the first 20 prime numbers;
        System.out.println();

        IntStream.iterate(1, n -> n + 1)
                .limit(100)
                .filter(InfiniteStreams::isPrime)
                .forEach(s -> System.out.print(s + " "))
        ;
        //  this will print all prime numbers under 100;
        //  order of operations matter!
        System.out.println();

        IntStream.iterate(1, n -> n <= 100, n -> n + 1)
                .filter(InfiniteStreams::isPrime)
                .forEach(s -> System.out.print(s + " "))
        ;
        //  this will also print all prime numbers under 100;
        //  but this time it is a finite stream with a predicate parameter acting as limit;
        System.out.println();

        //  IntStream.range()
        IntStream.range(1, 100)
                .filter(InfiniteStreams::isPrime)
                .forEach(s -> System.out.print(s + " "))
        ;
        System.out.println();

        //  IntStream.rangeClosed()
        IntStream.rangeClosed(1, 100)
                .filter(InfiniteStreams::isPrime)
                .forEach(s -> System.out.print(s + " "))
        ;
        System.out.println();

    }

    public static boolean isPrime(int wholeNumber) {

        if (wholeNumber <= 2) {
            return (wholeNumber == 2);
        }

        for (int divisor = 2; divisor < wholeNumber; divisor++) {
            if (wholeNumber % divisor == 0) {
                return false;
            }
        }

        return true;
    }

}
