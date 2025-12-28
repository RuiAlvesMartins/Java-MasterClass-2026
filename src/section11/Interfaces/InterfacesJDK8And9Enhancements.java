package section11.Interfaces;

    //  Before JDK8, interfaces could only have public abstract methods;
    //  JDK8 introduced DEFAULT and STATIC methods;
    //  JDK9 introduced PRIVATE methods;
    //  All of these new methods are CONCRETE;

interface DemoInterface {

    //  INTERFACE EXTENSION / DEFAULT method
    //  Adding a default method doesn't break any classes currently implementing it;
    //  Unlike ABSTRACT methods, default methods don't require classes to implement them; 
    //  Default method MUST have a code block, so it is a CONCRETE method;  
    //  Like methods on a SUPERCLASS, Default methods it can be OVERRIDDEN; 

    default FlightStages demoTransition(FlightStages stage) {
        //  it is common practice to write code like this or throw an exception;
        //  to confirm that default method is not implemented;
        //  classes that actually require this method can simply override it;
        System.out.println("transition not implemented on "
            //  THIS keyword is used to refer to the instance calling the method;
            //  Despite being explicit in this example, it is actually IMPLICIT in all NON-STATIC methods inside INTERFACES;
            //  So we can omit it if we want;
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

public class InterfacesJDK8And9Enhancements {



    public static void main(String[] args) {
        
        //  Default method NOT implemented;
        inFlight(new Bird());
        System.out.println();

        //  Default method implemented;
        inFlight(new Plane());
        System.out.println();



        //  Static methods need to be called from the interface!
        OrbitEarth.log("Testing " + new Satelite());
        System.out.println();



        //  This interface method is working with PRIVATE methods internally! Check them out!
        inOrbit(new Satelite());

    }

    private static void inFlight(FlightEnabled flyer) {
        flyer.takeOff();
        flyer.demoTransition(FlightStages.LAUNCH);
        flyer.fly();
        if (flyer instanceof Trackable tracked) {
            tracked.track();
        }
        flyer.land();
    }

    private static void inOrbit(OrbitEarth orbiter) {
        orbiter.takeOff();
        orbiter.fly();
        orbiter.land();
    }

}
