package section12.GenericsAdvanced;

public class GenericMethods {

    //  GENERIC METHODS
    //  Allow you to specify a TYPE PARAMETER;
    //  It can be used as argument(s), as the return type, or anywhere in the code block;
    //  The type parameter is declared between the modifyers and the return type;
    public <T> void genericMethod(T input) {}
    
    //  A generic method can be used for collections with type arguments to allow for variability of the elements in the collection, without using a raw version of the collection.
    //  A generic method can be used for static methods on a generic class, because static methods can't use class type parameters.
    //  A generic method can be used on a non-generic class, to enforce type rules on a specific method.
    //  The generic method type parameter is separate from a generic class type parameter.
    //  In fact, if you've used T for both, the T declared on the method means a different type, than the T for the class.

    //  TYPE PARAMETERS in STATIC GENERIC METHODS
    //  (Consult QueryList.java and Main.java)

    public static void main(String[] args) {
        
    }

}
