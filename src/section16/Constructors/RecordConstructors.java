package section16.Constructors;

public class RecordConstructors {
    
    //  CANONICAL CONSTRUCTOR
    //          implicit;
    //          public by default;
    //          all args;
    //          initializes all fields;
    //  (in records all fields are final and must be initialized) 
    //  this constructor is inserted by the compiler when it generates the BYTE CODE or class file;
    //  although implicit, it can be made EXPLICIT, but all fields must be initialized!

    //  CUSTOM CONSTRUCTOR
    //  overloaded constructor that calls the canonical constructor;

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

    //  INSTANCE INITIALIZERS are NOT allowed in Records!

    public static void main(String[] args) {
        
        Person joe = new Person("Joe", "01-01-1960");
        //  the .toString() is also implicitly generated for records;
        System.out.println(joe);
        
        Person joeCopy = new Person(joe);
        System.out.println(joeCopy);

        //  to consult JAVAP, run this on a bash terminal:
        //  javap -p "bin/section16/Constructors/Person"
        //  you can exit a bash terminal by inputing "exit"

    }

}
