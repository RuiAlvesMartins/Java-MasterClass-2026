package section11.Interfaces;



//  INTERFACES can EXTEND other interfaces!
//  Unlike a class, interfaces can use the EXTENDS expression on multiple other interfaces, not just one;
//  A class that implements OrbitEarth MUST also implement all other interfaces exteded by this interface;
public interface OrbitEarth extends FlightEnabled {

    void achieveOrbit();

    //  see more on STATIC methods in InterfacesJDK8And9Enhancements.java
    static void log(String description) {
        var today = new java.util.Date();
        System.out.println(today + ": " + description);
    }

    //  see more on PRIVATE methods in InterfacesJDK8And9Enhancements.java
    private void logStage(FlightStages stage, String description) {
        description = stage + ": " + description;
        log(description);
    }

    @Override
    default FlightStages transition(FlightStages stage) {
        FlightStages nextStage = FlightEnabled.super.transition(stage);
        logStage(stage, "Begining transition to " + nextStage);
        return nextStage;
    }

}
