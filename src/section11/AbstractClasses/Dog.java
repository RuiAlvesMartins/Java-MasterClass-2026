package section11.AbstractClasses;

public class Dog extends Mammal {

    //  implemented constructor
    public Dog(String type, String size, double weight) {
        super(type, size, weight);
        //TODO Auto-generated constructor stub
    }

    //  implemented method
    @Override
    public void move(String speed) {
        if (speed.equals("slow")) {
            System.out.println(getExplicitType() + " walking");
        } else {
            System.out.println(getExplicitType() + " running");
        }
    }

    //  implemented method
    @Override
    public void makeNoise() {
        if (type.equals("Wolf")) {
            System.out.print("Howling! ");
        } else {
            System.out.print("Woof! ");
        }
    }

    @Override
    public void shedHair() {
        System.out.println(getExplicitType() + " shed hair all the time");
    }

    
    
}
