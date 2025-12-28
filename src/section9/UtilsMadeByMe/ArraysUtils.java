package section9.UtilsMadeByMe;

import java.util.Random;

public class ArraysUtils {
    
    //  psvm for testing and debugging purposes;
    public static void main(String[] args) {
        
        String stringA = "Alpha";
        String stringB = "Bravo";
        String stringC = "Bravo";
        String stringD = "bravo";
        String stringE = "BravoCharlie";

        //  .stringEquals()
        //  returns 0 if both strings are equal;
        //  returns negative number if strings are different, and first argument comes BEFORE second argument alphabetically;
        //  returns positive number if strings are different, and first argument comes AFTER second argument alphabetically;
        System.out.println(stringEquals(stringA, stringB));     //  output:  -1;
        System.out.println(stringEquals(stringB, stringC));     //  output:  0;
        System.out.println(stringEquals(stringC, stringD));     //  output:  -1;
        System.out.println(stringEquals(stringC, stringE));     //  output:  -6;
        System.out.println(stringEquals(stringE, stringA));     //  output:  1;

    }

    public static int stringEquals(String stringA, String stringB) {

        //  this ensures no IndexOutOfBOundsException gets thrown;
        String shortString = stringA.length() < stringB.length() ? stringA : stringB;

        for (int i = 0; i < shortString.length(); i++) {

            if (stringA.charAt(i) == stringB.charAt(i)) {
                continue;
            }

            if (stringA.charAt(i) < stringB.charAt(i)) {
                return -(i + 1);    //  stringA comes before stringB;
            }

            if (stringA.charAt(i) > stringB.charAt(i)) {
                return i + 1;       //  stringA comes after stringB;
            }

        }

        //  prefix test
        if (stringA.length() < stringB.length()) {
            //  stringA and stringB are equal up to shortString.length() + 1, but stringB is longer;
            //  stringA comes before stringB;
            return - (shortString.length() + 1);    
        }
        if (stringA.length() > stringB.length()) {
            //  stringA and stringB are equal up to shortString.length() + 1, but stringA is longer;
            //  stringA comes after stringB;
            return shortString.length();    
        }

        return 0;                   //  strings are equal; lengths are equal;

    } 

    //  random integers generator;
    public static int[] getRandomArray(int len) {
        //  Random returns a random number;
        Random random = new Random();
        int[] intArray = new int[len];
        for (int i = 0; i < len; i++) {
            intArray[i] = random.nextInt(100);
        }
        return intArray;
    }

    //  random doubles generator;
    public static double[] getRandomDoubleArray(int len) {
        //  Random returns a random number;
        Random random = new Random();
        double[] array = new double[len];
        for (int i = 0; i < len; i++) {
            array[i] = random.nextDouble();
        }
        return array;
    }

}
