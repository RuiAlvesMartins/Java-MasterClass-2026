package section11.AbstractClasses;



//  ABSTRACT CLASSES
//  The purpose of an abstract class is to define behaviour of subclasses, i.e. INHERITANCE;
//  They are INCONPLETE and cannot be instantiated!
//  They can have a CONSTRUCTOR though, which can be called by their subclasses;

//  Abstract classes are declared with the ABSTRACT keyword;
abstract class DemoAnimal {}
//  CONCRETE classes can extend abstract classes;
class DemoDog extends DemoAnimal {}
//  Abstract classes can be extended by other abstract classes;
abstract class DemoMammal extends DemoAnimal {}
//  Abstract classes can extend concrete classes as well;
abstract class BestOfBreed extends DemoDog {}

abstract class Animal3 {

    //  ABSTRACT METHODS
    //  They are declared with the modifier ABSTRACT;
    //  They have SIGNATURE and a RETURN TYPE, but no BODY of code!
    //  Can only be declared on an ABSTRACT CLASS or INTERFACE;
    //  Cannot be PRIVATE!
    public abstract void move();
    //  Think of them as a "contract" that subclasses have to fulfill;

}


public class AbstractClasses {
    
    //  

    public static void main(String[] args) {
        
        //  Abstract classes cannot be instantiated!
        // DemoAnimal animal = new DemoAnimal();

    }

}
