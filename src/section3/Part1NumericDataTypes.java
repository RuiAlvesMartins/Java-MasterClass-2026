package section3;

public class Part1NumericDataTypes {
    
    public static void main(String[] args) {
        
        //  INTEGER
        //  int is a PRIMITIVE type;
        //  Integer is a WRAPPER CLASS;
        //  Java uses wrapper classes for all of its primitive data types!
        int myMinIntValue = Integer.MIN_VALUE;
        int myMaxIntValue = Integer.MAX_VALUE;
        System.out.println("Integer Range: " + myMinIntValue + " to " + myMaxIntValue);
        //  OVERFLOW and UNDERFLOW
        // System.out.print("Busted Max Value: " + (myMaxIntValue + 1));    //  runtime error!
        // System.out.print("Busted Min Value: " + (myMinIntValue - 1));    //  runtime error!
        // int myBustedMaxInt = 2147483647 + 1;                             //  runtime error!
        // int myBustedMinInt = Integer.MIN_VALUE - 1;                      //  runtime error!
        // int myBustedMaxInt2 = 2147483648;                                //  compiler error!
        // int myBustedMinInt2 = -2147483649;                               //  copmiler error!
        //  UNDERSCORE (improve readibility)
        int myFormatedMaxInt = 2_147_483_647;

        //  BYTE, SHORT and LONG
        System.out.println("Byte Range: " + Byte.MIN_VALUE + " to " + Byte.MAX_VALUE);
        System.out.println("Short Range: " + Short.MIN_VALUE + " to " + Short.MAX_VALUE);
        System.out.println("Integer Range: " + Integer.MIN_VALUE + " to " + Integer.MAX_VALUE);
        System.out.println("Long Range: " + Long.MIN_VALUE + " to " + Long.MAX_VALUE);
        System.out.println("A Byte occupies " + Byte.SIZE + " bits of memory.");
        System.out.println("A Short occupies " + Short.SIZE + " bits of memory.");
        System.out.println("An Integer occupies " + Integer.SIZE + " bits of memory.");
        System.out.println("A Long occupies " + Long.SIZE + " bits of memory.");
        //  Java defaults literal whole numbers to integer;
        //  Type L at end to force into Long;
        Long myLongValue = 100L;
        Long myBigLongValue = 2_147_483_647L;
        Long myBiggerLongValue = 2_147_483_647_123L;

        //  CASTING IN JAVA
        //  more than one statement on the same line;
        short myMinShortValue = Short.MIN_VALUE; int mySecondMinIntValue = Integer.MIN_VALUE;
        //  declare more than one variable of the same data type on same line
        byte myMinByteValue = Byte.MIN_VALUE, myMaxByteValue = Byte.MAX_VALUE;
        //  ERROR: can’t divide a byte with an integer (the default datatype for whole number);
        int myTotal = (mySecondMinIntValue / 2);
        // byte myNewByteValue = (myMinByteValue / 2);                      //  compiler error!                           
        short myNewShortValue = (short) (myMinShortValue);
        //  CASTING: forcing a variable, or the end result of an expression, into a specific data type;
        byte myNewByteValue = (byte) (myMinByteValue / 2);
        short mySecondNewShortValue = (short) (myMinShortValue / 2);
        long newLong = (Long) 50_000L + 10*(Byte.MAX_VALUE + Short.MAX_VALUE + Integer.MAX_VALUE);

        //  FLOAT and DOUBLE
        //  Double is java’s default for decimal or real numbers;
        //  For very precise calculations, BIG_DECIMAL should be used;
        System.out.println("Float Range: " + Float.MIN_VALUE + " to " + Float.MAX_VALUE);
        System.out.println("Double Range: " + Double.MIN_VALUE + " to " + Double.MAX_VALUE);
        System.out.println("A Float occupies " + Float.SIZE + " bits of memory.");
        System.out.println("A Double occupies " + Double.SIZE + " bits of memory.");
        int myInt = 5; float myFloat = 5; double myDouble = 5;
        //  Cannot convert from double to float directly!
        // float myNewFloat = 5.5;                                          //  compiler error!
        float myNewNewFloat = 5.5F;
        float myNewNewNewFloat = (float) 5.5;
        double myNewDouble = 5.5;
        double myNewNewDouble = 5.5D;
        myInt = 5 / 2;
        myFloat = 5F / 2F;
        myDouble = 5D / 2D;
        myInt = 5 / 3;
        myFloat = 5F / 3F;
        myDouble = 5D / 3D;
        myDouble = 5.0 / 3.0;
        myDouble = 5.0 / 3;
        // myFloat = 5.0 / 3F;                                              //  compiler error!                                                           
        double myPi = 3.141_592D;

    }

}
