package section11;

public class ConstantsAndFinalKeyword {

    //  FINAL Modifier
    //  Final in a FIELD means it can't be changed after initialization (i.e. immutable);
    //  Final STATIC FIELD can't be changed after class's initialization process;
    //  Final CLASS can't be OVERRIDEN! (i.e. no other class can EXTEND it);

    //  CONSTANTS
    //  A constant VARIABLE is a FINAL variable, of PRIMITIVE or STRING type, initialized with a CONSTANT EXPRESSION;
    //  Naming convention: all upper case and underscores between words (THIS_IS_A_CONSTANT_VARIABLE);

    public static void main(String[] args) {
        
        //  these 4 lines all mean the same thing in an INTERFACE;
        //  because interface's fields are CONSTANTS;
        //  all interface's fields are IMPLICITLY PUBLIC, STATIC and FINAL;
        
        //      double MILES_TO_KM = 1.60934;
        //      final double MILES_TO_KM = 1.60934;
        //      public final double MILES_TO_KM = 1.60934;
        //      public static final double MILES_TO_KM = 1.60934;

    }

}
