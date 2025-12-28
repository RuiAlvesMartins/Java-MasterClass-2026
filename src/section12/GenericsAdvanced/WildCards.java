package section12.GenericsAdvanced;

import java.util.ArrayList;
import java.util.List;

public class WildCards {

    public static void main(String[] args) {
        
        //  WILDCARDS
        //  Represented by '?';
        //  Means the type is UNKNOWN;
        //  A WildCard can only be used in a type ARGUMENT, NOT in the parameter DECLARATION!
        List<?> unknownList;

        //  A WildCard can't be used in an INSTANTIATION of a GENERIC CLASS!
        // var myList = new ArrayList<?>();                                //  compiler error!
    


        //  BOUNDS:
        //      Unbounded;
        //      Upper Bounded;
        //      Lower Bounded;

        //  UNBOUNDED WildCard:
        //  A list of ANY type may be passed to an argument specifying this wildcard;
        List <?> unboundedList;

        //  UPPER Bounded WildCard:
        //  A list of Student or any SUBtype may be passed to an argument specifying this wildcard;
        List <? extends Student> upperBoundedList;

        //  LOWER Bounded WildCard:
        //  A list of SubStudent or it's SUPERtype (e.g. Student) may be passed to an argument specifying this wildcard;
        List <? super SubStudent> lowerBoundedList;



        //  Specifying MULTIPLE UPPER BOUNDS
        //  (consult QueryList.java and Main.java)



        //  WildCard CAPTURE:
        //  The compiler's ability to INFER the correct type parameter;



        //  Type ERASURE:
        //  The process by which the Type Parameter gets REPLACED by it's TRUE TYPE;
        
        //  Generics exist to enforce tighter type checks at compile time;
        //  The compiler transforms a generic class into a typed class, meaning the byte code or class file contains no type parameters;
        //  Everywhere a type parameter is used in a class, it gets replaced with either the type Object, if no upper bound was specified, or the upper bound type itself;
        //  This transformation process is called TYPE ERASURE, because the T parameter (or S, U, V), is erased or replaced with a true type.

        //  This is important to know for Method OVERLOADING:
        testList(new ArrayList<String>(List.of("Able", "Barry", "Charlie")));
        testList(new ArrayList<Integer>(List.of(1, 2, 3)));

    }

    //  Type ERASURE (continuation):

    //  Because List<String> has no upper bound declared;
    //  It will compile to List<Object> after type ERASURE;
    // public static void testList(List<String> list) {                     //  compiler error!
    //     for (var element : list) {
    //         System.out.println("String: " + element.toUpperCase());
    //     }
    // }

    //  Because List<Integer> has no upper bound declared;
    //  It will compile to List<Object> after type ERASURE;
    // public static void testList(List<Integer> list) {                    //  compiler error!
    //     for (var element : list) {
    //         System.out.println("Integer: " + element.floatValue());
    //     }
    // }

    //  Since both methods will resolve to the same UPPER BOUND;
    //  They can't be OVERLOADED at compile time!

    //  How to handle this:
    public static void testList(List<?> list) {
        for (var element : list) {
            if (element instanceof String s) {
                System.out.println("String: " + s.toUpperCase());
            }
            if (element instanceof Integer i) {
                System.out.println("Integer: " + i.floatValue());
            }
        }
    }

}
