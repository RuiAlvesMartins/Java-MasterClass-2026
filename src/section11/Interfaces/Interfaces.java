package section11.Interfaces;

//  INTERFACES
//  Interfaces are similar to ABSTRACT CLASSES, but they are NOT a class!
//  Interfaces are a SPECIAL TYPE, a sort of "contract" between classes and client code enforced by the compiler;
//  An Interface is NEVER instantiated!
//  A class that implements an interface:
//          //  MUST implement all the abstract methods on the interface;
//          //  can be KNOWN by that TYPE;

//  Interfaces are declared with the INTERFACE keyword;
//  Name of interfaces will often end in 'able' (comparable, iterable, etc.) meaning an implementing class CAN perform a set of behaviours;
interface DemoFlightEnabled {}

//  Classes implement interfaces with IMPLEMENTS keyword;
class DemoBird implements DemoFlightEnabled {}

//  INTERFACES can EXTEND other interfaces!
//  Unlike a class, interfaces can use the EXTENDS expression on multiple other interfaces, not just one;
//  A class that implements an interface MUST also implement all other interfaces exteded by that interface!
interface DemoTrackable {}
interface DemoOrbitEarth extends DemoFlightEnabled, Trackable {}

//  Interfaces CANNOT implement other interfaces!
//      interface Demo2OrbitEarth implements DemoFlightEnabled {}

//  RECORDS can implement INTERFACES!
//  (see DragonFly.java)

//  ENUMS can implement INTERFACES!
//  (see FlightStages.java)

public class Interfaces {

    public static void main(String[] args) {
        
        //  We can use an INTERFACE as a REFERENCE TYPE;
        //  And assign it an instance of a class that implements it;
        DemoFlightEnabled flyer = new DemoBird();

    }

}
