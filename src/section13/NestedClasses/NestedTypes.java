package section13.NestedClasses;

public class NestedTypes {
    
    //  NESTED TYPES
    //  Both FIELDS and METHODS inside a class are MEMBERS;
    //  Within it's body, a class may contain other MEMBERS such as other CLASSES, INTERFACES, ENUMS and RECORDS;
    //  These are all NESTED TYPES;

    //  NESTED CLASSES
    //                STATIC NESTED CLASS
    //                    declared in class body;
    //                    access through outer class name identifier (like a static method);
    //                INNER CLASS
    //                    declared in class body;
    //                    access through an instance of the outer class;
    //                LOCAL CLASS
    //                    declared in a code block, usually a method body;
    //                    no access modifiers, only accessible in that code block while executing  
    //                ANONYMOUS CLASS
    //                    a local unnamed class;
    //                    declared and instantiated in same statement;

    //  As of JDK16, all four types of NESTED CLASSES may have STATIC members of any type (fields, methods, etc.);
    //  Before JDK16 only Static Nested Classes were allowed to have Static Methods;
    //  Nested INTERFACES, ENUMS and RECORDS are all implicitly STATIC;

    //  STATIC NESTED CLASS
    //  Is a NESTED TYPE;
    //  Is a NESTED CLASS;
    //  Is ENCLOSED on the structure of another class;
    //  Declared as STATIC inside the outer class code block;
    //  Access through outer class name identifier (like a static method);
    //  Can access all members of outer class (including private ones);
    //  Outer class can access all members of the inner class (including private ones);
    //  Are INHERITED by SubClasses;

    //  INNER CLASS
    //  Is a NESTED TYPE;
    //  Is a NESTED CLASS;
    //  Is ENCLOSED on the structure of another class;
    //  It is NOT STATIC;
    //  Access through an instance of outer class name;
    //  Can access all members of outer class (including private ones);
    //  Outer class can access all members of the inner class (including private ones);

    //  LOCAL CLASS
    //  Is a NESTED TYPE;
    //  Is a NESTED CLASS;
    //  Is ENCLOSED on code block, usually a method body;
    //  NO ACCESS MODIFIERS, can only be accessed when the enclosing code block is being executed;
    //  Can access all members of outer class (including private ones);
    //  Outer class can access all members of the inner class (including private ones);
    //  To avoid unexpected behaviour, fields in local classes must be FINAL or effectively final (don't change after being declared);
    //  As of JDK16, you can declare RECORD, INTERFACE and ENUM as a STATIC NESTED TYPE;

    //  ANONYMOUS CLASS
    //  LOCAL CLASS
    //  Is a NESTED TYPE;
    //  Is a NESTED CLASS;
    //  It is a LOCAL UNNAMED class;
    //  It is never created with a class declaration;
    //  It is always INSTANTIATED as part of an EXPRESSION:
    // var e1 = new Employee() {};        //  where the anonymous class will be a SubType of Employee;
    //  Infrequent use after the introduction of LAMBDAS as of JDK8;
    //  NO ACCESS MODIFIERS;

}
