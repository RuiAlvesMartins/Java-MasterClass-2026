package section11.AbstractClasses;

public class Fish extends Animal {

    //  implemented constructor
    public Fish(String type, String size, double weight) {
        super(type, size, weight);
        //TODO Auto-generated constructor stub
    }

    //  implemented method
    @Override
    public void move(String speed) {
        if (speed.equals("slow")) {
            System.out.println(getExplicitType() + " lazily swimming");
        } else {
            System.out.println(getExplicitType() + " darting frantically");
        }
    }

    //  implemented method
    @Override
    public void makeNoise() {
        if (type.equals("Goldfish")) {
            System.out.print("swosh ");
        } else {
            System.out.print("swish ");
        }
    }

}
