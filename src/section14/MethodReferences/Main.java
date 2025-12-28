package section14.MethodReferences;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

class PlainOld {

    private static int LAST_ID = 1;

    private int id;

    public PlainOld() {
        id = PlainOld.LAST_ID++;
        System.out.println("Creating a PlainOld Object: id = " + id);
    }

}

public class Main {
    
    public static void main(String[] args) {
        
        //  METHOD REFERENCES
        //  Method References ABSTRACT Lambda Expressions further;
        //  By eliminating the need to declare formal parameters;
        //  There's also no need to pass arguments to the method in question;
        //  DOUBLE COLONS (::) between Qualifying Type and Method Name; 

        List<String> list = new ArrayList<>(List.of(
            "Anna", "Bob", "Chuck", "Dave"
        ));

        //  In this example of Consumer Interface, not only is the method infered, but the parameters are as well;
        //  This Lambda Expression can be REPLACED;
        list.forEach(s -> System.out.println(s));
        //  With a METHOD REFERENCE:
        list.forEach(System.out::println);
        //  This is a method reference for an INSTANCE method (BOUNDED Receiver);



        //  NOT ALL methods can be used as method references in Java;
        //  It all depends on the context of the Lambda Expression they are replacing;
        //  You can reference:
        //          a STATIC method on a class;
        //          an INSTANCE method from an instance passed as ARGUMENT;
        //                  this instance may be known as UNBOUNDED REFEIVER;
        //          an INSTANCE method from an instance EXTERNAL to the lambda expression;
        //                  this instance is declared in the enclosing code;
        //                  this instance may be known as BOUNDED RECEIVER;
        //          a CONSTRUCTOR method;



        //  METHOD REFERENCES for STATIC Methods
        calculator((a, b) -> a + b, 10, 25);
        //  Static method on a class on the right;
        //  Class type as reference on the left;
        calculator(Integer::sum, 10, 25);
        //  This is a method reference for a STATIC method;

        //  A TYPE REFERENCE refers to a class, interface, enum or record's name;
        //  STATIC methods are normally called using Type References, but they may also be called by instances;

        //  This is NOT TRUE for METHOD REFERENCES;
        //  In Method References and Lambda Expressions, Static Methods can ONLY be invoked from Type References!

        calculator((a, b) -> a + b, 2.5, 7.5);
        calculator(Double::sum, 2.5, 7.5);

        


        //  METHOD REFERENCES for CONSTRUCTOR Methods
        Supplier<PlainOld> reference1 = () -> new PlainOld();
        Supplier<PlainOld> reference2 = PlainOld::new;
        //  This is a method reference for a CONSTRUCTOR method;
        //  Uppon running this code, the S.out on PlainOld() is not printed on the terminal;
        //  Why?

        //  DEFERED METHOD INVOCATION
        //  When creating variable/references assigned to Lamda Expressions or Method References;
        //  The code is NOT INVOKED on DECLARATION;
        //  The code is invoked when targeted functional method is called;
        //  Example:
        PlainOld newPojo = reference2.get();

        //  Why not simply instantiate an object directly (PlainOld newPojo = new PlainOld()), why the extra work?
        //  In cases of instantiating multiple objects (SEEDING), method references on constructors are usefull;
        System.out.println("Getting array");
        PlainOld[] pojo1 = seedArray(PlainOld::new, 10);



        //  METHOD REFERENCES for INSTANCE Methods (UNBOUNDED Receiver)
        calculator((s1, s2) -> s1 + s2, "Hello ", "World");
        calculator((s1, s2) -> s1.concat(s2), "Hello ", "World");
        calculator(String::concat, "Hello ", "World");
        //  This is a method reference for an INSTANCE method (UNBOUNDED Receiver);

        //  DO NOT CONFUSE!
        //  Static Methods VS. Instance Unbounded Receiver

        //  In the previous example, concat() is not a static method of String;
        //  but we are apparently calling it from the type reference (which is forbidden!);
        //  However, there is no compiler error;

        //  String in that case is not a type reference, but a type argument for an Unbounded Receiver;
        //  It is passing a type as argument, not using a type reference to call a static method!
        
        //  Recall that calculator() needs a type implementing BinaryOperator<T> as argument;
        BinaryOperator<String> b1 = (s1, s2) -> s1.concat(s2);
        //  BinaryOperator needs only one Type Parameter <T>;
        //  The apply(T, T) on BinaryOperator<T> needs two arguments of type T, and returns a type T;
        BinaryOperator<String> b2 = String::concat;
        //  So, (String::concat) respects the method signature:
        //          one type parameter (String) is passed as argument;
        //          concat() returns a type that is the same as the argument (String);
        //  We are basically omiting the formality of passing the arguments, but they are still being passed implicitly;
        //          concat() will be called from the FIRST argument;
        //          while the SECOND argument gets passed as argument in concat();
        System.out.println(b2.apply("Hello ", "World"));

        //  This will also work in Functional Interfaces with multiple Type Parameters;
        //  As long as they are all of the same type!
        BiFunction<String, String, String> b3 = (s1, s2) -> s1.concat(s2);
        BiFunction<String, String, String> b4 = String::concat;
        System.out.println(b4.apply("Hello ", "World"));

        //  CONTEXT MATTERS!
        //  We cannot pass a double argument method to a single argument Functional Interface:
        // UnaryOperator<String> u1 = (s1, s2) -> s1.concat(s2);                //  compiler error!
        // UnaryOperator<String> u2 = String::concat;                           //  compiler error!
        //  apply(T) on UnaryOperator requires one parameter <T> as argument, and returns a T;
        //  concat needs two parameters: one is the instance it is called from; the other is the argument for the method itself;

        //  However, if we pass a single argument method, there is no compiler error:
        UnaryOperator<String> u3 = (s) -> s.toUpperCase();
        UnaryOperator<String> u4 = String::toUpperCase;
        System.out.println(u4.apply("Hello"));



        String result = "Hello".transform(u4);
        System.out.println("Result = " + result);
        //  OUTPUT:  Result = HELLO

        result = result.transform(String::toLowerCase);
        System.out.println("Result = " + result);
        //  OUTPUT:  Result = hello

        Function<String, Boolean> f0 = String::isEmpty;
        boolean resultBoolean = result.transform(f0);
        System.out.println("Result = " + resultBoolean); 
        //  OUTPUT:  Result = false       

    }

    private static <T> void calculator(BinaryOperator<T> function, T value1, T value2) {

        T result = function.apply(value1, value2);
        System.out.println("Result of Operation: " + result);

    }

    private static PlainOld[] seedArray(Supplier<PlainOld> reference, int count) {
        PlainOld[] array = new PlainOld[count];
        Arrays.setAll(array, i -> reference.get());
        return array;
    }

}
