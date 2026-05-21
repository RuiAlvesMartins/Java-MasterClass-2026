package section16.Mutability;

import section16.Mutability.DifferentDirectory.ChildClass;

public class Main {
    
    public static void main(String[] args) {
        
        BaseClass parent = new BaseClass();
        ChildClass child = new ChildClass();
        BaseClass childReferedToAsBase = new ChildClass();

        parent.recommendedMethod();
        System.out.println("--------------------");
        childReferedToAsBase.recommendedMethod();
        System.out.println("--------------------");
        child.recommendedMethod();



        //  HIDDING vs. OVERRIDING Methods

        //  INSTANCE METHODS are called on the runtime (INSTANCE) type;
        //  STATIC METHODS are called on the REFERENCE type;
        //  Best Practice: invoke static methods on reference type, not instance type;
        //  childReferedToAsBase will call .recommendedStatic() on BaseClass, not ChildClass! 
        System.out.println("--------------------");
        parent.recommendedStatic();
        System.out.println("--------------------");
        childReferedToAsBase.recommendedStatic();
        System.out.println("--------------------");
        child.recommendedStatic();

        //  calling a static method through an instance is not recommended;
        //  it is kept here for demonstation purposes;
        //  you should call static methods through the class type!
        System.out.println("--------------------");
        BaseClass.recommendedStatic();
        System.out.println("--------------------");
        ChildClass.recommendedStatic();



        //  FINAL LOCAL VARIABLES

        System.out.printf("%n%n%n");
        String xArgument = "This is all I've got to say about section ";
        doXYZ(xArgument, 16, null);

        //  xArgument is used as argument on .doXYZ();
        //  where it is reassigned to a different string value;
        //  nontheless, it will print the original value assigned on instantiation!
        System.out.println("After Method, xArgument: " + xArgument);
        //  Why? because it was OUT OF SCOPE!

        //  Howerver, if we try it on a StringBuilder type, it will affect it:
        System.out.println("--------------------");
        StringBuilder zArgument = new StringBuilder("Only saying this: Section ");
        doXYZ(xArgument, 16, zArgument);
        System.out.println("After Method, xArgument: " + xArgument);
        System.out.println("After Method, zArgument: " + zArgument);

    }

    private static void doXYZ(String x, int y, final StringBuilder z) {

        final String c = x + y;
        System.out.println("c = " + c);

        //  Variable c is EFFECTIVELLY FINNAL!
        // c = x;                                                   //  compiler error!

        x = c;

        if (z != null) {

            //  FINAL METHOD PARAMETERS

            //  if method parameter z is final:
            //  why does this run?
            z.append(y);  
            //  and this doesn't?
            // z = new StringBuilder("This is a new reference");    //  compiler error!

            //  declaring a method parameter final will not change whether a method has SIDE-EFFECTS ot not!
            //  it will simply produce a compiler error if you try to reassign the method parameter to a different value!

            //  in other words:
            //  a FINAL VARIABLE is NOT necessarily IMMUTABLE;
            //  it simply canot be reassigned a different value!    (after initialization)

            //  for METHOD PARAMETERS (args), they can't be assigned any values inside the method body;
            //  their value is the value passed as argument, and that's it;
            //  (method args are implicitly initialized uppon method invocation);

        }
        
    }

}
