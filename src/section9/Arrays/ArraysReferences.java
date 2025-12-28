package section9.Arrays;

import java.util.Arrays;

public class ArraysReferences {

    //  REFERENCES & ARRAYS
    //  (for more info on References, consult Section 7)

    //  When you assign a variable to an object, that variable becomes a reference of said object;
    //  Every object can have one or more references;

    //  Every ELEMENT in an ARRAY is also a REFERENCE;

    public static void main(String[] args) {
        
        //  both references point to the same object;
        int[] myIntArray = new int[5];
        int[] anotherArray = myIntArray;

        System.out.println("myIntArray = " + Arrays.toString(myIntArray));
        System.out.println("anotherArray = " + Arrays.toString(anotherArray));

        //  modification will affect object, thereby both references;
        anotherArray[0] = 1;
        modifyArray(myIntArray);

        System.out.println("myIntArray after change = " + Arrays.toString(myIntArray));
        System.out.println("anotherArray after change = " + Arrays.toString(anotherArray));

    }

    public static void modifyArray(int[] array) {

        array[1] = 2;

    }

}
