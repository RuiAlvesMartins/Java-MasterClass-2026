package section7.ThisAndSuper;

public class ThisSuperKeywords {

    //  SUPER
    //  Access the SUPER / PARENT class;
    //  Comonly used in METHOD OVERRIDING;
    //  Will cause a compiler error if used on a STATIC method or field;
    
    //  THIS
    //  Access the current class;
    //  Comonly used in constructors and setters, when there is a conflict of variables with the same name;
    //  It's use is optional when there is no conflict;
    //  Will cause a compiler error if used on a STATIC method or field;



    //  SUPER()
    //  Used to call a constructor in the SUPER class;
    //  Can only be used in constructors, and must be the first statement;
    //  A constructor can have a call to SUPER() or THIS(), but never both;
    //  Used for constructor chaining;


    //  THIS()
    //  Used to call another constructorin the same class;
    //  Can only be used in constructors, and must be the first statement;
    //  A constructor can have a call to SUPER() or THIS(), but never both;
    //  Used for constructor chaining;

}

//  SUPER

class SuperClass {  // parent class aka super class
    public void printMethod() {
        System.out.println("Printed in SuperClass.");
    }
}

class SubClass extends SuperClass {  // subclass aka child class
    // overrides methods from the parent class
    @Override
    public void printMethod() {
        super.printMethod();  // calls the method in the SuperClass (parent)
        System.out.println("Printed in SubClass.");
    }
}

class MainClass {
    public static void main(String[] args) {
        SubClass s = new SubClass();
        s.printMethod();
    }
}

// THIS

class House {

    private String color;

    public House(String color) {
        // 'this' keyword is required because the parameter name is the same as the field
        this.color = color;
    }

    public String getColor() {
        // 'this' is optional here
        return color; // same as return this.color;
    }

    public void setColor(String color) {
        // 'this' keyword is required, same parameter name as field
        this.color = color;
    }
}
