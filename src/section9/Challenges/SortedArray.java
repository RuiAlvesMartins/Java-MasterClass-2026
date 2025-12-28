package section9.Challenges;

import java.util.Scanner;

public class SortedArray {

    public static void main(String[] args) {
        
        int[] integerArray = getIntegers(10);
        int[] reversedArray = sortIntegers(integerArray);
        printArray(reversedArray);

    }

    //  returns an array of integers inputed from keyboard
    public static int[] getIntegers(int size) {

        Scanner scanner = new Scanner(System.in);
        String stringInput = "";
        int integer = 0;
        boolean validInput = false;
        int[] array = new int[size];        

        System.out.println("INTEGER ARRAY INPUT PROGRAM");
        System.out.printf("Array size: %d elements%n", size);

        for (int index = 0; index < size; index++) {

            do {

                System.out.printf("Input #%d element:%n", index + 1);
                stringInput = scanner.nextLine();

                try {
                    integer = Integer.parseInt(stringInput);
                    validInput = true;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input!");
                    System.out.println("Valid integer range: "+Integer.MIN_VALUE+" to "+Integer.MAX_VALUE);
                }

            } while (!validInput);

            System.out.printf("#%d element validated as %d%n", index + 1, integer);

            validInput = false;
            array[index] = integer;

        }
        
        System.out.printf("All %d elements successfuly inputed%n", size);
        printArray(array);
        System.out.println("PROGRAM EXIT");

        return array;

    }

    // prints array
    public static void printArray(int[] array) {

        for (int index = 0; index < array.length; index++) {
            System.out.printf("Element %d contents %d%n", index + 1, array[index]);
        }
        
    }

    //  returns a new array sorted in reverse order
    public static int[] sortIntegers(int[] array) {

        int[] reversedArray = new int[array.length];
        //  copying array into reversedArray
        for (int i = 0; i < array.length; i++) {
            reversedArray[i] = array[i];
        }

        int memory;
        int cycles = 0;
        boolean cycleSorted = true;

        //  reverses reversedArray
        while (cycleSorted) {
            
            cycleSorted = false;

            for (int i = reversedArray.length - 2; i >= 0 + cycles; i--) {

                if (reversedArray[i] < reversedArray[i + 1]) {
                    
                    memory = reversedArray[i];
                    reversedArray[i] = reversedArray[i + 1];
                    reversedArray[i + 1] = memory;

                    cycleSorted = true;

                }

            }

            cycles++;

        }

        return reversedArray;

    }

}
