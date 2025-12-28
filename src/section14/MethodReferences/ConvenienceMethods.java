package section14.MethodReferences;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class ConvenienceMethods {
    
    public static void main(String[] args) {
        
        //  CHAINING LAMBDAS

        //  Convenience methods for FUNCTION functional interface (and SubTypes);        
        String name = "Tim";
        Function<String,String> uCase = String::toUpperCase;
        System.out.println(uCase.apply(name));

        Function<String,String> lastName = s -> s.concat(" Buchalka");
        //  .andThen()
        //  runs lambda from where method is called first;
        //  and lamda argument second;
        Function<String,String> uCaseLastName = uCase.andThen(lastName);
        System.out.println(uCaseLastName.apply(name));

        //  .compose()
        //  runs lambda argument first;    
        //  and lambda from where method is called second;
        uCaseLastName = uCase.compose(lastName);
        System.out.println(uCaseLastName.apply(name));

        //  Your chained lambdas (or method references) don't have to return the same type!
        //  As long as you return the final type correctly, there is no problem;
        Function<String,String[]> f0 = uCase
                .andThen(s -> s.concat(" Buchalka"))
                .andThen(s -> s.split(" "));
        System.out.println(Arrays.toString(f0.apply(name)));

        Function<String,String> f1 = uCase
                .andThen(s -> s.concat(" Buchalka"))
                .andThen(s -> s.split(" "))
                .andThen(s -> s[1].toUpperCase() + ", " + s[0]);
        System.out.println(f1.apply(name));

        Function<String,Integer> f2 = uCase
                .andThen(s -> s.concat(" Buchalka"))
                .andThen(s -> s.split(" "))
                .andThen(s -> String.join(", ", s))
                .andThen(String::length);
        System.out.println(f2.apply(name));



        //  .andThen() is also valid for CONSUMER functional interface;
        //  Keep in mind that it's implementation is different: it returns nothing!
        String[] names = {"Ann", "Bob", "Carol"};
        Consumer<String> s0 = s -> System.out.print(s.charAt(0));
        Consumer<String> s1 = System.out::println;
        Arrays.asList(names).forEach(s0
            .andThen(s -> System.out.print(" - "))
            .andThen(s1)
        );



        //  Convenience methods for PREDICATE functional interface;
        Predicate<String> p1 = s -> s.equals("TIM");
        Predicate<String> p2 = s -> s.equalsIgnoreCase("Tim");
        Predicate<String> p3 = s -> s.startsWith("T");
        Predicate<String> p4 = s -> s.endsWith("e");

        //  .or()
        //  returns TRUE if any of the two arguments is true;
        Predicate<String> combined1 = p1.or(p2);
        System.out.println("combined1 = " + combined1.test(name));

        //  .and()
        //  returns TRUE if both arguments are true;
        Predicate<String> combined2 = p3.and(p4);
        System.out.println("combined2 = " + combined2.test(name));

        //  .negate()
        //  returns the oposite of the provided boolean argument;
        Predicate<String> combined3 = p3.and(p4).negate();
        System.out.println("combined3 = " + combined3.test(name));



        //  Convenience methods for COMPARATOR functional interface;
        //  You (probably) heard of .naturalOrder();
        //  You (probably) heard of .reverseOrder();
        //  Now hear this;
        record Person(String firstName, String lastName) {}

        List<Person> list = new ArrayList<>(Arrays.asList(
                new Person("Peter", "Pan"),
                new Person("Peter", "PumpkinEater"),
                new Person("Minnie", "Mouse"),
                new Person("Mickey", "Mouse")
        ));

        //  Because Person is local, you can directly access this record's fields;
        list.sort((o1, o2) -> o1.lastName.compareTo(o2.lastName));
        list.forEach(System.out::println);

        //  .comparing()
        //  static method that returns a Comparator;
        System.out.println("-".repeat(30));
        list.sort(Comparator.comparing(Person::lastName));
        list.forEach(System.out::println);

        //  .thenComparing()
        //  default method that returns a Comparator, and can be chained;
        System.out.println("-".repeat(30));
        list.sort(Comparator.comparing(Person::lastName)
                            .thenComparing(Person::firstName)
        );
        list.forEach(System.out::println);

        //  .reversed()
        //  default method that returns a reversed order Comparator;
        System.out.println("-".repeat(30));
        list.sort(Comparator.comparing(Person::lastName)
                            .thenComparing(Person::firstName)
                            .reversed()
        );
        list.forEach(System.out::println);

    }


}
