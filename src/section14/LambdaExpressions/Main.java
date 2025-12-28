package section14.LambdaExpressions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {
        
        int result = calculator((a, b) -> a + b, 5, 2);
        var result2 = calculator((a, b) -> a / b, 10.0, 2.5);
        var result3 = calculator((a, b) -> a.toUpperCase() + " " + b.toUpperCase(), "able", "archer");

        //  you may declare the types explicitly;
        //  if you declare an explicit type for one parameter, you must declare for all parameters!
        //  if you declare a var type for one parameter, you must declare all other parameters as var!
        //  explicit types and var dont mix!
        // var result4 = calculator((String a, var b) -> a + " " + b, "able", "archer");        //  compiler error!



        //  LAMBDAS and RETURN
        //  You MAY only use return in lambdas inside a code block (curly-braces);
        //  p.s. don't forget the semi-colon at the end of each statement!
        var result5 = calculator((a, b) -> {return a + b;}, 5, 2);
        //  if you have multiple statements inside a lambda that must return a type, you MUST use return;
        var result6 = calculator((a, b) -> {int number = a + b; return number;}, 5, 2);
        
        

        var result7 = binaryCalculator((a, b) -> a + b, 5, 2);



        //  BICONSUMER Interface
        //  Same as Consumer Interface, but with two arguments;
        var coords = Arrays.asList(
            new double[] {47.2160, -95.2348},
            new double[] {29.1566, -89.2495},
            new double[] {35.1556, -90.0659}
        );
        coords.forEach(s -> System.out.println(Arrays.toString(s)));

        //  Assigning a lambda expression to a variable doesn't actually run the code in the lambda expression;
        BiConsumer<Double,Double> p1 = (lat, lng) -> System.out.printf("[lat:%.3f lon:%.3f]%n", lat, lng);
        //  You need to pass the variable to the functional method (or to a method that calls it, as in this case);
        var firstPoint = coords.get(0);
        System.out.println("-".repeat(30));
        processPoint(firstPoint[0], firstPoint[1], p1);

        System.out.printf("%n%n%n" + "-".repeat(30) + "%n");
        coords.forEach(s -> processPoint(s[0], s[1], p1));

        //  NESTED LAMBDA EXPRESSION
        System.out.printf("%n%n%n" + "-".repeat(30) + "%n");
        coords.forEach(s -> processPoint(s[0], s[1], (lat, lng) -> System.out.printf("[lat:%.3f lon:%.3f]%n", lat, lng)));



        //  PREDICATE Interface
        System.out.printf("%n%n%n" + "-".repeat(30) + "%n");
        List<String> list = new ArrayList<>(List.of(
            "alpha",
            "bravo",
            "charlie",
            "delta"
        ));
        //  Predicate tests if a condition is true or false;
        list.removeIf(s -> s.equalsIgnoreCase("bravo"));
        list.forEach(s -> System.out.println(s));

        System.out.printf("-".repeat(30) + "%n");
        list.addAll(List.of("echo", "easy", "earnest"));
        list.forEach(s -> System.out.println(s));

        System.out.printf("-".repeat(30) + "%n");
        list.removeIf(s -> s.startsWith("ea"));
        list.forEach(s -> System.out.println(s));



        //  FUNCTION Interface
        System.out.printf("%n%n%n" + "-".repeat(30) + "%n");
        list.replaceAll(s -> s.charAt(0) + " - " + s.toUpperCase());
        list.forEach(s -> System.out.println(s));

        System.out.println("-".repeat(30));
        String[] emptyStrings = new String[10];
        System.out.println(Arrays.toString(emptyStrings));
        Arrays.fill(emptyStrings, "");
        System.out.println(Arrays.toString(emptyStrings));

        Arrays.setAll(emptyStrings, (i) -> "" + (i + 1) + ". ");
        System.out.println(Arrays.toString(emptyStrings));

        Arrays.setAll(emptyStrings, (i) -> "" + (i + 1) + ". "
            + switch (i) {
                case 0 -> "one";
                case 1 -> "two";
                case 2 -> "three";
                case 3 -> "four";
                default -> "";
            }
        );
        System.out.println(Arrays.toString(emptyStrings));



        //  SUPPLIER Interface
        System.out.printf("%n%n%n" + "-".repeat(30) + "%n");
        String[] names = {"Ann", "Bob", "Carol", "David", "Ed", "Fred"};
        String[] randomList = randomlySelectedValues(15, names, 
            () -> new Random().nextInt(0, names.length)
        );
        System.out.println(Arrays.toString(randomList));
        System.out.println("-".repeat(30));

    }

    public static <T> T calculator(Operation<T> function, T value1, T value2) {

        T result = function.operate(value1, value2);
        System.out.println("Result of operation: " + result);
        return result;

    } 

    public static <T> T binaryCalculator(BinaryOperator<T> function, T value1, T value2) {

        T result = function.apply(value1, value2);
        System.out.println("Result of operation: " + result);
        return result;

    } 

    public static <T> void processPoint(T t1, T t2, BiConsumer<T,T> consumer) {
        consumer.accept(t1, t2);
    }

    public static String[] randomlySelectedValues(int count, String[] values, Supplier<Integer> s) {

        String[] selectedValues = new String[count];
        for(int i = 0; i < count; i++) {
            selectedValues[i] = values[s.get()];
        }

        return selectedValues;

    }

}
