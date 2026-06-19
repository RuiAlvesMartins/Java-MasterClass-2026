package section17.Sources;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Sources {
    
    //  Any Data Structure that implements COLLECTION can call .stream()
    //  I.e. Lists, Sets, Queues can call .stream()

    //  Arrays have their own static helper method Arrays.stream();

    //  Maps don't extend Collection, hence they can't call .stream()
    //  Their VIEWS, however, can!

    public static void main(String[] args) {
        
        //  Arrays don't implement Collection; 
        //  they must call their own helper method;
        //  Arrays.stream()
        String[] strings = {"One", "Two", "Three"};
        var firstStream = Arrays.stream(strings)
                .sorted(Comparator.reverseOrder())
                // .forEach(System.out::println)
        ;

        //  Stream.of()
        var secondStream = Stream.of("Six", "Five", "Four")
                .map(String::toUpperCase)
                // .forEach(System.out::println);
        ;

        //  Stream.concat()
        Stream.concat(secondStream, firstStream)
                .map(s -> s.charAt(0) + " - " + s)
                .forEach(System.out::println);
        ;
        //  each of these two stream variables were not executed until they were concatenated!



        Map<Character, int[]> myMap = new LinkedHashMap<>();
        int bingoIndex = 1;
        for (char c : "BINGO".toCharArray()) {
            int[] numbers = new int[15];
            int labelNo = bingoIndex;
            Arrays.setAll(numbers, i -> i + labelNo);
            myMap.put(c, numbers);
            bingoIndex += 15;
        }

        //  Maps don't implement Colection, so they can't call .stream()
        //  But their VIEWS can!
        myMap.entrySet().stream()
                .map(e -> e.getKey() + " has range: " + e.getValue()[0] + " - " + 
                        e.getValue()[e.getValue().length - 1])
                .forEach(System.out::println)
        ;
        //  notice that the map operation changed the Stream TYPE
        //  Stream<Entry<Character, int[]>>  to  Stream<String>    



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
                .filter(Sources::isPrime)
                .limit(20)
                .forEach(s -> System.out.print(s + " "));
        ;
        //  this will print the first 20 prime numbers;
        System.out.println();

        IntStream.iterate(1, n -> n + 1)
                .limit(100)
                .filter(Sources::isPrime)
                .forEach(s -> System.out.print(s + " "))
        ;
        //  this will print all prime numbers under 100;
        //  order of operations matter!
        System.out.println();

        IntStream.iterate(1, n -> n <= 100, n -> n + 1)
                .filter(Sources::isPrime)
                .forEach(s -> System.out.print(s + " "))
        ;
        //  this will also print all prime numbers under 100;
        //  but this time it is a finite stream with a predicate parameter acting as limit;
        System.out.println();

        //  IntStream.range()
        IntStream.range(1, 100)
                .filter(Sources::isPrime)
                .forEach(s -> System.out.print(s + " "))
        ;
        System.out.println();

        //  IntStream.rangeClosed()
        IntStream.rangeClosed(1, 100)
                .filter(Sources::isPrime)
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
