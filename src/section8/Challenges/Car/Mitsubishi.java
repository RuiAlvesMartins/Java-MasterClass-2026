package section8.Challenges.Car;

public class Mitsubishi extends Car {

    public Mitsubishi(int cylinders, String name) {
        super(cylinders, name);
    }
    
    public String startEngine() {
        // System.out.println("flag1");
        return super.startEngine();
        
    }

    public String accelerate() {
        return super.accelerate();
    }

    public String brake() {
        return super.brake();
    }

}
