package section9.Challenges;

import static section9.UtilsMadeByMe.ArraysUtils.getRandomArray;

import java.util.Arrays;

public class ReverseArray {
    
    public static void main(String[] args) {
        
        int[] randomIntArray = getRandomArray(7);
        // System.out.println(Arrays.toString(randomIntArray));
        reverse(randomIntArray);
        // System.out.println(Arrays.toString(randomIntArray));

        int[] reversedArray = reverseCopy(randomIntArray);
        // System.out.println(Arrays.toString(reversedArray));

    }

    //  this is a MUTATING METHOD;
    //  it mutates calling code data (instead of returning a new array);
    private static void reverse(int[] array) {

        int memory;

        System.out.println("Array = " + Arrays.toString(array));

        for (int i = 0; i < (array.length / 2); i++) {

            memory = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = memory;

        }

        System.out.println("Reversed array = " + Arrays.toString(array));

    }

    //  this is a NON-MUTATING METHOD;
    //  it returns a new object, instead of tampering with existing one;
    private static int[] reverseCopy(int[] array) {

        int[] reversedArray = new int[array.length];

        System.out.println("Array = " + Arrays.toString(array));

        for (int i = 0; i < array.length; i++) {

            reversedArray[i] = array[array.length - 1 - i];

        }

        System.out.println("Reversed array = " + Arrays.toString(reversedArray));

        return reversedArray;

    }

}
