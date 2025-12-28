package section14.Challenges.MethodReferenceChallenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class Main {

    public static void main(String[] args) {
        
        String[] names = new String[] {"Anna", "Bob", "Charles", "David", "Eddie", 
                                        "Frank", "George", "Helen", "Ingrid", "John", "Kate"};

        // List<String> namesList = Arrays.asList(names);
        System.out.println(Arrays.toString(names));



        //  make each name upper case;
        UnaryOperator<String> upperCaseFunction = String::toUpperCase;
        //  add random middle initial;
        UnaryOperator<String> middleNameInitialFunction = string -> 
                            string + " " + (char) new Random().nextInt(65, 91) + ".";
        //  add last name, the reverse of the first;
        UnaryOperator<String> lastNameFunction = string -> {
            StringBuilder lastName = new StringBuilder(string.substring(0, string.indexOf(" "))).reverse();
            return string + " " + lastName.toString();
        };



        //  add custom transformations of my own;
        //  use mix of lambdas and methodRefs;
        UnaryOperator<String> lowerCaseFunction = String::toLowerCase;
        UnaryOperator<String> trimFunction = String::trim;
        UnaryOperator<String> upperCaseInitialsFunction = string -> {
            String[] stringParts = string.split(" ");
            // System.out.println(Arrays.toString(stringParts));
            String upperCasedInitials = "";
            for (String part : stringParts) {
                part = part.substring(0, 1).toUpperCase() + part.substring(1);
                upperCasedInitials += " " + part;
            }
            // return String.join(" ", stringParts);
            return upperCasedInitials;
        };
        UnaryOperator<String> printFunction = string -> {
            System.out.println(string);
            return string;
        };



        List<Function<String, String>> functions = new ArrayList<>();
        functions.add(upperCaseFunction);
        functions.add(middleNameInitialFunction);
        functions.add(lastNameFunction);
        functions.add(lowerCaseFunction);
        functions.add(trimFunction);
        functions.add(upperCaseInitialsFunction);
        functions.add(printFunction);


        //  all changes applied to original array!
        applyFunctions(names, functions);
        System.out.println(Arrays.toString(names));        

    }

    //  make method that takes name array and function list, and applies each function to each name using transform();
    static void applyFunctions(String[] stringArray, List<Function<String,String>> functionsList) {
        for (Function<String,String> function : functionsList) {
            for (int i = 0; i < stringArray.length; i++) {
                stringArray[i] = stringArray[i].transform(function);
                // function.apply(stringArray[i]);
                if (i == stringArray.length - 1) {
                    System.out.println(Arrays.toString(stringArray));
                }
            }
        }

    }
}
