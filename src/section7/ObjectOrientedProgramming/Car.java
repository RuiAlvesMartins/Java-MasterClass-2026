package section7.ObjectOrientedProgramming;

public class Car {

    //  OBJECT ORIENTED PROGRAMMING
    //  __________________________________________________  //

    //  CLASSES are blueprints for objects;
    //  OBJECTS are instantiated members of a class;
    //  PACKAGES are classes grouped into folders;

    //  TOP LEVEL CLASS

    //  ACCESS MODIFIERS (public, protected, omited, private);
    //  ENCAPSULATION

    //  FIELDS belong to a class;
    //  LOCAL VARIABLES are local to a method;
    //  ATTRIBUTES refer to the state of an object;

    //  GETTERS and SETTERS control access to private fields;
    //  GETTERS get the value of the field to a different class;
    //  SETTERS allow a different class to set the value of the field;

    //  __________________________________________________  //


    //  This CLASS is called CAR

    //  These are it's FIELDS
    private String make;
    private String model;
    private String color;
    private int doors;
    private boolean convertible;

    //  These are it's METHODS

    public void describeCar() {

        System.out.println(doors + "-Door " +
                color + " " +
                make + " " +
                model + " " +
                (convertible ? "Convertible" : "")
        );

    }

    //  These are it's GETTERS and SETTERS
    //  THIS is keyword that refers to a specific instnce (object) of a class

    public String getMake() {
        return make;
    }

    //  One of the dvantages of SETTERS is that they allow input validation
    public void setMake(String make) {
        if (make == null) {make = "Unknown";}
        String lowerCaseMake = make.toLowerCase();
        switch (lowerCaseMake) {
            case "lada", "porshe", "tesla" -> this.make = make;
            default -> {
                this.make = "Unsupported";
            }
        }
    }

    //  These are it's CONSTRUCTORS

    //  Their purpose is to initialize the object being instantiated/created;
    //  They have same NAME as the class and RETURN NOTHING; 
    //  Keyword VOID is ommited in the signature;
    //  An apropriate access modifier should be chosen;

    public Car(String make, String model, String color, int doors, boolean isConvertible) {
        // System.out.println("Car constructor with parameters called");

        //  if you have validation code on the SETTERS, you can call them on the constructors to do validation;
        //  keep in mind that if validation fails, the fields will not be initialized, so this might not be usefull in all situations;
        setMake(make);
        this.model = model;
        this.color = color;
        this.doors = doors;
        //  if variable names are not the same, you can dispense with using THIS
        convertible = isConvertible;
    }

    //  CONSTRUCTOR OVERLOAD
    //  It's declraring multiple constructors with same signature but different parameters;
    //  If number of parameters is the same, their types or order must be different;
    //  Same as method overloading;

    public Car(String make, String model, String color, int doors) {
        //  CONSTRUCTOR CHAINING
        //  When one constructor explicitly calls another overloaded constructor;
        //  Needs to be the FIRST line executed in the constructor;
        //  Uses the keyword THIS;
        this(make, model, color, doors, false);
    }

    //  DEFAULT CONSTRUCTOR
    //  If no constructor is declared in code, a defult constructor is implicitly declared;
    //  If a constructor is declared, a defult constructor is NOT implicitly declared;
    //  Also known as NO-ARGS CONSTRUCTOR;

    public Car() {
        this("Unsuported", "null", "null", 0, false);

        // System.out.println("Empty constructor called");
    }





    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getDoors() {
        return doors;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }

    public boolean isConvertible() {
        return convertible;
    }

    public void setConvertible(boolean convertible) {
        this.convertible = convertible;
    }

}
