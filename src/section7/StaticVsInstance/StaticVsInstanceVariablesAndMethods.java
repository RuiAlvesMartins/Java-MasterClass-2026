package section7.StaticVsInstance;

public class StaticVsInstanceVariablesAndMethods {

    //  STATIC variables;
    //  every instance of a class share the same static variables;
    //  if static variables are changed, all instances will be afacted by the change!
    //  it is best practice to use the CLASS, and not a REFERENCE, to access static variables; 
    //  keyword STATIC;

    //  INSTANCE variables;
    //  each instance has it's own copy of an instnce variable;
    //  no keyword;

    //  STATIC methods;
    //  CANNOT access instance variables nor methods directly;
    //  used for operations that don't require any data from an instance of a class;
    //  inside a static method we CAN NOT use THIS keyword;
    //  keyword STATIC;

    //  INSTANCE methods;
    //  CAN access other instance variables and methods directly;
    //  used for operations that require data from instances / objects;
    //  we can only use instance methods on already instantiated objects (after keyword NEW);
    //  no keyword;

    public static void main(String[] args) {
        
        Dog germanShepard = new Dog("German Shepard");
        Dog dachshund = new Dog("Dachshund");
        


        //  becuse static variables are shared across all instances of a class,
        //  changing one for one instance changes for all others!
        germanShepard.setGenus("Cannis");
        dachshund.setGenus("Dog");
        System.out.println(germanShepard.getGenus());       //  print "Dog";
        System.out.println(dachshund.getGenus());           //  print "Dog";

        //  it is possible to ACCESS static variables from a REFERENCE variable;
        //  but best practice is to access it from the CLASS!
        Dog.setGenus("Canis");
        System.out.println(germanShepard.getGenus());       //  print "Canis";
        System.out.println(dachshund.getGenus());           //  print "Canis";



        //  instance variables are much more simple, each instance has it's own copy;
        //  changes in one instance won't affect the others;
        System.out.println(germanShepard.getBreed());       // print "German Shepard";
        System.out.println(dachshund.getBreed());           // print "Dachshund";



        //  CONSTRUCTORS, GETTERS and SETTERS are all examples of INSTANCE METHODS!
        //  they need to access INSTANCE VARIABLES 
        Dog bulldog = new Dog("Bull Dog");
        bulldog.setBreed("Bulldog");
        bulldog.getBreed();
        bulldog.printDog();                                 // print "Bulldog is of Canis genus" 


        
        //  DEFAULT CONSTRUCTORS or GETTERS and SETTERS of STATIC VARIABLES can be STATIC METHODS!
        //  because they don't need to access data on any instance of a class;
        Dog goldenRetriever = new Dog();
        Dog.setGenus("Canis lupus familiaris");
        Dog.getGenus();
        Dog.dogBark();                                      // print "Wof!"


    }

}
