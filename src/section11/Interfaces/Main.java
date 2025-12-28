package section11.Interfaces;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    
    public static void main(String[] args) {
        
        //  We can crate an instance of a class;
        //  And then assign that instance to references of the Interface/Abstract Class data types;
        Bird bird = new Bird();
        //  reference of abstract class;
        Animal animal = bird;
        //  references of interfaces;
        FlightEnabled flyer = bird;
        Trackable tracked = bird;

        

        //  call to abstract method;
        //  only the class and abstract class references allow the calling of this method;
        bird.move();
        animal.move();
        //  interface references do not allow the calling of this method;
        //  even if the assigned instance has it implemented!
        //  because the said abstract method is not declared in any of these interfaces;
        //  The VARIABLE/REFERENCE declared data TYPE DETERMINES which methods can be used!
        //      flyer.move();           //  compiler error!
        //      tracked.move();         //  compiler error!

        //  Interface references can call their respective methods;
        flyer.takeOff();
        flyer.fly();
        tracked.track();
        flyer.land();

        //  But cannot call methods present in other interfaces!
        //      flyer.track();          //  compiler error!
        //      tracked.takeOff();      //  compiler error!
        //      tracked.fly();          //  compiler error!
        //      tracked.land();         //  compiler error!

        //  Similarly, abstract class references cannot call interface methods;
        //  Just as interface references cannot call abstract class methods;
        //      animal.takeOff();       //  compiler error!
        //      animal.fly();           //  compiler error!
        //      animal.track();         //  compiler error!
        //      animal.land();          //  compiler error!

        //  The CONCRETE class reference can call all methods!
        bird.move();
        bird.takeOff();
        bird.fly();
        bird.track();
        bird.land();

        System.out.println();
        System.out.println();
        System.out.println();

        inFlight(flyer);
        inFlight(new Plane());
        //  Truck doesn't implement FlightEnabled, so it cannot be passed as argument!
        //      inFlight(new Truck());  //  compiler error!
        
        Trackable truck = new Truck();
        truck.track();

        double kmsTraveled = 100;
        double milesTraveled = kmsTraveled * FlightEnabled.KM_TO_MILES;
        System.out.printf("The truck traveled %.0fkm or %.2f miles%n", kmsTraveled, milesTraveled);

        System.out.println();
        System.out.println();
        System.out.println();



        //  ABSTRACTED REFFERENCE TYPES
        //  Both INTERFACES and ABSTRACT CLASSES are Abstracted Reference Types;
        //  When you use an abstract reference type, you are CODING TO AN INTERFACE;

        //  CODING TO AN INTERFACE means you are using GENERALIZED reference types (such as abstract class or interface) instead of SPECIFIC ones;
        //  This technique is preferred:
        //          Allows many runtime instances of various classes to be processed uniformly by the same code;
        //          Allows for substitutions of a class or object that implements the same interface without (major) code refactoring;
        //          It is considered a BEST PRACTICE;
        
        ArrayList<FlightEnabled> flyers = new ArrayList<>();
        flyers.add(bird);
        
        takeOffFlyers(flyers);
        flyFlyers(flyers);
        landFlyers(flyers);

        //  ArrayList implements List;
        //  So we can use List in the declaration and ArrayList in the instantiation;
        List<FlightEnabled> betterFliers = new ArrayList<>();
        betterFliers.add(bird);

        //  We are changing the data type from ArrayList to LinkedList!
        //  Still works!
        //  Why? Because both extend the List interface;
        //  The variable betterFliers has already been declared as a List<FlightEnabled>;
        //  The needed argument for the three methods is of List type: any type extending List will be valid!
        betterFliers = new LinkedList<>();
        betterFliers.add(bird);

        takeOffFlyers(betterFliers);
        flyFlyers(betterFliers);
        landFlyers(betterFliers);

    }

    //  this method is prepared to receive an object of FlightEnabled type as argument;
    //  any object that implements FlightEnabled can be passed as argument!
    private static void inFlight(FlightEnabled flyer) {
        flyer.takeOff();
        flyer.fly();
        //  this if checks if the argument also implements Trackable;
        if (flyer instanceof Trackable tracked) {
            tracked.track();
        }
        flyer.land();
    }

    private static void flyFlyers(List<FlightEnabled> flyers) {
        for (var flyer : flyers) {
            flyer.fly();
        }
    }
    private static void takeOffFlyers(List<FlightEnabled> flyers) {
        for (var flyer : flyers) {
            flyer.takeOff();
        }
    }
    private static void landFlyers(List<FlightEnabled> flyers) {
        for (var flyer : flyers) {
            flyer.land();
        }
    }

}
