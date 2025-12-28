package section9.Arrays;

import java.util.Arrays;

public class NestedArrays {
    
    //  NESTED ARRAYS
    //  Nested arrays are basically arrays inside arrays;

    public static void main(String[] args) {
        
        //  Two Dimensional Arrays can be thought of a MATRIX or TABLE;

        //  Array initializer formated over multiple lines;
        int[][] arrayA =    {
                                {1, 2, 3},
                                {11, 12, 13},
                                {21, 22, 23},
                                {31, 32, 33}
                            };

        //  Array initializer declared on one line;
        int[][] arrayB = {{1, 2, 3}, {11, 12, 13}, {21, 22, 23}, {31, 32, 33}};

        //  Two dimensional arrays don't necessarily have to be a uniform matrix;
        //  Each element of arrayC is an array of different length;
        int[][] arrayC =    {
                                {1, 2},
                                {11, 12, 13},
                                {21, 22, 23, 24, 25}
                            };

        //  INITIALIZATION;
        //  [outer array size][inner array size];
        int[][] arrayD = new int[3][3];
        //  It is possible to initialize only with the outer array size (inner arrays will be initialized to default values);
        int[][] arrayE = new int[3][];
        //  We are LIMITED to assigning INTEGER ARRAYS as elements!
        //  They can be of any length though;

        //  DECLARATION;
        int[][] arrayF;
        int[] arrayG[];



        //  ############################################################  //

        int[][] array = new int[4][4];
        System.out.println(Arrays.toString(array));                 //  returns inner array's hashcode;
        System.out.println("array.length = " + array.length);

        for (int[] innerArray : array) {
            System.out.println(Arrays.toString(innerArray));        //  returns toString() of each inner array;
        }

        for (int i = 0; i < array.length; i++) {
            //  VAR statement infers the data type;
            var innerArray = array[i];
            for (int j = 0; j < innerArray.length; j++) {
                System.out.print(array[i][j] + " ");                //  prints (same line) each element of the given inner array;
            }
            System.out.println();                                   //  breaks next line between inner arrays;
        }

        for (var innerArray : array) {
            for (var element : innerArray) {
                System.out.print(element + " ");                    //  prints (same line) each element of the given inner array;
            }
            System.out.println();                                   //  breaks next line between inner arrays;
        }

        //  DEEPTOSTRING()
        //  .deepToString() is simply the .toString() of multidimensional arrays;
        System.out.println(Arrays.deepToString(array));             //  returns toString() of outer array;



        //  ASSIGNING VALUES TO MULTIDIMENSIONAL ARRAYS;
        for (int i = 0; i < array.length; i++) {
            var innerArray = array[i];
            for (int j = 0; j < innerArray.length; j++) {
                array[i][j] = (i * 10) + (j + 1);
            }
        }

        System.out.println(Arrays.deepToString(array));

        array[1] = new int[] {10, 20, 30};
        System.out.println(Arrays.deepToString(array));



        //  ############################################################  //

        Object[] newArray = new Object[3];                          //  will get initialized to default: null;
        System.out.println(Arrays.toString(newArray));

        newArray[0] = new String[] {"a", "b", "c"};                 //  1 dimensional array as element at index 0;               
        System.out.println(Arrays.deepToString(newArray));

        newArray[1] = new String[][]    {                           //  2 dimensional array as element at index 1;
                                            {"1", "2"},
                                            {"3", "4", "5"},
                                            {"6", "7", "8", "9"}
                                        };
        
        newArray[2] = new int[2][2][2];                             //  3 dimensional array as element at index 2;
        System.out.println(Arrays.deepToString(newArray));

        //  no data type verification is implemented on this code;
        //  this is bad practice, but for now sufices as example of how to print multidimensional arrays of unknown data types;
        for (Object element : newArray) {
            System.out.println("Element type = " + element.getClass().getSimpleName());         //  returns data type;
            System.out.println("Element toString() = " + element);                              //  returns hashcode;
            //  (Object[]) cast is necessary;
            //  because .deepToString() needs an array;
            //  and java doesn't know what data types are inside outer array (compiler error);
            System.out.println(Arrays.deepToString((Object[]) element));                        //  returns toString() of inner arrays;
        }

    }

}
