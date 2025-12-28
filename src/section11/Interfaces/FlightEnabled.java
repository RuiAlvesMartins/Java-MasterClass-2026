package section11.Interfaces;

public interface FlightEnabled {

    //  All FIELDS in an INERFACE are implicitly PUBLIC, STATIC and FINAL!
    //  Which means they are actually CONSTANTS! (hence the upperCase naming convention);
    //  (refer to ConstantsAndFinalKeyword.java for more info);
    double MILES_TO_KM = 1.60934;
    double KM_TO_MILES = 0.621371;
    //  An interface cannot be instantiated, so there is no such thing as instance fields on an interface!



    //  Interfaces can by implemented by classes of vastly different data types;
    //  FlightEnabled can by implemented by Birds, Planes, Dragonflies, DJI drones, etc.
    //  Unlike ABSTRACT CLASSES, Interfaces define BEHAVIOUR only! (with only constant fields being allowed);

    //  abstract method;
    public abstract void takeOff();

    //  abstract method declared without access modifier;
    abstract void land();

    //  abstract method with implicit abstract modifier;
    //  ABSTRACT modifier is implicitly declared for all methods in an interface!
    void fly();
    //  Any method declared without a body, is implicitly declared public and abstract!

    //  Omiting access modifier on a CLASS FIELD is implicitly PACKAGE PRIVATE;
    //  Omiting access modifier on an INTERFACE FIELD is implicitly PUBLIC;
    //  this is an important difference to remember!

    //  Only a concrete method can have private (or more restrictive) access!
    //          protected abstract void swim();         //  compiler error!



    //  We add a new method to the interface;
    //  Now, all classes that implement it are INVALID!
    //          FlightStages transition(FlightStages stage);
    //  (so we will comment this method);

    //  How can we handle this without refactoring every class?
    //  INTERFACE EXTENSION / DEFAULT method! (introduced as of JDK8);
    default FlightStages demoTransition(FlightStages stage) {
        //  it is common practice to write code like this or throw an exception;
        //  to confirm that default method is not implemented;
        //  classes that actually require this method can simply override it;
        System.out.println("transition not implemented on "
            + this.getClass().getName()
        );
        return null;
    }

    default FlightStages transition(FlightStages stage) {
        // System.out.println(this.getClass().getSimpleName() + " transitioning");
        // return FlightStages.CRUISE;
        FlightStages nextStage = stage.getNextStage();
        System.out.println("Transitioning from " + stage + " to " + nextStage);
        return nextStage;
    }

}
