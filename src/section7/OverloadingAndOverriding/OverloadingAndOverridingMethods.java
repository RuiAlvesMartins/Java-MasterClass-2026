package section7.OverloadingAndOverriding;

public class OverloadingAndOverridingMethods {

    //  METHOD OVERLOADING
    //  Two or more methods share the same name but have different parameters, inside the same class;
    //  Return type may or may not be different;
    //  Access modifier may or may not be different;
    //  Checked or Unchecked Exceptions may or may not be thrown;
    //  Methods can also be overloaded by SUB classes;
    //  Also known as COMPILE-TIME POLYMORPHISM;

    //  METHOD OVERRIDING
    //  Two methods share the same signature (name and parameters) across different classes in the hierarchy;
    //  Return type has to be the same, or can be a subclass of the return type in the SUPER class (COVARIANT);
    //  Can't have a more restrictive access modifier in the SUB class;~
    //  Must not throw broader exceptions;
    //  Only INHERITED methods can be overriden, i.e., methods in SUB classes;
    //  CONSTRUCTORS, PRIVATE and FINAL methods cannot be overridden;
    //  Sub class can call a method in the super class with SUPER.methodName();
    //  @Override not required, but recommended to flag possible errors for the compiler;
    //  STATIC methods cannot be overriden;
    //  Also known as RUNTIME POLYMORPHISM or DYNAMIC METHOD DISPATCH;

}
