package section18.Math;

import java.util.Random;

public class Randomization {
    
    //  Math.RANDOM()
    //  returns a double between 0.00 and 1.00;
    //  internally, uses an instance of RANDOM to invoke Random.nextDouble();
    //  this instance is used for subsequent calls;



    //  RANDOM Class
    //  the Random class is not TRULY random, but PSEUDO-RANDOM;
    //  https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Random.html

    //  Random.NEXTINT(origin, bound) 
    //  Included as of JDK17;

    //  Random.INTS()
    //  Random.INTS(origin, bound)
    //  Random.INTS(size, origin, bound)
    //  Random.INTS(size)
    //  returns an IntStream;

    //  Random(SEED)
    //  constructs an instance of Random with a specified seed passed as argument;
    //  even if called from different instances of random, two equal seeds will produce two equal results;
    //  same seed == same result!
    //  the no-args Random() constructor doesn't have this problem;

    public static void main(String[] args) {
        
        //  Will print 10 doubles between 0.00 and 1.00
        for (int i=0; i<10; i++) {
            System.out.println(Math.random());
        }
        System.out.println();

        //  Will print 10 doubles between 0.00 and 10.00
        for (int i=0; i<10; i++) {
            System.out.println(Math.random() * 10);
        }
        System.out.println();



        //  How can we retrieve an integer? 
        int randomInt = (int) (Math.random() * 26) + 65;
        System.out.println("Random Integer = " + randomInt);
        System.out.println();
        //  this method/process was used a lot before JDK17;
        //  because Random.nextInt() only supported an upper bound!
        //  lower bound was assumed to be zero;

        //  Will print 10 integers between 1 and 10
        for (int i=0; i<10; i++) {
            System.out.println((int) (Math.random() * 10) + 1);
        }
        System.out.println();



        //  How to retrieve Chars?
        //  Will print 10 characters between 65 and (65 + 26)
        for (int i=0; i<10; i++) {
            System.out.printf("%1$d = %1$c\n", (int) (Math.random() * 26) + 65);
        }
        System.out.println();

        //  Random.nextInt(origin, bound) 
        //  Will print 10 characters between 65 and (90)
        Random random = new Random();
        for (int i=0; i<10; i++) {
            System.out.printf("%1$d = %1$c\n", random.nextInt(65, 91));
        }
        System.out.println();

        //  Will print 10 characters between 'A' and 'Z'
        for (int i=0; i<10; i++) {
            System.out.printf("%1$d = %1$c\n", random.nextInt('A', 'Z'+1));
        }
        System.out.println();



        //  Will print a random integer within the valid integer range;
        for (int i=0; i<10; i++) {
            System.out.printf("%1$d\n", random.nextInt());
        }
        System.out.println();

        //  Random.ints()
        random.ints()
                .limit(10)
                .forEach(System.out::println);
        ;
        System.out.println();

        //  Random.ints(origin, bound)
        random.ints(0, 10)
                .limit(10)
                .forEach(System.out::println);
        ;
        System.out.println();

        //  Random.ints(size, origin, bound)
        //  this method will return a fininte stream, no need for .limit();
        random.ints(10, 0, 10)
                .forEach(System.out::println);
        ;
        System.out.println();

        //  Random.ints(size)
        //  this method will return a fininte stream, no need for .limit();
        random.ints(10)
                .forEach(System.out::println);
        ;
        System.out.println();



        //  Instantiating Random with a SEED

        long nanoTime = System.nanoTime();
        Random pseudoRandom = new Random(nanoTime);
        pseudoRandom.ints(10, 0, 10)
                .forEach(i -> System.out.print(i + " "));
        ;
        System.out.println();

        Random notReallyRandom = new Random(nanoTime);
        notReallyRandom.ints(10, 0, 10)
                .forEach(i -> System.out.print(i + " "));
        ;
        System.out.println();
        //  the results are the same!
        //  although the instances are different, the seed is the same!
        //  same seed == same result!
        //  the no args constructor Random() doesn't have this problem;

        
    }

}
