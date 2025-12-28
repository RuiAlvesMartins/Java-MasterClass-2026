package section8.Challenges.Polymorphism;

public class Main {

    public static void main(String[] args) {
        
        Car trabi = Car.getCar("EAST GERMAN GAS", "Trabant", 89);
        // trabi.getSpeed();
// 
        // trabi.accelerate(40);
        // trabi.accelerate();
        // trabi.accelerate();
        // trabi.acceleratePedalToMetal();
// 
        // trabi.brake(44);
        // trabi.brake();
        // trabi.brake();
        // trabi.brake();
        // trabi.brakeFull();



        Car crown = Car.getCar("DIESEL", "Toyota Crown", 161, true);
        // crown.getSpeed();
// 
        // crown.accelerate(50);
        // crown.accelerate(40);
        // crown.acceleratePedalToMetal();
// 
        // crown.cruiseControl(120);
        // crown.cruiseControl(65);
        // crown.cruiseControl(88);
        // crown.brakeFull();

        Car civic = new GasPoweredCar("Honda Civic", 199, 12D, 8);
        Car insight = new HybridCar("Honda Insight", 149, 5D, 3000, 6);
        Car evPlus = new ElectricCar("Honda EV Plus", 119, 300, 9000, true);
        testDrive(civic);
        testDrive(insight);
        testDrive(evPlus);

        Car corolla = Car.getCar("GAS", "Toyota Corolla", 159);
        Car prius = Car.getCar("HYBRID", "Toyota Prius", 144);
        Car rav4Ev = Car.getCar("EV", "Toyota RAV4 EV", 169, true);
        testDrive(corolla);
        testDrive(prius);
        testDrive(rav4Ev);

    }

    public static void testDrive(Car car) {
        car.startEngine();
        car.drive();
    }

}
