package section7.Inheritance;

public class Animal {

    //  PROTECTED fields can be accessed by sub classes;
    protected String type;
    private String size;
    private double weight;

    //  explicitly declaring a constructor will disable the implicit no-args constructor;
    //  this can generate errors when extending subclasses;
    //  it can be fixed by declaring the no-args constructor explicitly on the parent class;
    //  or declaring a constructor on the child class;
    public Animal(String type, String size, double weight) {
        this.type = type;
        this.size = size;
        this.weight = weight;
    }

    public Animal() {

    }

    @Override
    public String toString() {
        return "Animal [type=" + type + ", size=" + size + ", weight=" + weight + "]";
    }

    public void move(String speed) {
        System.out.println(type + " moves " + speed);
    }

    public void makeNoise() {
        System.out.println(type + " makes some kind of noise");
    }

}
