package section9.Arrays;

import java.util.Arrays;

public class ArraysBasics {
    
    //  ARRAYS
    //  Arrays are DATA STRUCTURES that allow the storage of a sequence of values of the same type;
    //  Arrays are also a special class in Java;
    //  Arrays can store the eigth primitives: byte, short, int, long, float, double, char, boolean;
    //  You can also have arrays for ANY class;
    //  Array INDEX starts at ZERO!
    //  Array INDEX goes all the way to (n - 1) (array.length - 1); 
    //  Throws ArrayIndexOutOfBoundsException;
    //  Arrays are NOT RESIZABLE! Once instantiated, and array's SIZE is FIXED!


    public static void main(String[] args) {
        
        //  DECLARING ARRAYS
        //  data type followed by [] followed by name;
        int[] integerArray;
        //  or also data type followed by name followed by [];
        String nameList[];

        //  INSTANTIATING ARRAYS
        //  NEW followed by data type followed by [];
        //  [size of the array]
        int[] intArray = new int[10];
        //  remember that once instantiated, an array's size is fixed!
        //  elements within the array are initialized to their DEFAULT values;

        //  ACCESSING ELEMENTS
        //  this code is assigning 50 to index position 6, not 5;
        //  because index count starts at 0!
        //  [index position]
        intArray[5] = 50;
        double[] doubleArray = new double[10];
        doubleArray[2] = 3.5;
        System.out.println(doubleArray[2]);
        //  you can't force a double into an integer array!
        // intArray[4] = 4.5;
        //  you can't assign a string to an integer array!
        // intArray[1] = "1";

        //  ARRAY INITIALIZER
        //  new dataType[] {elements specified in comma-delimited list};
        //  [] empty: Java automatically sets the size to the number of elements passed;
        int[] secondIntArray = new int[] {1, 2, 3, 4, 5};

        //  ARRAY INITIALIZER as ANONYMOUS ARRAY
        //  new dataType[] can be droped;
        int[] thirdIntArray = {1, 2, 3, 4, 5};
        //  this is known as an ANONYMOUS ARRAY; 
        //  it can only be initialized in a declaration statement!
        // int[] newArray;
        // newArray = {5, 4, 3, 2, 1};              //  compiler error!
        // newArray = new int[] {5, 4, 3, 2, 1};    //  this will work, because it is not anonymous initializer;

        //  .LENGTH
        //  returns the size of the array;
        int thirdIntArrayLength = thirdIntArray.length;
        System.out.println("Array size: " + thirdIntArrayLength);
        System.out.println("Last element: " + thirdIntArray[thirdIntArrayLength - 1]);

        //  LOOPING THROUGH ELEMENTS
        for (int i = 0; i < thirdIntArray.length; i++) {
            System.out.println(thirdIntArray[i]);
        }
        //  Array is a special java class, so it get's printed like one if you try;
        System.out.println(thirdIntArray);

        //  DEFAULT VALUES
        //  Integer: 0
        int[] newIntArray = new int[10];
        System.out.println("newIntArray #0: " + newIntArray[0]);
        //  when instantiated in this manner, all elements are initialized to their default values;
        printIntArray(newIntArray);
        //  Double: 0.0
        double[] newDoubleArray = new double[10];
        System.out.println("newDoubleArray #0: " + newDoubleArray[0]);
        //  Boolean: false
        boolean[] newBooleanArray = new boolean[10];
        System.out.println("newBooleanArray #0: " + newBooleanArray[0]); 
        //  String: null
        String[] newStringArray = new String[10];
        System.out.println("newStringArray #0: " + newStringArray[0]);

        //  POPULATING A DEFAULT VALUES ARRAY
        int[] newNewIntArray = new int[10];
        //  this loop will populate the array in reverse order;
        for (int i = 0; i < newNewIntArray.length; i++) {
            newNewIntArray[i] = newNewIntArray.length - i;
        }
        printIntArray(newNewIntArray);



        //  FOR EACH LOOP
        //  Also known as ENHANCED FOR LOOP
        //  It processes one element at a time, from the first to the last;
        //  Iteration variable not needed;
        //  for (declaration : collection) {}
        for (int intElement : newNewIntArray) {
            System.out.print(intElement + " ");
        }



        //  JAVA.UTIL.ARRAYS
        //  A helper class provided by Java;
        System.out.printf("%nJava Util Arrays%n");
        System.out.println(Arrays.toString(newNewIntArray));

        //  TESTING OBJECT TYPE
        if (newNewIntArray instanceof int[]) {
            System.out.println("Object is an Integer Array!");
        }


        
        //  MULTIPLE TYPE ARRAYS
        Object[] newestArray = new Object[6];
        newestArray[0] = "hello";
        newestArray[1] = new StringBuilder("World");
        newestArray[2] = 1;
        newestArray[3] = 1D;   
        newestArray[4] = true;
        //  ARRAYS INSIDE ARRAYS
        newestArray[5] = newNewIntArray;      

    }



    public static void printIntArray(int[] intArray) {
        System.out.print("Integer Array: ");
        for (int i = 0; i < intArray.length; i++) {
            System.out.print(intArray[i] + " ");
        }
        System.out.println("");
    }

}
