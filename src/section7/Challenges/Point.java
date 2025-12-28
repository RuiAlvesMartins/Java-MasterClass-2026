package section7.Challenges;

public class Point {

    private int x;
    private int y;

    public static void main(String[] args) {
        
        Point p1 = new Point(6, 5);
        Point p2 = new Point(3, 1);
        Point p3 = new Point();

        System.out.println(p1.distance());
        System.out.println(p1.distance(p2));
        System.out.println(p1.distance(2, 2));
        System.out.println(p3.distance());

    }

    public double distance(int x, int y) {

        int xA = this.x;
        int yA = this.y;
        int xB = x;
        int yB = y;

        double distance = Math.sqrt((xB - xA) * (xB - xA) + (yB - yA) * (yB - yA));

        return distance;

    }

    public double distance(Point p) {
        return distance(p.getX(), p.getY());
    }

    public double distance() {
        return distance(0, 0);
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public Point() {
    }

    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
}
