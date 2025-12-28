package section11.Interfaces;

//  You can extend ABSTRACT CLASSES and implement INTERFACES at the same time!
//  INHERITANCE only allows the extention of ONE class, so you can only extend one Abstract Class!
//  NO such LIMIT exists for INTERFACES, multiple interfaces can be implemented by the same class!
public class Bird extends Animal implements FlightEnabled, Trackable {

    @Override
    public void move() {
        System.out.println("Flaps wings");
    }

    @Override
    public void track() {
        System.out.println(getClass().getSimpleName() + "'s coordinates recorded");
    }

    @Override
    public void takeOff() {
        System.out.println(getClass().getSimpleName() + " is taking off");
    }

    @Override
    public void land() {
        System.out.println(getClass().getSimpleName() + " is landing");
    }

    @Override
    public void fly() {
        System.out.println(getClass().getSimpleName() + " is flying");
    }

}
