package section9.UtilsMadeByMe;

import static section9.UtilsMadeByMe.ArraysUtils.*;

import java.util.Arrays;

public class SortArrays {

    //  psvm for testing and debugging purposes;
    public static void main(String[] args) {

        int[] intArray = new int[100];
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = i;
        }

        double[] doubleArray = new double[100]; 
        for (int i = 0; i < doubleArray.length; i++) {
            doubleArray[i] = (double) i;
        }

        String[] stringArray = new String[] {"Albert", "Bob", "Charlie", "Dave", "Eddie", "Frank", "George", "Hank", "Igor", "Johnny"};


        // System.out.println("##############################");
        // System.out.println(Arrays.toString(intArray));
        // sort(intArray, true);
        // System.out.println(Arrays.toString(intArray));
        // sort(intArray, false);
        // System.out.println(Arrays.toString(intArray));

        // System.out.println("##############################");
        // System.out.println(Arrays.toString(doubleArray));
        // sort(doubleArray, true);
        // System.out.println(Arrays.toString(doubleArray));
        // sort(doubleArray, false);
        // System.out.println(Arrays.toString(doubleArray));

        // System.out.println("##############################");
        // System.out.println(Arrays.toString(stringArray));
        // sort(stringArray, true);
        // System.out.println(Arrays.toString(stringArray));
        // sort(stringArray, false);
        // System.out.println(Arrays.toString(stringArray));

        // System.out.println("##############################");
        sort(intArray);
        sort(doubleArray);
        sort(stringArray);
        sort(stringArray);


        System.out.println("##############################");
        sort(intArray);
        System.out.println(sortCheck(intArray));
        System.out.println(sortCheckAsc(intArray));
        sort(intArray, true);
        System.out.println(sortCheck(intArray));
        System.out.println(sortCheckDes(intArray));
        int[] randomIntArray = getRandomArray(100);
        System.out.println(sortCheck(randomIntArray));
        System.out.println(sortCheckAsc(randomIntArray));
        System.out.println(sortCheckDes(randomIntArray));

        System.out.println("##############################");
        sort(doubleArray);
        System.out.println(sortCheck(doubleArray));
        System.out.println(sortCheckAsc(doubleArray));
        sort(doubleArray, true);
        System.out.println(sortCheck(doubleArray));
        System.out.println(sortCheckDes(doubleArray));
        double[] randomDoubleArray = Arrays.copyOf(doubleArray, doubleArray.length);
        randomDoubleArray[1] = 200D;
        System.out.println(sortCheck(randomDoubleArray));
        System.out.println(sortCheckAsc(randomDoubleArray));
        System.out.println(sortCheckDes(randomDoubleArray));

        System.out.println("##############################");
        sort(stringArray);
        System.out.println(sortCheck(stringArray));
        System.out.println(sortCheckAsc(stringArray));
        sort(stringArray, true);
        System.out.println(sortCheck(stringArray));
        System.out.println(sortCheckDes(stringArray));
        String[] randomStringArray = Arrays.copyOf(stringArray, stringArray.length);
        randomStringArray[1] = "Zorro";
        System.out.println(sortCheck(randomStringArray));
        System.out.println(sortCheckAsc(randomStringArray));
        System.out.println(sortCheckDes(randomStringArray));

    }

    //  this is a Bubble Sort Algorithm;
    //  it is simple, but very ineficient for large datasets;
    //  for such cases, look into Merge Sort and Quick Sort algorithms;
    public static void sort(int[] array, boolean reverse) {

        int memory;
        int cycles = 0;
        boolean cycleSorted = true;

        //  regular bubble sort;
        if (!reverse) {

            while (cycleSorted) {

                cycleSorted = false;

                for (int i = 1; i < array.length - cycles; i++) {
                    
                    //  starts search at index 1, the 2nd position;
                    //  compares current position [i] with previous one [i - 1];
                    //  if value [i - 1] is greater than value [i], it will swap them;
                    //  the inner FOR loop will cycle through the entire array;
                    if (array[i] < array[i - 1]) {
                        memory = array[i];
                        array[i] = array [i - 1];
                        array[i - 1] = memory;

                        //  because we cannot guarantee a fully sorted array on just one pass;
                        //  the inner FOR loop repeats as long as changes to the array are made;
                        //  in the final pass, when array is fully sorted, this if condition will not be triggered;
                        //  cycleSorted will be set to false, and it will break out of the WHILE loop;
                        cycleSorted = true;
                    }

                }

                //  on each pass of the FOR loop, the last index gets the correct value;
                //  we can improve eficiency by reducing array range to be sorted by -1 on ech pass of the for loop;
                //  this is still very ineficient for large arrays though;
                cycles++;

            }

        }

        //  reverse bubble sort;
        if (reverse) {

            while (cycleSorted) {

                cycleSorted = false;

                //  in reverse sorting, FOR loop has to be reversed;
                for (int i = array.length - 2; i >= 0 + cycles ; i--) {

                    //  in reverse, it starts at index array.length - 2, the 2nd to last index;
                    //  compares current position [i] with the next one [i + 1];
                    //  if value [i + 1] is greater than value [i], it will swap them;
                    if (array[i] < array[i + 1]) {
                        memory = array[i];
                        array[i] = array [i + 1];
                        array[i + 1] = memory;

                        cycleSorted = true;
                    }

                }

                cycles++;

            }

        }

        // System.out.printf("Ran for %s cycles%n", cycles);

    }

    //  Bubble Sort for double[];
    public static void sort(double[] array, boolean reverse) {

        double memory;
        int cycles = 0;
        boolean cycleSorted = true;

        //  regular bubble sort;
        if (!reverse) {

            while (cycleSorted) {

                cycleSorted = false;

                for (int i = 1; i < array.length - cycles; i++) {
                    
                    //  starts search at index 1, the 2nd position;
                    //  compares current position [i] with previous one [i - 1];
                    //  if value [i - 1] is greater than value [i], it will swap them;
                    //  the inner FOR loop will cycle through the entire array;
                    if (array[i] < array[i - 1]) {
                        memory = array[i];
                        array[i] = array [i - 1];
                        array[i - 1] = memory;

                        //  because we cannot guarantee a fully sorted array on just one pass;
                        //  the inner FOR loop repeats as long as changes to the array are made;
                        //  in the final pass, when array is fully sorted, this if condition will not be triggered;
                        //  cycleSorted will be set to false, and it will break out of the WHILE loop;
                        cycleSorted = true;
                    }

                }

                //  on each pass of the FOR loop, the last index gets the correct value;
                //  we can improve eficiency by reducing array range to be sorted by -1 on ech pass of the for loop;
                //  this is still very ineficient for large arrays though;
                cycles++;

            }

        }

        //  reverse bubble sort;
        if (reverse) {

            while (cycleSorted) {

                cycleSorted = false;

                //  in reverse sorting, FOR loop has to be reversed;
                for (int i = array.length - 2; i >= 0 + cycles ; i--) {

                    if (array[i] < array[i + 1]) {
                        memory = array[i];
                        array[i] = array [i + 1];
                        array[i + 1] = memory;

                        cycleSorted = true;
                    }

                }

                cycles++;

            }

        }

        // System.out.printf("Ran for %s cycles%n", cycles);

    }

    //  Bubble Sort for String[];
    //  uses sortEquals() for string comparison;
    public static void sort(String[] array, boolean reverse) {

        String memory;
        int cycles = 0;
        boolean cycleSorted = true;
        int comparatorOutcome;

        //  regular bubble sort;
        if (!reverse) {

            while (cycleSorted) {

                cycleSorted = false;

                for (int i = 1; i < array.length - cycles; i++) {
                    
                    comparatorOutcome = stringEquals(array[i], array[i - 1]);

                    if (comparatorOutcome < 0) {
                        memory = array[i];
                        array[i] = array [i - 1];
                        array[i - 1] = memory;

                        cycleSorted = true;
                    }

                }

                cycles++;

            }

        }

        //  reverse bubble sort;
        if (reverse) {

            while (cycleSorted) {

                cycleSorted = false;

                //  in reverse sorting, FOR loop has to be reversed;
                for (int i = array.length - 2; i >= 0 + cycles ; i--) {

                    comparatorOutcome = stringEquals(array[i], array[i + 1]);

                    if (comparatorOutcome < 0) {
                        memory = array[i];
                        array[i] = array [i + 1];
                        array[i + 1] = memory;

                        cycleSorted = true;
                    }

                }

                cycles++;

            }

        }

    }

    //  Bubble Sort for Object[];
    //  implements Comparator.compareTo();
    //  can search String[], Integer[] Double[], and any other data type that implements Comparator;
    //  WILL THROW ClassCastException if Object doesn't implement Comparable;
    public static void sort(Object[] array, boolean reverse) {

        Object memory;
        int cycles = 0;
        boolean cycleSorted = true;
        Comparable currentPosition;
        Comparable previousPosition;
        Comparable nextPosition;
        int comparatorOutcome;

        //  regular bubble sort;
        if (!reverse) {

            while (cycleSorted) {

                cycleSorted = false;

                for (int i = 1; i < array.length - cycles; i++) {
                    
                    currentPosition = (Comparable)array[i];
                    previousPosition = (Comparable)array[i-1];
                    comparatorOutcome = currentPosition.compareTo(previousPosition);

                    if (comparatorOutcome < 0) {
                        memory = array[i];
                        array[i] = array [i - 1];
                        array[i - 1] = memory;

                        cycleSorted = true;
                    }

                }

                cycles++;

            }

        }

        //  reverse bubble sort;
        if (reverse) {

            while (cycleSorted) {

                cycleSorted = false;

                //  in reverse sorting, FOR loop has to be reversed;
                for (int i = array.length - 2; i >= 0 + cycles ; i--) {

                    currentPosition = (Comparable)array[i];
                    nextPosition = (Comparable)array[i+1];
                    comparatorOutcome = currentPosition.compareTo(nextPosition);

                    if (comparatorOutcome < 0) {
                        memory = array[i];
                        array[i] = array [i + 1];
                        array[i + 1] = memory;

                        cycleSorted = true;
                    }

                }

                cycles++;

            }

        }

        // System.out.printf("Ran for %s cycles%n", cycles);

    }



    public static void sort(int[] array) {
        sort(array, false);
    }

    public static void sort(double[] array) {
        sort(array, false);
    }

    public static void sort(String[] array) {
        sort(array, false);
    }

    public static void sort(Object[] array) {
        sort(array, false);
    }



    //  returns 1 if sorted ascending;
    //  returns -1 if sorted descending;
    //  returns 0 if unsorted;
    public static int sortCheck(int[] array) {

        //  boolean vars initialized to TRUE so while loop will start;
        boolean asc = true;     //  will check if array is sorted ascending;
        boolean des = true;     //  will check if array is sorted descending;

        for (int i = 1; i < array.length; i++) {
            //  once a boolean is set to false, ifs will no longer initialize;
            if (asc) {
                asc = array[i] >= array[i - 1] ? true : false;
            }
            if (des) {
                des = array[i] <= array[i - 1] ? true : false;
            }

            //  if both booleans are set to false, for loop breaks for saving computation time;
            if (!asc && !des) {
                break;
            }

        }

        if (asc) {
            return 1;       //  returns 1 if sorted ascending;
        }
        if (des) {
            return -1;      //  returns -1 if sorted descending;
        }
        return 0;           //  returns 0 if unsorted;

    }

    //  returns 1 if sorted ascending;
    //  returns -1 if sorted descending;
    //  returns 0 if unsorted;
    public static int sortCheck(double[] array) {

        //  boolean vars initialized to TRUE so while loop will start;
        boolean asc = true;     //  will check if array is sorted ascending;
        boolean des = true;     //  will check if array is sorted descending;

        for (int i = 1; i < array.length; i++) {
            //  once a boolean is set to false, ifs will no longer initialize;
            if (asc) {
                asc = array[i] >= array[i - 1] ? true : false;
            }
            if (des) {
                des = array[i] <= array[i - 1] ? true : false;
            }

            //  if both booleans are set to false, for loop breaks for saving computation time;
            if (!asc && !des) {
                break;
            }

        }

        if (asc) {
            return 1;       //  returns 1 if sorted ascending;
        }
        if (des) {
            return -1;      //  returns -1 if sorted descending;
        }
        return 0;           //  returns 0 if unsorted;

    }

    //  returns 1 if sorted ascending;
    //  returns -1 if sorted descending;
    //  returns 0 if unsorted;
    public static int sortCheck(String[] array) {

        //  boolean vars initialized to TRUE so while loop will start;
        boolean asc = true;     //  will check if array is sorted ascending;
        boolean des = true;     //  will check if array is sorted descending;
        int stringComparator;

        for (int i = 1; i < array.length; i++) {

            stringComparator = stringEquals(array[i], array[i - 1]);

            //  once a boolean is set to false, ifs will no longer initialize;
            if (asc) {
                asc = stringComparator >= 0 ? true : false;
            }
            if (des) {
                des = stringComparator <= 0 ? true : false;
            }

            //  if both booleans are set to false, for loop breaks for saving computation time;
            if (!asc && !des) {
                break;
            }

        }

        if (asc) {
            return 1;       //  returns 1 if sorted ascending;
        }
        if (des) {
            return -1;      //  returns -1 if sorted descending;
        }
        return 0;           //  returns 0 if unsorted;

    }

    //  returns 1 if sorted ascending;
    //  returns -1 if sorted descending;
    //  returns 0 if unsorted;
    public static int sortCheck(Object[] array) {

        //  boolean vars initialized to TRUE so while loop will start;
        boolean asc = true;     //  will check if array is sorted ascending;
        boolean des = true;     //  will check if array is sorted descending;
        Comparable currentPosition;
        Comparable previousPosition;
        int comparatorOutcome;

        for (int i = 1; i < array.length; i++) {

            currentPosition = (Comparable)array[i];
            previousPosition = (Comparable)array[i - 1];
            comparatorOutcome = currentPosition.compareTo(previousPosition);

            //  once a boolean is set to false, ifs will no longer initialize;
            if (asc) {
                asc = comparatorOutcome >= 0 ? true : false;
            }
            if (des) {
                des = comparatorOutcome <= 0 ? true : false;
            }

            //  if both booleans are set to false, for loop breaks for saving computation time;
            if (!asc && !des) {
                break;
            }

        }

        if (asc) {
            return 1;       //  returns 1 if sorted ascending;
        }
        if (des) {
            return -1;      //  returns -1 if sorted descending;
        }
        return 0;           //  returns 0 if unsorted;

    }



    public static boolean sortCheckAsc(int[] array) {
        return sortCheck(array) == 1 ? true : false;
    }

    public static boolean sortCheckAsc(double[] array) {
        return sortCheck(array) == 1 ? true : false;
    }

    public static boolean sortCheckAsc(String[] array) {
        return sortCheck(array) == 1 ? true : false;
    }

    public static boolean sortCheckAsc(Object[] array) {
        return sortCheck(array) == 1 ? true : false;
    }

    public static boolean sortCheckDes(int[] array) {
        return sortCheck(array) == -1 ? true : false;
    }

    public static boolean sortCheckDes(double[] array) {
        return sortCheck(array) == -1 ? true : false;
    }

    public static boolean sortCheckDes(String[] array) {
        return sortCheck(array) == -1 ? true : false;
    }

    public static boolean sortCheckDes(Object[] array) {
        return sortCheck(array) == -1 ? true : false;
    }

}
