package section17.Sources;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BingoChallenge {
    
        //  BINGO game:
        //          B -> 1 through 15;
        //          I -> 16 through 30;
        //          N -> 31 through 45;
        //          G -> 46 through 60;
        //          O -> 61 through 75;

        //  Challenge: generate all bingo balls using streams, through at least 5 different ways!

    public static void main(String[] args) {

        //  Stream.iterate()
        //  Infinite loop! must include .limit()!
        var bStream = Stream.iterate(1, n -> n+1)
                .limit(15)
                .map(i -> "B-" + i)
                // .forEach(s -> System.out.print(s + " "))
        ;

        //  Stream.iterate() (with predicate)
        var iStream = Stream.iterate(16, n -> n<31, n -> n+1)
                .map(i -> "I-" + i)
                // .forEach(s -> System.out.print(s + " "))
        ;

        //  IntStream.range()
        //  you may also use .rangeClosed()
        var nStream = IntStream.range(31, 46)
                .mapToObj(i -> "N-" + i)
                // .forEach(s -> System.out.print(s + " "))
        ;

        //  Stream.generate()
        //  Infinite loop! must include .limit()!
        //  .distinct() prevents duplicates being added to the stream!
        var gStream = Stream.generate(() -> new Random().nextInt(46, 61))
            .distinct()                                             //  excludes duplicates
            .limit(15)
            .map(i -> "G-" + i)
            .sorted()
            // .forEach(s -> System.out.print(s + " "))
        ;

        //  Arrays.stream()
        int seed = 60;
        seed = 61;
        //  REMEMBER: variables in lambdas must be FINAL or effectively final!
        int nSeed = seed; 
        String[] oLabels = new String[15];
        Arrays.setAll(oLabels, i -> "O-" + (nSeed + i));
        var oStream = Arrays.stream(oLabels);



        //  Stream.concat() only allows for 2 strings to be lazily concatenated;
        //  Stream.of() + flatMap() allows effective concatenation of multiple streams!
        Stream.of(bStream, iStream, nStream, gStream, oStream)
                .flatMap(s -> s)
                .forEach(s -> System.out.print(s + " "))
        ;
    }

}
