package section8.Challenges.Polymorphism;

public class HybridCar extends Car{

    private double avgKmPerLitre;
    private int batterySize;
    private int cylinders;





    public HybridCar(String description, int maxSpeed, double avgKmPerLitre, int batterySize,
            int cylinders, boolean cruiseControl) {
        super(description, maxSpeed, cruiseControl);
        this.avgKmPerLitre = avgKmPerLitre;
        this.batterySize = batterySize;
        this.cylinders = cylinders;
    }

    public HybridCar(String description, int maxSpeed, double avgKmPerLitre, int batterySize, int cylinders) {
        this(description, maxSpeed, avgKmPerLitre, batterySize, cylinders, false);
    }

    public HybridCar(String description, int maxSpeed, boolean cruiseControl) {
        super(description, maxSpeed, cruiseControl);
    }



    public void startEngine() {     //  something the user does: turn key, press start button

        System.out.println("Hybrid Car -> Start Engine");        

    }

    protected void runEngine() {    //  something validated by car's internal functions: has battery? has gas?     
        
        System.out.println("Hybrid Car -> Engine Running"); 

    }

}
