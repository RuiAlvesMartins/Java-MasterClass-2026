package section14.LambdaExpressions;

import java.util.ArrayList;
import java.util.List;

public class ConsumerInterface {
    
    //  CONSUMER Interface
    //  Is a FUNCTIONAL interface, i.e. only one abstract method:
    // void accept(T t)



    public static void main(String[] args) {
        
        List<String> list = new ArrayList<>(List.of(
            "alpha",
            "bravo",
            "charlie",
            "delta"
        ));

        for (String s : list) {
            System.out.println(s);
        }

        System.out.printf("%n%n%n" + "-".repeat(30) + "%n");

        //  List.forEach()
        //  allows the passage of a lambda expression, to be applied to all elements of a list;
        list.forEach((thisIsAString) -> System.out.println(thisIsAString));
        System.out.println("-".repeat(30));
        //  you may also specify the type, but it is not necessary as Java can infer it;
        list.forEach((String thisIsAString) -> System.out.println(thisIsAString));
        System.out.println("-".repeat(30));
        //  if you have only one parameter, you may omit the parenthesis in the lambda expression;
        list.forEach(thisIsAString -> System.out.println(thisIsAString));

        //  A single parameter without a type can OMIT the PARENTHESES;
        // element -> System.out.println(element);  
 
        //  Parentheses are OPTIONAL;
        // (element) -> System.out.println(element);  

        //  Parentheses REQUIRED if a reference type is specified, or if there is 0, 2 or more parameter arguments;
        // (String element) -> System.out.println(element);  

        //  A reference type can be var;
        // (var element) -> System.out.println(element);  



        //  LAMBDAS with MULTIPLE STATEMENTS
        System.out.printf("%n%n%n" + "-".repeat(30) + "%n");
        list.forEach((var myString) -> {
            //  because we are inside CURLY-BRACES, each statement must end in SEMI-COLON;
            char first = myString.charAt(0);
            System.out.println(myString + " means " + first);
        });

        //  An expression can be a SINGLE STATEMENT;
        // (element) -> System.out.println(element);
        //  Like a switch expression, that does not require yield for a single statement result; 
        //  the use of return is not needed and would resultin a compiler error!

        //  An expression can be a CODE BLOCK;
        // (var element) -> {
        //     char first = element.charAt(0);
        //     System.out.println(element + " means " + first);
        // };
        //  Like a switch expression, that requires yield, a lambda that returns a value would require a final return statement;
        //  All statements in the block must end with semi-colons;



        //  LAMBDAS and SCOPED VARIABLES

        //  Like local or abstract classes, Lambdas can access local variables from the enclosing scope:
        System.out.printf("%n%n%n" + "-".repeat(30) + "%n");
        String prefix = "nato";
        list.forEach((var myString) -> {
            char first = myString.charAt(0);
            System.out.println(prefix + " " + myString + " means " + first);
        });
        //  Keep in mind that said local variables must be final or effectively final!
        // prefix = "NATO";                                                                 //  compiler error!

        System.out.println("-".repeat(30));
        //  you may not use variables inside lambdas that conflict with local variables in the enclosing scope!
        // String myString = "nato";                                                        //  compiler error!
        list.forEach((var myString) -> {
            char first = myString.charAt(0);
            System.out.println(myString + " means " + first);
        });
        //  you also cannot access lambda's own variables from outside it's scope!
        // System.out.println(myString);                                                    //  compiler error!
    }

}
