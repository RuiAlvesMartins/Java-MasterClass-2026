package section10.AutoBoxing;

import java.util.ArrayList;
import java.util.Arrays;

public class Boxing {
    
    //  What are PRIMITIVE TYPES and why does Java have them?

    //  PRIMITIVE TYPES generally represent the way data is stored on an operating system;
    //  OBJECTS require additional memory and processing power compared to primitives;
    //  So, if you need to store a high number of elements, primitives are advantageous;

    //  However, ARRAYLISTS, LINKEDLISTS, and other COLLECTIONS don't support PRIMITIVES;
    //  GENERICS (section 12) also don't support primitives;



    //  BOXING
    //  From PRIMITIVE to WRAPPER;
    // Integer boxedInt = new Integer(15);                  //  deprecated as of JDK-9!
    // Integer boxedInt = Integer.valueOf(15);
    //  .valueOf() is an overloaded factory method;
    //  accepts a primitive as an argument, and returns an instance of the wrapper class;

    //  AUTO BOXING
    //  From PRIMITIVE to WRAPPER, but implicit;
    // Integer boxedInt = 15;

    //  UNBOXING
    //  From WRAPPER to PRIMITIVE;
    // int unboxedInt = boxedInteger.intValue();
    //  .intValue() returns the primitive int from wrapper instance; 

    //  AUTO UNBOXING
    //  From WRAPPER to PRIMITIVE, but implicit;
    // int unboxedInt = boxedInteger;



    public static void main(String[] args) {
        
        //  Boxing
        Integer boxedInt = Integer.valueOf(15);
        //  Boxing (deprecated as of JDK-9)
        Integer deprecatedBoxing = new Integer(15);
        //  Unboxing
        int unboxedInt = boxedInt.intValue();

        //  Auto Boxing
        Integer autoBoxed = 15;
        //  Auto Unboxing
        int autoUnboxed = autoBoxed;

        System.out.println(autoBoxed.getClass().getName());
        // System.out.println(autoUnboxed.getClass().getName());    //  .getClass() not valid for primitives!

        //  Auto Boxing result from a method;
        Double resultBoxed = getLiteralDoublePrimitive();
        //  Auto Unboxing result from a method;
        double resultUnboxed = getDoubleObject();



        //  ARRAYS

        Integer[] wrapperArray = new Integer[5];
        //  Autoboxing 50 to index 0;
        wrapperArray[0] = 50;
        System.out.println(Arrays.toString(wrapperArray));      //  [50, null, null, null, null]
        System.out.println(wrapperArray[0].getClass().getName());

        int[] intArray = new int[5];
        intArray[0] = 50;
        System.out.println(Arrays.toString(intArray));          //  [50, 0, 0, 0, 0]
        // System.out.println(intArray[0].getClass().getName());

        //  Autoboxed into array (array initializer);
        Character[] characterArray = {'a', 'b', 'c', 'd'};
        System.out.println(Arrays.toString(characterArray));

        var ourList = getList(1, 2, 3, 4, 5);
        System.out.println(ourList);

    }

    private static ArrayList<Integer> getList(int... varargs) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i : varargs) {
            //  Autobixing into ArrayList:
            arrayList.add(i);
        }
        return arrayList;
    }

    private static int returnAnInt(Integer i) {
        return i;
    }

    private static int returnAnInteger(int i) {
        return i;
    }

    private static Double getDoubleObject() {
        return Double.valueOf(100.00);
    }

    private static double getLiteralDoublePrimitive() {
        return 100.00;
    }

}
