package section8.Challenges.Car;

public class Car {
    
    private boolean engine;
    private int cylinders;
    private String name;
    private int wheels;



    public Car(int cylinders, String name) {
        this.engine = true;
        this.cylinders = cylinders;
        this.name = name;
        this.wheels = 4;
    }

    public String startEngine() {
        // System.out.println("flag2");
        return this.getClass().getSimpleName() + " -> startEngine()";
    }

    public String accelerate() {
        return this.getClass().getSimpleName() + " -> accelerate()";
    }

    public String brake() {
        return this.getClass().getSimpleName() + " -> brake()";
    }

    public int getCylinders() {
        return cylinders;
    }

    public String getName() {
        return name;
    }
    
}
