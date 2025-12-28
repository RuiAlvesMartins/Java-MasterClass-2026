package section11.Interfaces;

//  RECORDS can implement INTERFACES!
record DragonFly(String name, String type) implements FlightEnabled {

    //  Records usually don't have a dody of code;
    //  But because DragonFly implements interfaces, their methods must be implemented;

    @Override
    public void takeOff() {

    }

    @Override
    public void land() {

    }

    @Override
    public void fly() {

    }

}
