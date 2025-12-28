package section9.UtilsMadeByMe;

import static section9.UtilsMadeByMe.ArraysUtils.*;
import static section9.UtilsMadeByMe.SortArrays.*;

public class BinarySearch {

    //  psvm for testing and debugging purposes;
    public static void main(String[] args) {
        
        int[] intArray = new int[] {0};
        // System.out.println(binarySearchInt(intArray, 1));

        intArray[0] = 1;
        // System.out.println(binarySearchInt(intArray, 1));

        intArray = new int[] {1, 2, 3, 4, 5};
        // System.out.println(binarySearchInt(intArray, 4));
        // System.out.println(intArray[3]);

        int[] reverseIntArray = new int[] {5, 4, 3, 2, 1};
        // binarySearchInt(reverseIntArray, 0);

        int[] randomArray = getRandomArray(45);
        // System.out.println(Arrays.toString(randomArray));
        sort(randomArray);
        // System.out.println(Arrays.toString(randomArray));

        // System.out.println(9 / 4);
        // sort(randomArray);
        // System.out.println(Arrays.toString(randomArray));
        // System.out.println(binarySearchInt(randomArray, 80));
        // System.out.println(binarySearchInt(randomArray, 80) < 0 ? -1 : randomArray[binarySearchInt(randomArray, 80)]);

        int[] hundredArray = new int[100];
        for (int i = 0; i < hundredArray.length; i++) {
            hundredArray[i] = i;
        }
        sort(hundredArray);
        // System.out.println(Arrays.toString(hundredArray));
        // hundredArray[74] = 74;
        // System.out.println(binarySearchInt(hundredArray, 74));
        // System.out.println(hundredArray[80]);
        // System.out.println(binarySearchInt(hundredArray, 80) < 0 ? -1 : hundredArray[binarySearchInt(hundredArray, 80)]);

        // System.out.println(binarySearch(hundredArray, 73));

        double[] hundredDoubleArray = new double[100];
        for (int i = 0; i < hundredDoubleArray.length; i++) {
            hundredDoubleArray[i] = (double) i;
        }
        sort(hundredDoubleArray);
        // System.out.println(Arrays.toString(hundredDoubleArray));
        hundredDoubleArray[74] = 74D;
        // System.out.println(binarySearch(hundredDoubleArray, 74D));

        String[] stringArray = new String[] {"Albert", "Bill", "Charlie", "Dave", "Eddie"};
        // System.out.println(binarySearch(stringArray, "Bill"));

        boolean[] booleanArray = new boolean[] {false, false, false, true, false};
        // System.out.println(Arrays.binarySearch(booleanArray, true));

        sort(stringArray);

        System.out.println(stringArray[binarySearch(stringArray, "Albert")]);
        System.out.println(binarySearch(stringArray, "Billie"));
        System.out.println(binarySearch(stringArray, "Eddie"));

    }

    //  returns position of a match if found;
    //  returns -1 if not found;
    //  assumes all values are unique!
    //  my own design!
    public static int binarySearchInt(int[] array, int searchTerm) {

        //  binarySearch is not supposed to sort the array;
        //  it is supposed to assume array is already sorted!
        sort(array);
        int min = 0;
        int max = array.length - 1;
        int mid = min + ((max - min) / 2);

        //  do while loop is a workaround for 2 element arrays;
        do {
            mid = min + ((max - min) / 2);
            if (array[mid] == searchTerm) {
                return mid;
            }
            if (array[mid] > searchTerm) {
                max = mid;
            }
            if (array[mid] < searchTerm) {
                min = mid;
            }
            if (array[min] == searchTerm) {
                return min;
            }
            if (array[max] == searchTerm) {
                return max;
            }
        } while (max - min > 1);

        return -1;

    }

    //  a more conventional design;
    public static int binarySearch(int[] array, int key) {
        int min = 0;
        int max = array.length - 1;
        int mid;

        while (min <= max) {

            mid = min + ((max - min) / 2);  //  initializes mid;      

            if (array[mid] == key) {
                return mid; // found it!
            } 
            if (array[mid] < key) {
                min = mid + 1; // search right half
                //  as index mid has already been scanned, min = mid + 1 excludes it from the right half in the next search cycle;
                //  it also overbounds the min/max range in the while loop if no key is found;
            } 
            if (array[mid] > key) {
                max = mid - 1; // search left half
                //  as index mid has already been scanned, min = mid + 1 excludes it from the left half in the next search cycle;
                //  it also overbounds the min/max range in the while loop if no key is found;
            }
        }

        return -(min + 1); // not found
        //  not only returns a negative number
        //  but also returns the index position key would be in if it existed in the array;
    }

    //  the same conventional design, but for double[];
    public static int binarySearch(double[] array, double key) {
        int min = 0;
        int max = array.length - 1;
        int mid;

        while (min <= max) {

            mid = min + ((max - min) / 2);  //  initializes mid;      

            if (array[mid] == key) {
                return mid; // found it!
            } 
            if (array[mid] < key) {
                min = mid + 1; // search right half
                //  as index mid has already been scanned, min = mid + 1 excludes it from the right half in the next search cycle;
                //  it also overbounds the min/max range in the while loop if no key is found;
            } 
            if (array[mid] > key) {
                max = mid - 1; // search left half
                //  as index mid has already been scanned, min = mid + 1 excludes it from the left half in the next search cycle;
                //  it also overbounds the min/max range in the while loop if no key is found;
            }
        }

        return -(min + 1); // not found
        //  not only returns a negative number
        //  but also returns the index position key would be in if it existed in the array;
    }

    //  binarySearch for String[];
    //  uses .stringEquals() as comparator;
    public static int binarySearch(String[] array, String key) {

        int min = 0;
        int max = array.length - 1;
        int mid;
        int comparatorOutcome;

        while (min <= max) {

            mid = min + ((max - min) / 2);  //  initializes mid;  

            // System.out.println(array[mid]);

            //  .stringEquals() is a method of this class;
            comparatorOutcome = stringEquals(array[mid], key);

            //  if array[mid] equal to key, .stringEquals() returns 0;
            if (comparatorOutcome == 0) {
                return mid; // found it!
            } 
            //  if array[mid] less than key, .stringEquals() returns negative number;
            if (comparatorOutcome < 0) {
                min = mid + 1; // search right half
                //  as index mid has already been scanned, min = mid + 1 excludes it from the right half in the next search cycle;
                //  it also overbounds the min/max range in the while loop if no key is found;
            } 
            //  if array[mid] more than key, .stringEquals() returns positive number;
            if (comparatorOutcome > 0) {
                max = mid - 1; // search left half
                //  as index mid has already been scanned, min = mid + 1 excludes it from the left half in the next search cycle;
                //  it also overbounds the min/max range in the while loop if no key is found;
            }
        }

        return -(min + 1); // not found
        //  not only returns a negative number
        //  but also returns the index position key would be in if it existed in the array;

    }

    //  the same conventional design, but for Object[];
    //  implements Comparator.compareTo();
    //  can search Strings, Integer[] Double[], and any other data type that implements Comparator;
    //  WILL THROW ClassCastException if Object doesn't implement Comparable;
    public static int binarySearch(Object[] array, Object key) {
        int min = 0;
        int max = array.length - 1;
        int mid;
        Comparable midVal;
        int comparatorOutcome;

        while (min <= max) {

            mid = min + ((max - min) / 2);  //  initializes mid;  
            //  COMPARABLE
            //  Allows various data types to be cast, and applied the .compareTo method;
            //  It also works with Strings;    
            midVal = (Comparable)array[mid];
            //  .compareTo() is a method of Comparable class;
            //  it compares the object calling it to the key passed as argument;
            comparatorOutcome = midVal.compareTo(key);

            //  if array[mid] equal to key, .compareTo() returns 0;
            if (comparatorOutcome == 0) {
                return mid; // found it!
            } 
            //  if array[mid] less than key, .compareTo() returns negative number;
            if (comparatorOutcome < 0) {
                min = mid + 1; // search right half
                //  as index mid has already been scanned, min = mid + 1 excludes it from the right half in the next search cycle;
                //  it also overbounds the min/max range in the while loop if no key is found;
            } 
            //  if array[mid] more than key, .compareTo() returns positive number;
            if (comparatorOutcome > 0) {
                max = mid - 1; // search left half
                //  as index mid has already been scanned, min = mid + 1 excludes it from the left half in the next search cycle;
                //  it also overbounds the min/max range in the while loop if no key is found;
            }
        }

        return -(min + 1); // not found
        //  not only returns a negative number
        //  but also returns the index position key would be in if it existed in the array;
    }

}
