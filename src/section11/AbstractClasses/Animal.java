package section11.AbstractClasses;

//  An abstract class can be extended by another abstract class!
abstract class Mammal extends Animal {

    //  An abstract class that extends another abstract class;
    //          //  can implement all of the parent's abstract methods;
    //          //  but it is not forced to implement them all;
    //          //  it may even implement none;
    //          //  it can declare new abstract methods of it's own;    

    //  implemented constructor
    public Mammal(String type, String size, double weight) {
        super(type, size, weight);
    }

    //  this is a CONCRETE method;
    //  subclasses extending Mammal will not be forced to declare a .move(String);
    //  because it already has working code here!
    @Override
    public void move(String speed) {
        System.out.print(getExplicitType() + " ");
        System.out.println(speed.equals("slow") ? "walks" : "runs");
    }

    public abstract void shedHair();

}




public abstract class Animal {
    
    //  An abstract class can have inherited FIELDS, just like a concrete class;
    protected String type;
    private String size;
    private double weight;

    //  Constructor;
    public Animal(String type, String size, double weight) {
        this.type = type;
        this.size = size;
        this.weight = weight;
    }

    //  you can't have PRIVATE abstract methods!
    // private abstract void move(String speed);
    public abstract void move(String speed);

    public abstract void makeNoise();

    //  an abstract class can also have CONCRETE methods!
    //  FINAL means this method cannot be overriden by the subclasses;
    public final String getExplicitType() {
        return getClass().getSimpleName() + " (" + type + ")";
    }

}
