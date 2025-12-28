package section14.LambdaExpressions;

public class FunctionalInterfaces {

    //  FUNCTIONAL INTERFACE 
    //  implements ONLY one Abstract Method;
    //  a.k.a. SAM: Single Abstract Method;

    //  The four categories of functional interfaces (examples not exhaustive!):

    //          Execute code without returning data:
    //          CONSUMER<T>             void accept(T t)
    //          BICONSUMER<T>           void accept(T t, U u)

    //          Return a result of an operation or function:                 
    //          FUNCTION<T,R>           R apply(T t)
    //          BIFUNCTION<T,U,R>       R apply(T t, U u)
    //          UNARYOPERATOR<T>        T apply(T t)                //  UnaryOperator extends Function, where R is the same as T;
    //          BINARYOPERATOR<T>       T apply(T t1, T t2)         //  BinaryOperator extends BiFunction, where U and R are the same as T;

    //          Test if a condition is true or false:
    //          PREDICATE<T>            boolean test(T t)
    //          BIPREDICATE<T>          boolean test(T t, U u)

    //          Return an instance of something:
    //          SUPPLIER<T>             T get()



    //  For examples of coding implementation of these functional interfaces, check Main.java;

}
