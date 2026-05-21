package section16.Mutability.DifferentDirectory;

import section16.Mutability.BaseClass;

public class ChildClass extends BaseClass {

    @Override
    protected void optionalMethod() {
        System.out.println("[Child.optionalMethod]: EXTRA Stuff happened here");
        super.optionalMethod();
    }

    // @Override
    // public void recommendedMethod() {
    //     //  overriding the recommendedMethod() means the mandatoryMethod() on BaseClass is never run!
    //     //  and because it is private, it cannot be invoked by subclasses!
    //     System.out.println("[Child.recommendedMethod]: I'll do things my way");
    //     optionalMethod();
    // }

    //  this method is NOT being OVERRIDEN!
    //  mandatoryMethod() on BaseClass is private: 
    //  like final, private methods cannot be overriden!
    private void mandatoryMethod() {

        System.out.println("[Child.mandatoryMethod]: My own important stuff");

    }



    //  HIDDING vs. OVERRIDING Methods

    //  .recommendedStatic() also exists on BaseClass, with same signature;
    //  but .recommendedStatic() on ChildClass is not overriding it;
    //  i.e. it is NOT REPLACING the parent method POLYMORPHICALLY!

    //  Which of these two methods will be called? Depends on the REFERENCE type, not instance type:
    //          INSTANCE METHODS are called on the runtime (INSTANCE) type;
    //          STATIC METHODS are called on the REFERENCE type;
    //  Best Practice: invoke static methods on reference type, not instance type;

    //  This is called HIDDING a method;
    //  It conceals the parent method on the parent class,
    //  when accessing that signature through the child class reference;
    //  STATIC methods can ONLY be HIDDEN, not overridden!
    //  If the static method is also FINAL, it can NOT be hidden!

    // @Override                                                    //  compiler error!
    //  Override annotation is not allowed on static methods!
    public static void recommendedStatic() {

        System.out.println("[ChildClass.recommendedStatic]: Another way of doing it");
        optionalStatic();
        // mandatoryStatic();

    }




}
