package section16.Constructors.Initializers;

public class Parent {
    
    //  making the fields final:
    //          invalidates setters;
    //          forces initialization of fields;
    private final String name;
    private final String dob;
    protected final int siblings;



    //  this is a STATIC INITIALIZER
    //          executed when the class is referenced/constructed, not initialized!
    //          can be declared anywhere in the source code;
    //          multiple blocks of code are executed in the order they are declared;
    //  helpful for setting up environment variables or log information;
    static {
        System.out.println("In Parent Static Initializer: class is being constructed");
    }



    //  fields are usually initialized in a Constructor;
    //  however, they may also be initialized like this:
    {
        // name = "John Doe";
        // dob = "01/01/1960";
        // siblings = 0;
        System.out.println("In Parent Initializer");
    }
    //  this is an INSTANCE INITIALIZER:
    //          is a block of code declared directly in class body;
    //          executed when an INSTANCE of a class is INITIALIZED;
    //          executed BEFORE CONSTRUCTORS!    
    //          multiple blocks of code are executed in the order they are declared;
    //          assignemnts/initializations declared before the code block are run before the code block (see Child.java);



    public Parent(String name, String dob, int siblings) {
        //  because fields are final;
        //  and were already initialized on the instance initializer;
        //  they now cannot be initialized on the constructor!
        this.name = name;
        this.dob = dob;
        this.siblings = siblings;
        System.out.println("In Parent Constructor");
    }

    // public Parent() {
    //     System.out.println("In Parent No-Args Constructor");
    // }



    // public void setName(String name) {
    //     this.name = name;
    // }
    // public void setDob(String dob) {
    //     this.dob = dob;
    // }
    
    public String getName() {
        return name;
    }
    public String getDob() {
        return dob;
    }

    @Override
    public String toString() {
        return "name='"+name+'\''+", dob='"+dob+'\''+", siblings='"+siblings+'\'';
    }

    

}
