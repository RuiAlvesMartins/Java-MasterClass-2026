package section14.LambdaExpressions;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LambdaExpressions {
    
    //  LAMBDAS
    //  Lambda Expressions can be thought of an Anonymous Class that implement a Single Abstract Method (a.k.a. FUNCTIONAL INTERFACE);
    //  They are usefull for passing an entire code block as an argument/parameter;
    //  Example: passing a different .compare() method as an argument;

    //  SYNTAX of Lambda Expressions:
    //  (parameter 1, parameter 2, ...) -> expression;
    //                  Formal Parameter List (may or may not be in parenthesis);
    //                  The Arrow (->);
    //                  The Expression;
    //  Java INFERS the TYPE if there are any generics at play;
    //  Java INFERS the METHOD if the type extends a Functional Interface;   
    
    //  FUNCTIONAL INTERFACE 
    //  implements ONLY one Abstract Method;
    //  a.k.a. SAM: Single Abstract Method;
    //  The four categories of functional interfaces:                           
    //          CONSUMER    (execute code without returning data)               void accept(T t)                  
    //          FUNCTION    (return a result of an operation or function)       R apply(T t)
    //          PREDICATE   (test if a condition is true or false)              boolean test(T t)
    //          SUPPLIER    (return an instance of something)                   T get()

    record Person (String firstName, String lastName) {

        @Override
        public String toString() {
            return firstName + " " + lastName;
        }

    } 

    public static void main(String[] args) {
        
        List<Person> people = new ArrayList<>(List.of(
            new LambdaExpressions.Person("Lucy", "Van Pelt"),
            new Person("Sally", "Brown"),
            new Person("Linus", "Van Pelt"),
            new Person("Peppermint", "Patty"),
            new Person("Charlie", "Brown")
        ));

        //  OPTION 1: pass an Anonymous Class as comparator argument;
        people.sort(new Comparator<Person>() {

            @Override
            public int compare(Person o1, Person o2) {
                return o1.lastName().compareTo(o2.lastName());
            }
            
        });

        //  OPTION 2: assign the Anonymous Class to a reference and pass said reference as comaprator argument;
        var comparatorLastName = new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.lastName().compareTo(o2.lastName());
            } 
        };
        people.sort(comparatorLastName);

        //  OPTION 3: pass a Lambda Expression as comparator argument;
        people.sort((o1, o2) -> o1.lastName().compareTo(o2.lastName()));

        //  HOW DOES THIS (LAMBDA EXPRESSION) WORK?
        //  .sort() is expecting a type that implements Comparator as an argument;
        //  any type implementing comparator must implement the .compare() method with the correct signature;
        //  .compare() signature: int compare(T o1, T o2);
        //  if these rules are broken, there will be a compiler error;
        //  Lambda Expression: (o1, o2) -> o1.lastName().compareTo(o2.lastName());
        //  The first part (before the ->) is (o1, o2): these are the .compare() arguments;
        //  As their type is generic, it need not be specified;
        //  The second part (after the ->) is o1.lastName().compareTo(o2.lastName());
        //  Because we are calling .sort() on a List<People>, Java's compiler correctly infers generic T to be People;
        //  Therefore, o1 and o2 are infered to be People, so we can call on their .lastName();
        //  Finally, the .compareTo() returns an int;
        //  Our Lambda Expression respects the .compare() signature: int compare(T o1, T o2);
        //  No compiler errors;

        //  OPTION 4: Nested Interface (implicitly Static)
        interface EnhancedComparator<T> extends Comparator<T> {
            int secondLevel(T o1, T o2);
        }
        var comparatorMixed = new EnhancedComparator<Person>() {

            @Override
            public int compare(Person o1, Person o2) {
                int result = o1.lastName().compareTo(o2.lastName());
                return (result == 0 ? secondLevel(o1, o2) : result);
            }

            @Override
            public int secondLevel(Person o1, Person o2) {
                return o1.firstName().compareTo(o2.firstName());
            }

        };
        people.sort(comparatorMixed);

        //  With this option, you can add more functionality;
        //  Since your comparator is not restricted to a single method;
        //  But you cannot use Lambda Expression here, as the interface is not functional;

        System.out.println(people);
    }

}
