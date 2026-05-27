package section16.Constructors.Initializers;

public class Main {
    
    // initializing final fields
    // initializers, static and instance
    // record and enum constructors

    public static void main(String[] args) {
        
        //  You don't have to create a constructor to instantiate a class;
        //  By default, there's an IMPLICIT NO ARGs constructor;
        //  But ONLY when no other constructors are declared!
        // Parent parent = new Parent();
        // Child child = new Child();
        //  once a constructor is declared (except if it is a no agrs one);
        //  this code will not compile!
        //  declaring a constructor "inactivates" the implicit no args constructor;
        //  declaring a no args constructor, makes it explicit;

        //  intitializer code has been commented;
        //  no args explicit constructor commented;
        //  instantiation through all args constructor:
        Parent parent = new Parent("John Doe", "01/01/1960", 3);
        Child child = new Child("Jane Doe", "01/01/1990", 1);

        System.out.println("Parent: "+parent);
        System.out.println("Child: "+child);

    }

}
