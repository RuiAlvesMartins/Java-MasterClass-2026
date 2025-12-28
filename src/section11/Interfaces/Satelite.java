package section11.Interfaces;

public class Satelite implements OrbitEarth {

    FlightStages stage = FlightStages.GROUNDED;

    //  Because OrbitEarth interfce extends FlightEnabled and Trackable;
    //  Satelite MUST implement all of their methods as well!
    //  Despite only implementing OrbitEarth explicitly, Satelite also implements FlightEnabled and Trackable implicitly;

    @Override
    public void takeOff() {
        transition("Lift off!");
    }

    @Override
    public void land() {
        transition("Burned up on re-entry!");
    }

    @Override
    public void fly() {
        achieveOrbit();
        transition("Data Collection while Orbiting");
    }

    @Override
    public void achieveOrbit() {
        // System.out.println("Orbit achieved!");
        transition("Orbit Achieved!");
    }

    //  OVERLOADED method
    public void transition(String description) {
        System.out.println(description);
        stage = transition(stage);
        stage.track();
    }

}
