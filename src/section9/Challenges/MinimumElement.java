package section9.Challenges;

import java.util.Arrays;
import java.util.Scanner;

public class MinimumElement {

    public static void main(String[] args) {
        
        int[] intArray2 = readIntegers();
        System.out.println(Arrays.toString(intArray2));

        int size = readInteger();
        int[] intArray = readElements(size);
        System.out.println(Arrays.toString(intArray));

        int intMin = findMin(intArray);
        System.out.println("Minimum element in array = " + intMin);

    }

    private static int readInteger() {

        Scanner scanner = new Scanner(System.in);
        String stringInput = "";
        int integer = 0;
        boolean validInput = false;

        System.out.println("INTEGER INPUT PROGRAM");

        do {

            System.out.printf("Input integer in the valid range%n");
            stringInput = scanner.nextLine();

            try {
                integer = Integer.parseInt(stringInput);
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input!");
                System.out.println("Valid integer range: "+Integer.MIN_VALUE+" to "+Integer.MAX_VALUE);
            }

        } while (!validInput);

        System.out.printf("%d validated as integer%n", integer);
        System.out.println("PROGRAM EXIT");

        return integer;

    }

    private static int[] readIntegers() {

        Scanner scanner = new Scanner(System.in);
        String stringInput = "";

        System.out.println("INTEGER COMA SEPARATED LIST INPUT PROGRAM");
        System.out.println("Enter a list of integers, separated by comas (,):");
        stringInput = scanner.nextLine();

        String[] stringArray = stringInput.split(",");
        int[] intArray = new int[stringArray.length];

        for (int i = 0; i < stringArray.length; i++) {
            intArray[i] = Integer.parseInt(stringArray[i].trim());
        }

        System.out.println("All elements successfuly parsed to integer");
        System.out.println("PROGRAM EXIT");

        return intArray;

    }

    private static int[] readElements(int arrayLength) {

        Scanner scanner = new Scanner(System.in);
        String stringInput = "";
        int integer = 0;
        boolean validInput = false;
        int[] array = new int[arrayLength];

        System.out.println("INTEGER ARRAY INPUT PROGRAM");
        System.out.printf("Array size: %d elements%n", arrayLength);

        for (int i = 0; i < arrayLength; i++) {

            do {

                System.out.printf("Input #%d element:%n", i);
                stringInput = scanner.nextLine();

                try {
                    integer = Integer.parseInt(stringInput);
                    validInput = true;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input!");
                    System.out.println("Valid integer range: "+Integer.MIN_VALUE+" to "+Integer.MAX_VALUE);
                }

            } while (!validInput);

            System.out.printf("#%d element validated as %d%n", i, integer);

            validInput = false;
            array[i] = integer;

        }

        System.out.printf("All %d elements successfuly inputed%n", arrayLength);
        System.out.println("PROGRAM EXIT");

        return array;

    }

    private static int findMin(int[] array) {

        int min = Integer.MAX_VALUE;        

        for (int i = 0; i < array.length; i++) {

            if (array[i] < min) {
                min = array[i];
            }

        }

        return min;

    }

}
