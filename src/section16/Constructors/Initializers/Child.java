package section16.Constructors.Initializers;

import java.util.Random;

public class Child extends Parent {
    
    //  with a constructor declared on parent class;
    //  implicit all args constructor on child class is inactive!



    private final int birthOrder = getBirthOrder();
    private final String birthOrderString;



    {
        //  NOTE: instance initializer block is run after birthOrder is initializer;
        //  ANY assignments or initializations that occur BEFORE the initialization block;
        //  are RUN BEFORE the initialization block!
        //  (otherwise this code would not compile)
        if (siblings == 0) {birthOrderString = "Only";}
        else if (birthOrder == 1) {birthOrderString = "First";}
        else if (birthOrder == siblings + 1) {birthOrderString = "Last";}
        else {birthOrderString = "Middle";}
        System.out.println("In Child Initializer, birthOrder=%s, birthOrderString=%s".formatted(birthOrder, birthOrderString));
    }



    public Child(String name, String dob, int siblings) {
        super(name, dob, siblings);
        System.out.println("In Child Constructor");
    }

    private final int getBirthOrder() {
        if (siblings == 0) {return 1;}
        return new Random().nextInt(1, siblings + 2);
    }



    @Override
    public String toString() {
        return super.toString() + ", " + birthOrderString + " child";
    }

}
