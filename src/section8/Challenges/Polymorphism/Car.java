package section8.Challenges.Polymorphism;

public class Car {

    private String description;
    private boolean cruiseControl;
    private int currentSpeed;
    private int maxSpeed;



    public Car(String description, int maxSpeed, boolean cruiseControl) {
        this.description = description;
        this.cruiseControl = cruiseControl;
        this.currentSpeed = 0;
        //  maxSpeed allowed range: 20km/h to 200km/h
        this.maxSpeed = maxSpeed < 20 ? 20 : maxSpeed > 200 ? 200 : maxSpeed;
    }

    public Car(String description, int maxSpeed) {
        this(description, maxSpeed, false);
    }

    public int getSpeed() {
        System.out.println(String.format("%s's Speed -> %dkm/h", description, currentSpeed));
        return currentSpeed;
    }



    public void drive() {
        //  at least one method should print type of runtime object
        System.out.println(this.getClass().getSimpleName() + " -> Driving");
        runEngine();
    }

    public void startEngine() {     //  something the user does: turn key, press start button

        System.out.println("Car -> Start Engine");

    }

    protected void runEngine() {    //  something validated by car's internal functions: has battery? has gas?     
        
        System.out.println("Car -> Engine Running.");

    }



    private void deltaVelocity(int deltaV) {
        if (currentSpeed + deltaV < 0) {
            currentSpeed = 0;
            return;
        }
        if (currentSpeed + deltaV > maxSpeed) {
            currentSpeed = maxSpeed;
            return;
        }
        currentSpeed+=deltaV;
    }

    public int accelerate(int addedSpeed) {
        if (addedSpeed < 1) {
            return -1;
        }

        int cycles = 0;

        while (cycles < addedSpeed) {
            deltaVelocity(+1);
            cycles++;
            if (currentSpeed % 10 == 0) {
                System.out.println(String.format("Accelerating -> Speed %dkm/h", currentSpeed));
            }
            if (currentSpeed == maxSpeed) {
                break;
            }
        }

        this.getSpeed();
        return currentSpeed;

    }

    public int brake(int depletedSpeed) {
        if (depletedSpeed < 1) {
            return -1;
        }

        int cycles = 0;

        while (cycles < depletedSpeed) {
            deltaVelocity(-1);
            cycles++;
            if (currentSpeed % 10 == 0) {
                System.out.println(String.format("Breaking -> Speed %dkm/h", currentSpeed));
            }
            if (currentSpeed == 0) {
                break;
            }
        }

        this.getSpeed();
        return currentSpeed;

    }

    public int accelerate() {
        return accelerate(1);
    }

    public int brake() {
        return brake(1);
    }

    public int acceleratePedalToMetal() {
        //  this method accelerates car to it's max speed;
        while (currentSpeed < maxSpeed) {
            this.accelerate(maxSpeed - currentSpeed);
        }

        return currentSpeed;

    }

    public int brakeFull() {
        //  this method breaks car to a complete stop;
        while (currentSpeed > 0) {
            this.brake(currentSpeed);
        }

        return currentSpeed;

    }

    public int cruiseControl(int targetSpeed) {
        //  allowed input range: 0km/h to maxSpeed;
        if (targetSpeed < 0 || targetSpeed > maxSpeed) {
            return -1;
        }
        if (!cruiseControl) {
            System.out.println("This vehicle has no cruise control system installed!");
            return -1;
        }
        //  accelerating to targetSpeed;
        if (currentSpeed < targetSpeed) {
            accelerate(targetSpeed - currentSpeed);
        }
        //  breaking to targetSpeed;
        if (currentSpeed > targetSpeed) {
            brake(currentSpeed - targetSpeed);
        }

        return currentSpeed;
    }

    //  leftBlinker()
    //  rightBlinker()

    //  turnWheel(int)
    //  turnLeft()
    //  turnLeft(int)
    //  turnRight()
    //  turnRight(int)



    //  fabric method
    public static Car getCar(String type, String description, int maxSpeed, boolean cruiseControl) {

        return switch (type.toLowerCase()) {
            case "gas" -> new GasPoweredCar(description, maxSpeed, cruiseControl);
            case "hybrid" -> new HybridCar(description, maxSpeed, cruiseControl);
            case "ev" -> new ElectricCar(description, maxSpeed, cruiseControl);
            default -> new Car(description, maxSpeed, cruiseControl);
        };

    }

    //  overloaded fabric method
    public static Car getCar(String type, String description, int maxSpeed) {

        return getCar(type, description, maxSpeed, false);

    }

}
