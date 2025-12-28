package section9.Arrays;

public class VarArgs {

    //  VARARGs

    //  traditional psvm signature:
    //  public static void main(String[] args) {}

    //  but psvm can also be written with this signature;
    //  public static void main(String... args) {} 
    public static void main(String... args) {
        
        //  these three dots are a VARARG (short for VARIABLE LENGTH ARGUMENTS);
        //  they essentially allow for zero, one or many strings (or other data types) be passed as arguments;
        //  they create an array (String[] args) with which to process them in the method;

        System.out.println("Hello World again");

        String[] splitStrings = "Hello World again".split(" ");
        printText(splitStrings);



        //  printText(String... textList)

        //  passing a single string;
        System.out.println("_".repeat(20));
        printText("Hello");

        //  passing multiple strings;
        System.out.println("_".repeat(20));
        printText("Hello", "World", "again");

        //  passing zero strings;
        System.out.println("_".repeat(20));
        printText();

        //  passing a String[];
        System.out.println("_".repeat(20));
        String[] stringArray = {"first", "second", "third", "fourth", "fifth"};
        printText(stringArray);
        // System.out.println(String.join(", ", stringArray));

    }



    //  We can use varargs on other methods, but must follow 2 rules;
    //  Rule #1: there can be only ONE vararg in the method;
    //  Rule #2: vararg must be the last argument;    

    // public static void printText(String[] textList) {}
    public static void printText(String... textList) {

        //  for each loop
        for (String s : textList) {
            System.out.println(s);
        }

    }

}
