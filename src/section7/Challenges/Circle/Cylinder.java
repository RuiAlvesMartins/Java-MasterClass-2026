package section7.Challenges.Circle;

public class Cylinder extends Circle {

    private double height;

    public double getVolume() {
        return this.getArea() * height;
    }

    public Cylinder(double radius, double height) {
        super(radius);
        this.height = height < 0 ? 0 : height;
    }

    public double getHeight() {
        return height;
    }

}
