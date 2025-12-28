package section12.GenericClasses;

record RecordDemo() {}
interface InterfaceDemo {}



    //  GENERICS
    //  Generics enable us to create and design classes in a generalized manner;
    //  The specifics of the contained elements should be of no concern;
    //  Example: ARRAYLIST<> can hold any type of object;
    //  There are several generic types:
    //          Generic CLASSES;
    //          Generic RECORDS;
    //          Generic INTERFACES;
    //          Generic METHODS;



    //  DECLARING a class
    //  regular class;
    class ITellYou {
        private String field;
    }
    //  generic class;
    class YouTellMe<T> {
        //  <T> is a TYPE PARAMETER IDENTIFIER;
        //  It can be any other letter or word, as long as is inside <>;
        //  privte field can be of whatever type passes for <T>;
        private T field;

    }

    //  You can have more than one (MULTIPLE) TYPE PARAMETERS!
    class Team1<T1, T2, T3> {}
    //  NAMING CONVENTION says to stick to these single letters, in this order;
    class Team2<T, S, U> {}

    //  A few letters are reserved for special use cases:
    //      E for ELEMENT (inside Lists or other Collections);
    //      K for KEY (used in Mapped types);
    //      N for NUMBER;
    //      T for TYPE;
    //      V for VALUE;
    //      S, U, V, etc. for 2nd, 3rd, 4th TYPES;

    //  You can FORCE the Type Parameter to implement an interface!
    //  But instead of implements, you use the keyword EXTENDS instead!
    //  This is known as establishing an UPPER BOUND;
    class Team3<T extends InterfaceDemo> {}

public class Generics {

    public static void main(String[] args) {
        
        //  RAW TYPE
        //  Whenever you reference or instantiate a generic class without specifying the type!
        //  Raw use of the reference type is allowed for backwards compatability;
        //  However, it is a BAD PRACTICE, and discouraged for several reasons;
        YouTellMe youTellMe1 = new YouTellMe();

        //  Type parameter specified, no raw type warning;
        YouTellMe<RecordDemo> youTellMe2 = new YouTellMe<>();

        //  PRIMITIVES
        //  Can NOT be passed as parameter types!
        // YouTellMe<int> youTellMe3 = new YouTellMe<>();                           //  compiler error!
        YouTellMe<Integer> youTellMe3 = new YouTellMe<>();

        //  Type Parameter OUT OF BOUNDS
        //  String is not implementing InterfaceDemo
        //  <T extends InterfaceDemo> establishes an UPPER BOUND on the types that are allowed to be passed;
        //  Only subtypes of InterfaceDemo (be them classes, abstract classes, interfaces, etc.) are valid;
        //  Why establish an Upper Bound? Beacuse:
        //              Limit types that can be passed as parameters;
        //              Ensure functionality of parameters;
        // Team3<String> team3 = new Team3<>();                                     //  compiler error!

    }

}
