package section7.Challenges.CuboidPool;

public class Cuboid extends Rectangle {

    private double height;

    public double getVolume() {
        return this.getArea() * height;
    }

    public Cuboid(double width, double length, double height) {
        super(width, length);
        this.height = height < 0 ? 0 : height;
    }

    public double getHeight() {
        return height;
    }

}
