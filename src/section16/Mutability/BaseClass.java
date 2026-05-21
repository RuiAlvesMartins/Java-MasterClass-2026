package section16.Mutability;

public class BaseClass {
    
    // public void recommendedMethod() {

    //     System.out.println("[BaseClass.recommendedMethod]: Best Way to Do it");
    //     optionalMethod();
    //     mandatoryMethod();

    // }

    //  making .recommendedMethod() FINAL
    //  you can no longer override this method on ChildClass!
    public final void recommendedMethod() {

        System.out.println("[BaseClass.recommendedMethod]: Best Way to Do it");
        optionalMethod();
        mandatoryMethod();

    }

    protected void optionalMethod() {

        System.out.println("[BaseClass.optionalMethod]: Customize Optional Method");

    }

    //  when a method is PRIVATE, no other classes have access to it;
    //  when a method is FINAL, no subclassas may override it;
    //  in such cases, final modifier is redundant!
    private final void mandatoryMethod() {

        System.out.println("[BaseClass.mandatoryMethod]: NON-NEGOTIABLE!");

    }



    public static void recommendedStatic() {

        System.out.println("[BaseClass.recommendedStatic]: BEST Way to Do it");
        optionalStatic();
        mandatoryStatic();

    }

    // //  making .recommendedStatic() FINAL
    // //  you can no longer hide this method on ChildClass!
    // public final static void recommendedStatic() {

    //     System.out.println("[BaseClass.recommendedStatic]: BEST Way to Do it");
    //     optionalStatic();
    //     mandatoryStatic();

    // }

    protected static void optionalStatic() {

        System.out.println("[BaseClass.optionalStatic]: Optional");

    }

    private static void mandatoryStatic() {
        
        System.out.println("[BaseClass.mandatoryStatic]: MANDATORY");

    }

}
