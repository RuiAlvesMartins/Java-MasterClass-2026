package section7.Inheritance;

public class Dog extends Animal {

    private String earShape;
    private String tailShape;

    public Dog(String type, double weight, String earShape, String tailShape) {
        //  super is a call to the constructor on the parent class animal;
        //  follows the same logic of this() in constructor chaining;
        super(type, 
                weight < 15 ? "small" : weight < 35 ? "medium" : "large", 
                weight);
        this.earShape = earShape;
        this.tailShape = tailShape;
    }

    public Dog(String type, double weight) {
        this(type, weight, "Perky", "Curled");
    }

    public Dog() {
        super();
    }

    //  this method is OVERRIDING a method of the same name in the parent class;
    //  this let's us implement different functionalities on subclasses, if necessary;
    @Override
    public String toString() {
        //  this super.toString() is calling the toString() on the parent class Animal;
        return "Dog [earShape=" + earShape + ", tailShape=" + tailShape + "] " + super.toString();
    }

    public void makeNoise() {

        //  subclasses can't access protected fields of super, but can access protected;
        if (type == "Wolf") {
            System.out.println("Ow Woooooooo!");
        }

        bark();
        System.out.println();
    }

    @Override
    public void move(String speed) {
        // TODO Auto-generated method stub
        super.move(speed);
        // System.out.println("Dogs walk, run and wag their tail");
        if (speed == "slow") {
            walk();
            wagTail();
        } else {
            run();
            bark();
        }
    }
    
    private void bark() {
        System.out.print("Woof! ");
    }

    private void run() {
        System.out.print("Dog Running ");
    }

    private void walk() {
        System.out.print("Dog Walking ");
    }

    private void wagTail() {
        System.out.print("Tail Wagging ");
    }



}
