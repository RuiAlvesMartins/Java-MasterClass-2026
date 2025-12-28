package section8.Challenges.Polymorphism;

public class ElectricCar extends Car{

    private double avgKmPerCharge;
    private int batterySize;



    public ElectricCar(String description, int maxSpeed, double avgKmPerCharge,
            int batterySize, boolean cruiseControl) {
        super(description, maxSpeed, cruiseControl);
        this.avgKmPerCharge = avgKmPerCharge;
        this.batterySize = batterySize;
    }

    public ElectricCar(String description, int maxSpeed, double avgKmPerCharge, int batterySize) {
        this(description, maxSpeed, avgKmPerCharge, batterySize, false);
    }

    public ElectricCar(String description, int maxSpeed, boolean cruiseControl) {
        super(description, maxSpeed, cruiseControl);
    }



    public void startEngine() {     //  something the user does: turn key, press start button

        System.out.println("Electric Car -> Start Engine");        

    }

    protected void runEngine() {    //  something validated by car's internal functions: has battery? has gas?     
        
        System.out.println("Electric Car -> Engine Running"); 

    }

}
