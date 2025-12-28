package section11;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import section11.Interfaces.Bird;
import section11.Interfaces.Animal;
import section11.Interfaces.FlightEnabled;
import section11.Interfaces.Trackable;

public class AbstractedReferenceTypes {

    //  ABSTRACTED REFFERENCE TYPES
    //  Both INTERFACES and ABSTRACT CLASSES are Abstracted Reference Types;
    //  When you use an abstract reference type, you are CODING TO AN INTERFACE;

    //  CODING TO AN INTERFACE means you are using GENERALIZED reference types (such as abstract class or interface) instead of SPECIFIC ones;
    //  This technique is preferred:
    //          Allows many runtime instances of various classes to be processed uniformly by the same code;
    //          Allows for substitutions of a class or object that implements the same interface without (major) code refactoring;
    //          It is considered a BEST PRACTICE;

    public static void main(String[] args) {

        Bird bird = new Bird();
        Animal animal = bird;
        FlightEnabled flyer = bird;
        Trackable tracked = bird;



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
