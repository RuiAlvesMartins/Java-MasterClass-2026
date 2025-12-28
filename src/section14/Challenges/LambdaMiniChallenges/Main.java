package section14.Challenges.LambdaMiniChallenges;

import java.util.Arrays;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class Main {
    
    //  MINI CHALLENGE #1
    //  Write the following anonymous class as a lambda expression:
    Consumer<String> printTheParts = new Consumer<String>() {
        public void accept(String sentence) {
            String[] parts = sentence.split(" ");
            for (String part : parts) {
                System.out.println(part);
            }
        }
    };



    //  MINI CHALLENGE #2
    //  Write the following method as a lambda expression:
    public static String everySecondChar(String source) {
        StringBuilder returnVal = new StringBuilder();
        for (int i = 0; i < source.length(); i++) {
            if (i % 2 == 1) {
                returnVal.append(source.charAt(i));
            }
        }
        return returnVal.toString();
    }



    //  MINI CHALLENGE #3
    //  Write code to execute this lambda expression:
    UnaryOperator<String> everySecondChar = source -> {
        StringBuilder returnVal = new StringBuilder();
        for (int i = 0; i < source.length(); i++) {
            if (i % 2 == 1) {
                returnVal.append(source.charAt(i));
            }
        }
        return returnVal.toString();
    };



    //  MINI CHALLENGE #4%5
    //  MINI CHALLENGE #6
    //  MINI CHALLENGE #7


    public static void main(String[] args) {
        
        //  MINI CHALLENGE #1
        String partsString = "part1, part2, part3, part4, part5";
        printStringParts(partsString, ", ", (s) -> System.out.println(s));
        
        System.out.println("-".repeat(30));

        Consumer<String> printStringPartsConsumer = sentence -> {
            Arrays.asList(sentence.split(", ")).forEach(part -> System.out.println(part));
        };
        printStringPartsConsumer.accept(partsString);

        System.out.printf("%n%n%n" + "-".repeat(30) + "%n");



        //  MINI CHALLENGE #2
        String stringN2 = "jeffreyepsteindidntdoithimself";

        String stringN3 = returnEverySecondChar(stringN2, string -> {
            String firstPart = "";
            String secondPart = "";
            char randomChar = ' ';
            String fullString = string;
            for (int i = 0; i < fullString.length(); i+=2) {
                firstPart = fullString.substring(0, i + 1);
                secondPart = fullString.substring(i + 1);
                randomChar = (char) new Random().nextInt(97, 123);
                // System.out.printf("firstPart = %s; secondPart = %s; char = %s%n", firstPart, secondPart, randomChar);
                fullString = firstPart + randomChar + secondPart;
                // System.out.println(fullString);
            }
            return fullString;
        });
        System.out.println(stringN3);

        String stringN4 = returnEverySecondChar(stringN3, string -> {
            String firstPart = "";
            String secondPart = "";
            String fullString = string;
            for (int i=0; i<fullString.length(); i++) {
                firstPart = fullString.substring(0, i+1);
                secondPart = fullString.substring(i+2);
                fullString = firstPart + secondPart;
                // System.out.printf("firstPart = %s; secondPart = %s%n", firstPart, secondPart);
                // System.out.println(fullString);
            }
            return fullString;
        });
        System.out.println(stringN4);
        System.out.println(stringN2.equals(stringN4));

        System.out.printf("%n%n%n" + "-".repeat(30) + "%n");



        //  MINI CHALLENGE #3
        UnaryOperator<String> everySecondChar = source -> {
            StringBuilder returnVal = new StringBuilder();
            for (int i = 0; i < source.length(); i++) {
                if (i % 2 == 1) {
                    returnVal.append(source.charAt(i));
                }
            }
            return returnVal.toString();
        };
        String stringN5 = everySecondChar.apply("1234567890");
        System.out.println(stringN5);

        System.out.printf("%n%n%n" + "-".repeat(30) + "%n");



        //  MINI CHALLENGE #4&5
        String stringN6 = returnEverySecondChar("1234567890", everySecondChar);
        System.out.println(stringN6);

        System.out.printf("%n%n%n" + "-".repeat(30) + "%n");



        //  MINI CHALLENGE #6
        Supplier<String> iLoveJava = () -> "I love Java!";
        Supplier<String> iLoveJavaToo = () -> {return "I love Java too!";};
        


        //  MINI CHALLENGE #7
        String supplierResult = iLoveJava.get();
        System.out.println(supplierResult);
        System.out.println(iLoveJavaToo.get());

    }

    static void printStringParts(String s, String delimitor, Consumer<String> c) {
        String[] partsArray = s.split(delimitor);
        for (String part : partsArray) {
            c.accept(part);
        }
    }

    static String returnEverySecondChar(String string, UnaryOperator<String> uo) {
        return uo.apply(string);
    }

}
