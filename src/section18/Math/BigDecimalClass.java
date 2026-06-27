package section18.Math;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Arrays;

public class BigDecimalClass {
    

    //  java.math.BIGDECIMAL;
    //  BigDecimal lets you control how numbers are ROUNDED;
    //  without losing PRECISION in calculations!

    //  PRECISION defines the total number of digits in a decimal number;
    //  BOTH to the RIGHT and the LEFT of the decimal point!

    //  SCALES defines the number of digits to the RIGHT of the decimal point;
    //  E.g.    15.456      precision = 5   scales = 3

    //  When FLOAT or DOUBLE are used, the precision is determined by Operating System;
    //          Float:      6 - 7 scales
    //          Double:     16 scales  

    //  BIGDECIMAL stores a floating point number in two integer fields:
    //          Unscaled Value: stores all digits of the number in a java.math.BigInteger;
    //          Scale:
    //                  Positive (or Zero): how many decimal digits are after the decimal point;
    //                  Negative: Unscaled Value * 10 ^ Scale;
    //  https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/math/BigDecimal.html
    //  BigDecimal is IMMUTABLE!



    //  Because BigDecimal is IMMUTABLE, you should re-assign the result of BigDecimal methods to a new variable!
    //  https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/math/BigDecimal.html#method-summary
    //  BigDecimal METHODS:
    //
    //          BigDecimal.unscaledValue();
    //          BigDecimal.precision();
    //          BigDecimal.scale();
    //          BigDecimal.setScale(newScale, RoundingMode);
    //
    //          BigDecimal.valueOf();
    // 
    //          BigDecimal.divide(divisor, mathContext);
    //          BigDecimal.multiply();
    //          (among other mathematical operations)
    // 
    //          BigDecimal.ZERO;
    //          BigDecimal.ONE;
    //          BigDecimal.TWO;
    //          BigDecimal.TEN;

    public static void main(String[] args) {
        
        double policyAmount = 100_000_000;
        int beneficiaries = 3;
        float percentageFloat = 1.0f / beneficiaries;
        double percentage = 1.0 / beneficiaries;
        
        System.out.println("Payout = %,.2f".formatted(policyAmount * percentageFloat));     //  Output: 33 333 334,33      
        System.out.println("Payout = %,.2f".formatted(policyAmount * percentage));          //  Output: 33 333 333,33
        //  float is a dollar off;

        double totalUsingFloat = policyAmount - ((policyAmount * percentageFloat) * beneficiaries);
        System.out.println("totalUsingFloat: %,.2f".formatted(totalUsingFloat));            //  Output: -2.98        

        double total = policyAmount - ((policyAmount * percentage) * beneficiaries);
        System.out.println("total: %,.2f".formatted(total));                                //  Output: 0.00



        String[] tests = {"15.456", "8", "10000.000001", ".123"};
        BigDecimal[] bds = new BigDecimal[tests.length];
        Arrays.setAll(bds, i -> new BigDecimal(tests[i]));

        System.out.println("%-14s %-15s %-8s %s".formatted("Value", "Unscaled Value", "Scale", "Precision"));
        for (var bd : bds) {
            System.out.println("%-15s %-15d %-8d %d"
                    .formatted(bd, bd.unscaledValue(), bd.scale(), bd.precision()));
        }



        double[] doubles = {15.456, 8, 10000.000001, .123};
        BigDecimal[] bdsDoubles = new BigDecimal[doubles.length];
        //  The BigDecimal constructor taking a double is not as precise as the one taking a string:
        // Arrays.setAll(bdsDoubles, i -> new BigDecimal(doubles[i]));
        //  You should use BigDecimal.valueOf(double):
        Arrays.setAll(bdsDoubles, i -> BigDecimal.valueOf(doubles[i]));

        System.out.println();
        System.out.println("%-14s %-15s %-8s %s".formatted("Value", "Unscaled Value", "Scale", "Precision"));
        for (var d : bdsDoubles) {
            System.out.println("%-15s %-15d %-8d %d"
                    .formatted(d, d.unscaledValue(), d.scale(), d.precision()));
        }



        BigDecimal test1 = new BigDecimal("1.1111122222333334444455555");
        BigDecimal test2 = BigDecimal.valueOf(1.1111122222333334444455555);

        System.out.println();
        System.out.println("%-30s %-30s %-8s %s".formatted("Value", "Unscaled Value", "Scale", "Precision"));
        System.out.println("%-30s %-30d %-8d %d"
                    .formatted(test1, test1.unscaledValue(), test1.scale(), test1.precision()));
        System.out.println("%-30s %-30d %-8d %d"
                    .formatted(test2, test2.unscaledValue(), test2.scale(), test2.precision()));
        //  double's scale is only 16 digits long!
        //  effect: the double results are truncated

        //  lesson: writing numbers as a STRING is more PRECISE!
        //  the scale and precision will be exactly as specified on the string!



        //  BigDecimal.setScale()
        //  might throw ArithmeticException if RoundingMode is not specified!
        System.out.println();
        System.out.println("%-14s %-15s %-8s %s".formatted("Value", "Unscaled Value", "Scale", "Precision"));
        for (var d : bdsDoubles) {
            //  because BigDecimal is IMMUTABLE, you should re-assign the result of BigDecimal methods to a new variable!
            d = d.setScale(2, RoundingMode.HALF_UP);
            System.out.println("%-15s %-15d %-8d %d"
                    .formatted(d, d.unscaledValue(), d.scale(), d.precision()));
        }



        //  if you instantiate a BigDecimal with a string constructor, you can't use numeric literal features, nor comas!
        // BigDecimal policyPayout = new BigDecimal("100_000_000.00");

        //  however, you can use enotations:
        BigDecimal policyPayout = new BigDecimal("100e6");
        System.out.println("%-15s %-15d %-8d %d"
                    .formatted(policyPayout, policyPayout.unscaledValue(), policyPayout.scale(), policyPayout.precision()));

        //  you can also use dots to control the scale:
        policyPayout = new BigDecimal("100000000.00");
        System.out.println("%-15s %-15d %-8d %d"
                    .formatted(policyPayout, policyPayout.unscaledValue(), policyPayout.scale(), policyPayout.precision()));



        //  MATHCONTEXT
        //  MathContext is a helper class for mathematical operations (like certain methods on BigDecimal);
        //  It bounds said math operations by certain rules:
        //          Precision;
        //          RoundingMode;
        //  These are applied to the result of the operation;
        System.out.println();

        //  MathContext.UNLIMITED is the default RoundingMode, and can still throw an ArithmeticException
        // BigDecimal percent = BigDecimal.ONE.divide(BigDecimal.valueOf(beneficiaries), MathContext.UNLIMITED);

        //  MathContext.DECIMAL32 returns 7 decimal digits, like a FLOAT:
        BigDecimal percent = BigDecimal.ONE.divide(BigDecimal.valueOf(beneficiaries), MathContext.DECIMAL32);
        System.out.println(percent);

        //  MathContext.DECIMAL64 returns 16 decimal digits, like a DOUBLE:
        percent = BigDecimal.ONE.divide(BigDecimal.valueOf(beneficiaries), MathContext.DECIMAL64);
        System.out.println(percent);

        //  MathContext.DECIMAL128 returns 32 decimal digits:
        percent = BigDecimal.ONE.divide(BigDecimal.valueOf(beneficiaries), MathContext.DECIMAL128);
        System.out.println(percent);

        //  If you want more precision, you can create your own MathContext instance:
        percent = BigDecimal.ONE.divide(BigDecimal.valueOf(beneficiaries), new MathContext(60, RoundingMode.UP));
        System.out.println(percent);



        BigDecimal checkAmount = policyPayout.multiply(percent);
        System.out.println("policyPayout = %.2f".formatted(policyAmount));
        System.out.println("percent = %.2f".formatted(percent));
        System.out.println("checkAmount = %.2f".formatted(checkAmount));
        System.out.println();

        //  for a multipliplication, the default scale is the sum of scales of both operands;
        //  here we will reset it to 2:
        checkAmount = checkAmount.setScale(2, RoundingMode.HALF_UP);
        System.out.println("%-14s %-15s %-8s %s".formatted("Value", "Unscaled Value", "Scale", "Precision"));
        System.out.println("%-15s %-15d %-8d %d"
                    .formatted(checkAmount, checkAmount.unscaledValue(), checkAmount.scale(), checkAmount.precision()));

        BigDecimal totalChecksAmount = checkAmount.multiply(BigDecimal.valueOf(beneficiaries));
        System.out.println("Combined: %.2f".formatted(totalChecksAmount));
        System.out.println("Remaining = " + policyPayout.subtract(totalChecksAmount));
        System.out.println("%-14s %-15s %-8s %s".formatted("Value", "Unscaled Value", "Scale", "Precision"));
        System.out.println("%-15s %-15d %-8d %d"
                    .formatted(totalChecksAmount, totalChecksAmount.unscaledValue(), 
                    totalChecksAmount.scale(), totalChecksAmount.precision()));

        

    }
    

}
