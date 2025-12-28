package section11.Interfaces;

public class InterfacesVSabstractClasses {

    //  INVERFACES vs. ABSTRACT CLASSES
    //  Interfaces and Abstract Classes are very similar:
    //          Both are ABSTRACTED TYPES;
    //          Both can NOT be INSTANTIATED;
    //          Both can contain ABSTRACT and CONCRETE methods;     (Interfaces couldn't have concrete methods until the introduction of DEFAULT in JDK8)
    //          PRIVATE is forbiden on ABSTRACT methods;            (as classes need to call on them for implementation)

    //  ABSTRACT CLASSES
    //  An Abstract Class provides a common definition, as a base class, that multiple derived classes can share;
    //          Can declare INSTANCE fields;
    //          Can use all ACCESS modifiers (public, protected, private, package);
    //          Can have CONSTRUCTORS;
    //          Inherits from java.lang.Object;
    //          Only ONE Abstract Class can by EXTENDED by other classes;
    //          Abstract Classes are part of the CLASS HIERARCHY;
    //          Methods without a body of code must EXPLICITLY be declared ABSTRACT;
    //          Subclasses of an Abstract Class MUST implement all abstract methods OR be declared Abstract Class as well;
    
    //  INTERFACES
    //  The Interface decouples the "what" from the "how" and is used to make different types behave in similar ways;
    //          Can only declare CONSTANT fields (implicitly PUBLIC, STATIC and FINAL);
    //          Only PUBLIC access modifier allowed; PRIVATE allowed as of JDK9 (but not on abstract methods);
    //          MULTIPLE interfaces can by IMPLEMENTED by other classes;
    //          Interfaces can EXTEND MULTIPLE other interfaces;
    //          Interfaces are NOT part of the CLASS HIERARCHY;
    //          Can be implemented by RECORDS and ENUMS;
    //          All methods declared without a body of code are automatically PUBLIC and ABSTRACT;
    //          CONCRETE methods can be declared on interfaces as of JDK8, with the DEFAULT keyword;
    //          STATIC methods allowed as of JDK8;
    //          Best Practice: CODING TO AN INTERFACE;

    //  USE CASES of ABSTRACT CLASS
    //          Share code among closely related classes (Animal's name, age, type, etc.);
    //          You need instance fields;
    //          You need to use access modifiers prohibited by interfaces;

    //  USE CASES of INTERFACES
    //          When unrelated classes need to implement similar behaviour (e.g. flying for birds and planes);
    //          When you need to SPECIFY BEHAVIOUR, but don't care how it get's IMPLEMENTED;
    //          When you are working with RECORDS or ENUMS;

    //  Interfaces are used in many of Java's FEATURES:
    //          Collections Framework (e.g. ArrayList and LinkedList implement List interface);
    //          Lambda Expressions;
    //          Java's Database Connectivity Support (JDBC);

    public static void main(String[] args) {
        


    }

}
