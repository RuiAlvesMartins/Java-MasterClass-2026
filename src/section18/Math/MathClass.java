package section18.Math;

public class MathClass {

    //  java.util.MATH
    //  You can think of the Math class as a basic calculator;
    //  Plus a few scientific methods;


    //  Math.INCREMENTEXACT()
    //  Increments arg +1;
    //  Throws ArithmeticException if overflow;
    //  Math.DECREMENTEXACT()
    //  Math.ADDEXACT()
    //  Math.SUBTRACTEXACT()
    //  and others...

    //  Math.ABS()
    //  Math.ABSEXACT()

    //  Math.MAX()
    //  Math.MIN()

    //  Math.ROUND()
    //  Math.FLOOR()
    //  Math.CEIL()

    //  Math.SQRT()
    //  Math.POW()
    //  both take doubles as argument and return a double;

    //  Math.RANDOM()
    //  returns a double between 0.00 and 1.00;
    //  internally, uses an instance of RANDOM to invoke Random.nextDouble();
    //  this instance is used for subsequent calls;


    public static void main(String[] args) {
        
        int maxMinusFive = Integer.MAX_VALUE - 5;

        //  you can initialize more than 1 variable in a for loop!
        for (int j=0, id=maxMinusFive; 
            j<10; 
            id++, j++
            ) {
                //  "%,d" format specifier will group digits into thousands (e.g. 1,000,000,000.00)
                System.out.println("Assiging id %,d".formatted(id));
        }
        // Output:      integer overflow after 5th element; 
        System.out.println(); 



        //  Math.incrementExact()
        try {
            for (int j=0, id=maxMinusFive; 
                j<10; 
                id=Math.incrementExact(id), j++
                ) {System.out.println("Assiging id %,d".formatted(id));}
        } catch (ArithmeticException ae) {System.out.println("Overflow!");}
        //  Output:     runtime error!      ArithmeticException: integer overflow
        //  It may be better to throw an exception and handle it with a TRY CATCH; 
        //  Than allowing the overflow to happen silently, with no warning;
        System.out.println();

        //  Math.abs()
        System.out.println(Math.abs(-50));
        System.out.println(Math.abs(Integer.MIN_VALUE));
        //  Why does it overflow? Beacuse:
        System.out.println("MAX Integer value = " + Integer.MAX_VALUE);
        System.out.println("MIN Integer value = " + Integer.MIN_VALUE);

        //  Math.absExact()
        // System.out.println(Math.absExact(Integer.MIN_VALUE));    //  runtime error!  ArithmeticException
        //  Integer.MIN_VALUE will not overflow if cast into a LONG!
        System.out.println(Math.abs((long) Integer.MIN_VALUE));
        System.out.println();

        //  Math.max()  &   Math.min()
        System.out.println("Max = " + Math.max(10, -10));
        System.out.println("Min = " + Math.min(10.0000002, 10.001));
        //  FLOAT is not precise enough! 
        System.out.println("Min = " + Math.min(10.0000002f, 10.001f));
        //  Math.min(DOUBLE) is used if either one of the two arguments is a double!
        System.out.println("Min = " + Math.min(10.0000002, 10.001f));
        System.out.println();

        //  Math.round()
        System.out.println("Round Down = " + Math.round(10.2));
        System.out.println("Round Up = " + Math.round(10.8));
        System.out.println("Round ? = " + Math.round(10.5));
        System.out.println();

        //  Math.floor()    &   Math.ceil()
        System.out.println("Floor = " + Math.floor(10.8));
        System.out.println("Ceiling = " + Math.ceil(10.2));
        System.out.println();

        //  Math.sqrt()     &   Math.pow()
        System.out.println("Square root of 100 = " + Math.sqrt(100));
        System.out.println("2 to the third power (2*2*2) = " + Math.pow(2, 3));
        System.out.println("10 to the fifth power (10*10*10*10*10) = " + Math.pow(10, 5));
        System.out.println();

        //  Math.random()
        for (int i=0; i<10; i++) {
            System.out.println(Math.random());
        }
        System.out.println();

    }
    
}
