package section11.Interfaces;

//  ENUMS can implement INTERFACES!
public enum FlightStages implements Trackable {
    GROUNDED, LAUNCH, CRUISE, DATA_COLLECTION;

    //  Enums usually don't have a block of code;
    //  But because FlightStages implements interfaces, their methods must be implemented;

    @Override
    public void track() {
        if (this != GROUNDED) {
            System.out.println("Monitoring " + this);
        }
    }

    public FlightStages getNextStage() {
        //  packing all elements of enum into an array;
        FlightStages[] allStages = values();
        //  ordinal() returns the index of the enum constant in the order it was declared (starting at zero);
        //  this will return the next enum constant by order of declaration;
        //  when it reaches the last constant, remainder (%) will return zero, and method will return first position of array, the first constant, restarting the cycle;
        //  this method will still work even if we rearrange the constants in the future;
        return allStages[(ordinal() + 1) % allStages.length];
    }

}
