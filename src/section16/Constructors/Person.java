package section16.Constructors;

public record Person(String name, String dob) {

    //  CANONICAL CONSTRUCTOR
    //          implicit;
    //          public by default;
    //          all args;
    //          initializes all fields;
    //  (in records all fields are final and must be initialized) 
    //  this constructor is inserted by the compiler when it generates the BYTE CODE or class file;
    //  although implicit, it can be made EXPLICIT, but all fields must be initialized!

    // public Person(String name, String dob) {
    //     this.name = name;
    //     this.dob = dob.replace('-', '/');
    // }



    //  CUSTOM CONSTRUCTOR
    //  overloaded constructor that calls the canonical constructor;

    //  e.g. this copy constructor:
    public Person(Person p) {
        this(p.name, p.dob);
    }


    
    //  COMPACT / SHORT CONSTRUCTOR     
    //  succinct explicit declaration of a canonical constructor;
    //  it's code is inserted into the implicit canonical constructor before any final fields are assigned;
    //  although there may be no visible args, they are implicitly there:
    //          declared with no parenthesis, no args;
    //          however, has IMPLICIT access to all args on canonical;
    //          SIGNATURE is implicitly the SAME as on canonical;
    //          cannot instantiate fields inside the code block: this happens implicitly AFTER;
    //  cannot have both a compact constructor and a explicit canonical constructor at the same time;
    //  available only on Records;

    public Person {
        //  notice that, despite having no visible arguments;
        //  it has the same signature as the canonical constructor, when called on Main.psvm();
        if (dob == null) {
            throw new IllegalArgumentException("Bad data");
        }
        //  although it is not shown here, this method is receiving args and assigning them to fields, IMPLICITLY!
        //  you can mutate the arguments:
        dob = dob.replace('-', '/');
        //  but you cannot assign them to fields:
        // this.dob = dob;                                          //  complier error!
        // the implicit field instantiation occurs at the end of the code block!
    }



    //  INSTANCE INITIALIZERS are NOT allowed in Records!
    // {
    //     this.dob = "01/01/1900";
    // }



    //  to consult JAVAP, run this on a bash terminal:
    //  javap -p "bin/section16/Constructors/Person"
    //  you can exit a bash terminal by inputing "exit"


    
}
