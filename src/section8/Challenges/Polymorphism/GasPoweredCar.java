package section8.Challenges.Polymorphism;

public class GasPoweredCar extends Car {

    private double avgKmPerLitre;
    private int cylinders;



    public GasPoweredCar(String description, int maxSpeed, double avgKmPerLitre, int cylinders, boolean cruiseControl) {
        super(description, maxSpeed, cruiseControl);
        this.avgKmPerLitre = avgKmPerLitre;
        this.cylinders = cylinders;
    }

    public GasPoweredCar(String description, int maxSpeed, double avgKmPerLitre, int cylinders) {
        this(description, maxSpeed, avgKmPerLitre, cylinders, false);
    }

    public GasPoweredCar(String description, int maxSpeed, boolean cruiseControl) {
        super(description, maxSpeed, cruiseControl);
    }

    

    public GasPoweredCar(String description, int maxSpeed) {
        super(description, maxSpeed);
    }

    public void startEngine() {     //  something the user does: turn key, press start button

        System.out.println("Car -> Start Engine");        

    }

    protected void runEngine() {    //  something validated by car's internal functions: has battery? has gas?     
        
        System.out.println("Car -> Engine Running"); 

    }

}
