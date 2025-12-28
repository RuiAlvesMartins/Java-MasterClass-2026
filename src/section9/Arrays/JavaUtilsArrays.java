package section9.Arrays;

import java.util.*;

public class JavaUtilsArrays {
    
    //  JAVA.UTILS.ARRAYS
    //  https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Arrays.html

    public static void main(String[] args) {

        //  generate a random numbers array;
        int[] firstArray = getRandomArray(10);
        //  .toString();
        System.out.println(Arrays.toString(firstArray));
        //  .sort();
        Arrays.sort(firstArray);
        System.out.println(Arrays.toString(firstArray));

        int[] secondArray = new int[10];
        System.out.println(Arrays.toString(secondArray));
        //  .fill();
        //  fills array with all elements = passed argument;
        Arrays.fill(secondArray, 5);
        System.out.println(Arrays.toString(secondArray));

        int[] thirdArray = getRandomArray(10);
        System.out.println(Arrays.toString(thirdArray));
        //  .copyOf();
        int[] fourthArray = Arrays.copyOf(thirdArray, thirdArray.length);
        System.out.println(Arrays.toString(fourthArray));

        Arrays.sort(fourthArray);
        System.out.println(Arrays.toString(thirdArray));    //  unsorted
        System.out.println(Arrays.toString(fourthArray));   //  sorted

        int[] smallerArray = Arrays.copyOf(thirdArray, 5);
        System.out.println(Arrays.toString(smallerArray));  //  will return a new array with a copy of the first 5 elements;

        int[] largerArray = Arrays.copyOf(thirdArray, 15);
        System.out.println(Arrays.toString(largerArray));   //  will return a new copied array with an aditional 5 elements (values set to default);



        //  .binarySearch()
        //  returns the index position of a match, if found;
        //  returns -1 if no match is found;
        String[] sArray = {"Able", "Jane", "Mark", "Ralph", "David"};
        //  .binarySearch() only works on SORTED arrays!
        //  also assumes there are no duplicate values!
        Arrays.sort(sArray);
        System.out.println(Arrays.toString(sArray));
        if (Arrays.binarySearch(sArray, "Mark") >= 0) {
            System.out.println("Found Mark in the list");            
        }

        //  .equals()
        //  returns true if arrays are equal, false otherwise;
        int[] s1 = {1, 2, 3, 4, 5};
        int[] s2 = {1, 2, 3, 4, 5};
        if (Arrays.equals(s1, s2)) {
            System.out.println("Arrays are equal");
        } else {
            System.out.println("Arrays are not equal");
        }

    }

    //  random numbers generator;
    private static int[] getRandomArray(int len) {
        //  Ranndom returns a random number;
        Random random = new Random();
        int[] intArray = new int[len];
        for (int i = 0; i < len; i++) {
            intArray[i] = random.nextInt(100);
        }
        return intArray;
    }

}
